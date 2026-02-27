package org.example.esercizio.dao;

import org.example.User;
import org.example.esercizio.DbConnection;
import org.example.esercizio.entities.Cliente;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {

    // CRUD Cliente

    public static void salvaCliente(Cliente cliente) throws SQLException {
        String sql = "INSERT INTO clienti (nome, cognome, email, telefono) " +
                " VALUES (?, ?, ?, ?);";
        PreparedStatement ps = DbConnection.getInstance().getConn().prepareStatement(sql);
        ps.setString(1, cliente.getNome());
        ps.setString(2, cliente.getCognome());
        ps.setString(3, cliente.getEmail());
        ps.setString(4, cliente.getTelefono());
        ps.executeUpdate();
        System.out.println("Cliente " + cliente.getNome() + " " + cliente.getCognome() + " created successfully.");
    }

    public static Cliente leggiCliente(int id) throws SQLException {
        String sql = "SELECT * FROM clienti WHERE id_cliente = ?;";
        PreparedStatement ps = DbConnection.getInstance().getConn().prepareStatement(sql);
        ps.setInt(1, id);

        ResultSet rs = ps.executeQuery(); // null | row
        if(rs.next()){
            int id_cliente = rs.getInt("id_cliente");
            String nome = rs.getString("nome");
            String cognome = rs.getString("cognome");
            String email = rs.getString("email");
            String telefono = rs.getString("telefono");

            return new Cliente(id_cliente,nome,cognome,email,telefono);
        }
        return null;
    }

    public static void modificaCliente(Cliente cliente) throws SQLException {
        String sql = "UPDATE clienti SET nome=?,cognome=?,email=?,telefono=?  WHERE id_cliente=?;";
        PreparedStatement ps = DbConnection.getInstance().getConn().prepareStatement(sql);
        ps.setString(1, cliente.getNome());
        ps.setString(2, cliente.getCognome());
        ps.setString(3, cliente.getEmail());
        ps.setString(4, cliente.getTelefono());
        ps.setInt(5, cliente.getIdCliente());
        ps.executeUpdate();
        System.out.println("User " + cliente.getNome() + " " + cliente.getCognome() + " modified successfully.");
    }

    public static void eliminaCliente(Cliente cliente) throws SQLException {
        String sql = "DELETE FROM clienti WHERE id_cliente = ?;";
        PreparedStatement ps = DbConnection.getInstance().getConn().prepareStatement(sql);
        ps.setInt(1, cliente.getIdCliente());
        ps.executeUpdate();
        System.out.println("User " + cliente.getNome() + " " + cliente.getCognome() + " deleted successfully.");
    }

    public static List<Cliente> leggiTuttiClienti() throws SQLException {
        String sql = "SELECT * FROM clienti;";
        PreparedStatement ps = DbConnection.getInstance().getConn().prepareStatement(sql);

        List<Cliente> listaCliente = new ArrayList<Cliente>();
        ResultSet rs = ps.executeQuery(); // null | row
        while (rs.next()){
            int id_cliente = rs.getInt("id_cliente");
            String nome = rs.getString("nome");
            String cognome = rs.getString("cognome");
            String email = rs.getString("email");
            String telefono = rs.getString("telefono");

            listaCliente.add(new Cliente(id_cliente,nome,cognome,email,telefono));
        }
        return listaCliente;
    }
}
