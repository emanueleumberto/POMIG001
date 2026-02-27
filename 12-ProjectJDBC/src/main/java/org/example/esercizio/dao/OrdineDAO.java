package org.example.esercizio.dao;

import org.example.esercizio.DbConnection;
import org.example.esercizio.entities.Cliente;
import org.example.esercizio.entities.DettaglioOrdine;
import org.example.esercizio.entities.Ordine;
import org.example.esercizio.entities.Prodotto;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class OrdineDAO {

    public static void creaOrdine(Ordine ordine) throws SQLException {
        String sql = "INSERT INTO ordini (id_cliente) VALUES (?)";
        PreparedStatement ps = DbConnection.getInstance().getConn().prepareStatement(sql,  PreparedStatement.RETURN_GENERATED_KEYS);
        ps.setInt(1, ordine.getCliente().getIdCliente());
        ps.executeUpdate();
        ResultSet rs = ps.getGeneratedKeys();
        if(rs.next()){
            int id_ordine = rs.getInt(1);
            for (DettaglioOrdine d :  ordine.getDettaglioOrdine()) {
                sql = "INSERT INTO dettagli_ordine (id_ordine, id_prodotto, quantita, prezzo_unitario) VALUES (?, ?, ?, ?)";
                ps = DbConnection.getInstance().getConn().prepareStatement(sql);
                ps.setInt(1, id_ordine);
                ps.setInt(2, d.getProdotto().getIdProdotto());
                ps.setInt(3, d.getQuantita());
                ps.setDouble(4, d.getPrezzoUnitario());
                ps.executeUpdate();
            }
            System.out.println("Ordine inserito nel database!");
        }
    }

    public static Ordine leggiOrdine(int id) throws SQLException {
        String sql ="SELECT * FROM ordini AS o WHERE o.id_ordine = ?;";
        PreparedStatement ps = DbConnection.getInstance().getConn().prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            int idOrdine = rs.getInt("id_ordine");
            LocalDate dataOrdine = rs.getDate("data_ordine").toLocalDate();
            Cliente c = ClienteDAO.leggiCliente(rs.getInt("id_cliente"));
            List<DettaglioOrdine> dettaglioOrdine = leggiDettaglioOrdine(idOrdine);
            return new Ordine(idOrdine, c, dataOrdine, dettaglioOrdine);
        }
        return null;
    }

    private static List<DettaglioOrdine> leggiDettaglioOrdine(int idOrdine) throws SQLException {
        String sql ="SELECT * FROM dettagli_ordine WHERE id_ordine = ?;";
        PreparedStatement ps = DbConnection.getInstance().getConn().prepareStatement(sql);
        ps.setInt(1, idOrdine);

        List<DettaglioOrdine> dettaglioOrdini = new ArrayList<>();
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            int idDettaglio = rs.getInt("id_dettaglio_ordine");
            int quantita = rs.getInt("quantita");
            double prezzoUnitario = rs.getDouble("prezzo_unitario");
            Prodotto p =  ProdottoDAO.leggiProdotto(rs.getInt("id_prodotto"));
            dettaglioOrdini.add(new DettaglioOrdine(idDettaglio, p, quantita, prezzoUnitario));
        }
        return dettaglioOrdini;
    }

    public static void modificaOrdine(Ordine ordine) throws SQLException {
        String sql = "UPDATE ordini SET id_cliente=?, data_ordine=? WHERE  id_ordine=?;";
        PreparedStatement ps = DbConnection.getInstance().getConn().prepareStatement(sql);
        ps.setInt(1, ordine.getCliente().getIdCliente());
        ps.setDate(2, Date.valueOf(ordine.getData_ordine()));
        ps.setInt(3, ordine.getIdOrdine());
        ps.executeUpdate();

        for (DettaglioOrdine d :  ordine.getDettaglioOrdine()) {
            sql = "UPDATE  dettagli_ordine SET id_prodotto=?, quantita=?, prezzo_unitario=? WHERE  id_dettaglio_ordine=?;";
            ps = DbConnection.getInstance().getConn().prepareStatement(sql);
            ps.setInt(1, d.getProdotto().getIdProdotto());
            ps.setInt(2, d.getQuantita());
            ps.setDouble(3, d.getPrezzoUnitario());
            ps.setInt(4, d.getIdDettaglioOrdine());
            ps.executeUpdate();
        }
        System.out.println("Ordine modificato nel database!");
    }

    public static void eliminaOrdine(Ordine ordine) throws SQLException {
        String sql = "DELETE FROM ordini WHERE id_ordine=?;";
        PreparedStatement ps = DbConnection.getInstance().getConn().prepareStatement(sql);
        ps.setInt(1, ordine.getIdOrdine());
        ps.executeUpdate();
        System.out.println("Ordine eliminato dal database!");
    }

    public static List<Ordine> leggiTuttiOrdini() throws SQLException {
        String sql ="SELECT * FROM ordini";
        PreparedStatement ps = DbConnection.getInstance().getConn().prepareStatement(sql);
        List<Ordine> ordini = new ArrayList<>();
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            int idOrdine = rs.getInt("id_ordine");
            LocalDate dataOrdine = rs.getDate("data_ordine").toLocalDate();
            Cliente c = ClienteDAO.leggiCliente(rs.getInt("id_cliente"));
            List<DettaglioOrdine> dettaglioOrdine = leggiDettaglioOrdine(idOrdine);
            ordini.add(new Ordine(idOrdine, c, dataOrdine, dettaglioOrdine));
        }
        return ordini;
    }

}
