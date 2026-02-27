package org.example.esercizio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DbConnection {

    private String url = "jdbc:mysql://localhost:3306/";
    private String user = "root";
    private String pass = "root";
    private String dbName = "pomig001jdbc_esercizio";
    private String driver = "com.mysql.jdbc.Driver";
    private Connection conn;
    private Statement st;
    private static DbConnection instance;

    private DbConnection() throws SQLException {
        conn = DriverManager.getConnection(url,user,pass);
        st = conn.createStatement();
        createDatabase();
        createTableClienti();
        createTableProdotti();
        createTableOrdini();
        createTableDettagliOrdine();
    }

    private void createDatabase() throws SQLException {
        String sql = "CREATE DATABASE IF NOT EXISTS " + dbName;
        st.executeUpdate(sql);
        System.out.println("Database " + dbName + " connected successfully.");
        conn = DriverManager.getConnection(url+dbName,user,pass);
        st = conn.createStatement();
    }

    private void createTableClienti() throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS clienti (" +
                " id_cliente INT NOT NULL AUTO_INCREMENT," +
                " nome VARCHAR(100) NOT NULL," +
                " cognome VARCHAR(100) NOT NULL," +
                " email VARCHAR(150) NOT NULL," +
                " telefono VARCHAR(20) NULL," +
                " CONSTRAINT pk_cliente PRIMARY KEY(id_cliente)," +
                " CONSTRAINT uk_email UNIQUE(email)" +
                ");";
        st.executeUpdate(sql);
        System.out.println("Table Clienti created successfully.");
    }

    private void createTableProdotti() throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS prodotti (" +
                " id_prodotto INT NOT NULL AUTO_INCREMENT," +
                " nome VARCHAR(150) NOT NULL," +
                " descrizione TEXT NULL," +
                " prezzo DECIMAL(10,2) NOT NULL," +
                " quantita_disponibile INT NOT NULL," +
                " CONSTRAINT pk_prodotto PRIMARY KEY(id_prodotto)" +
                ");";
        st.executeUpdate(sql);
        System.out.println("Table Prodotti created successfully.");
    }

    private void createTableOrdini() throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS ordini (" +
                " id_ordine INT NOT NULL AUTO_INCREMENT," +
                " id_cliente INT NOT NULL," +
                " data_ordine TIMESTAMP DEFAULT CURRENT_TIMESTAMP," +
                " CONSTRAINT pk_ordine PRIMARY KEY(id_ordine)," +
                " CONSTRAINT fk_ordine_cliente FOREIGN KEY(id_cliente)" +
                " REFERENCES clienti(id_cliente) ON DELETE CASCADE" +
                ");";
        st.executeUpdate(sql);
        System.out.println("Table Ordini created successfully.");
    }

    private void createTableDettagliOrdine() throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS dettagli_ordine (" +
                " id_dettaglio_ordine INT NOT NULL AUTO_INCREMENT," +
                " id_ordine INT NOT NULL," +
                " id_prodotto INT NOT NULL," +
                " quantita INT NOT NULL," +
                " prezzo_unitario DECIMAL(10,2) NOT NULL," +
                " CONSTRAINT pk_dettaglio_ordine PRIMARY KEY(id_dettaglio_ordine)," +
                " CONSTRAINT fk1_dettaglio_ordine FOREIGN KEY(id_ordine)" +
                " REFERENCES ordini(id_ordine) ON DELETE CASCADE," +
                " CONSTRAINT fk2_dettaglio_ordine FOREIGN KEY(id_prodotto)" +
                " REFERENCES prodotti(id_prodotto) ON DELETE CASCADE" +
                ");";
        st.executeUpdate(sql);
        System.out.println("Table DettaglioOrdini created successfully.");
    }

    public static DbConnection getInstance() throws SQLException {
        if (instance == null) {
            instance = new DbConnection();
        }
        return instance;
    }

    public Connection getConn() {
        return conn;
    }
}
