package org.example.esercizio.dao;

import org.example.esercizio.DbConnection;
import org.example.esercizio.entities.Cliente;
import org.example.esercizio.entities.Prodotto;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProdottoDAO {

    // CRUD Prodotto

    public static void salvaProdotto(Prodotto prodotto) throws SQLException {
        String sql = "INSERT INTO prodotti (nome, descrizione, prezzo, quantita_disponibile) " +
                " VALUES (?, ?, ?, ?);";
        PreparedStatement ps = DbConnection.getInstance().getConn().prepareStatement(sql);
        ps.setString(1, prodotto.getNome());
        ps.setString(2, prodotto.getDescrizione());
        ps.setDouble(3, prodotto.getPrezzo());
        ps.setInt(4, prodotto.getQuantitaDisponibile());
        ps.executeUpdate();
        System.out.println("Prodotto " + prodotto.getNome() + " created successfully.");
    }

    public static Prodotto leggiProdotto(int id) throws SQLException {
        String sql = "SELECT * FROM prodotti WHERE id_prodotto = ?;";
        PreparedStatement ps = DbConnection.getInstance().getConn().prepareStatement(sql);
        ps.setInt(1, id);

        ResultSet rs = ps.executeQuery(); // null | row
        if(rs.next()){
            int id_prodotto = rs.getInt("id_prodotto");
            String nome = rs.getString("nome");
            String descrizione = rs.getString("descrizione");
            double prezzo = rs.getDouble("prezzo");
            int quantita = rs.getInt("quantita_disponibile");

            return new Prodotto(id_prodotto,nome,descrizione,prezzo,quantita);
        }
        return null;
    }

    public static void modificaProdotto(Prodotto prodotto) throws SQLException {
        String sql = "UPDATE prodotti SET nome=?,descrizione=?,prezzo=?,quantita_disponibile=?  WHERE id_prodotto=?;";
        PreparedStatement ps = DbConnection.getInstance().getConn().prepareStatement(sql);
        ps.setString(1, prodotto.getNome());
        ps.setString(2, prodotto.getDescrizione());
        ps.setDouble(3, prodotto.getPrezzo());
        ps.setInt(4, prodotto.getQuantitaDisponibile());
        ps.setInt(5, prodotto.getIdProdotto());
        ps.executeUpdate();
        System.out.println("Prodotto " + prodotto.getNome() + " modified successfully.");
    }

    public static void eliminaProdotto(Prodotto prodotto) throws SQLException {
        String sql = "DELETE FROM prodotti WHERE id_prodotto = ?;";
        PreparedStatement ps = DbConnection.getInstance().getConn().prepareStatement(sql);
        ps.setInt(1, prodotto.getIdProdotto());
        ps.executeUpdate();
        System.out.println("Prodotto " + prodotto.getNome() + " deleted successfully.");
    }

    public static List<Prodotto> leggiTuttiProdotti() throws SQLException {
        String sql = "SELECT * FROM prodotti;";
        PreparedStatement ps = DbConnection.getInstance().getConn().prepareStatement(sql);

        List<Prodotto> listaProdotti = new ArrayList<Prodotto>();
        ResultSet rs = ps.executeQuery(); // null | row
        while (rs.next()){
            int id_prodotto = rs.getInt("id_prodotto");
            String nome = rs.getString("nome");
            String descrizione = rs.getString("descrizione");
            double prezzo = rs.getDouble("prezzo");
            int quantita = rs.getInt("quantita_disponibile");

            listaProdotti.add(new Prodotto(id_prodotto,nome,descrizione,prezzo,quantita));
        }
        return listaProdotti;
    }
}
