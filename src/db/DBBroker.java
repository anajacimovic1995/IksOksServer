/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import domen.DomainObject;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/**
 *
 * @author Miroslav
 */
public class DBBroker {

    private static DBBroker instance;
    private Connection connection;
    private final DBResources dbr;

    private DBBroker() throws IOException, FileNotFoundException, SQLException {
        dbr = new DBResources();
    }

    public static DBBroker getInstance() throws FileNotFoundException, SQLException {
        if (instance == null) {
            try {
                instance = new DBBroker();
            } catch (IOException ex) {
                System.out.println("Nije napravljena instanca brokera");
            }
        }
        return instance;
    }

    public void loadDriver() throws ClassNotFoundException {
        Class.forName(dbr.getDriver());
    }

    public void openConnection() throws SQLException {
        connection = DriverManager.getConnection(dbr.getUrl(), dbr.getUsername(), dbr.getPassword());
        connection.setAutoCommit(false);
    }

    public void closeConnection() throws SQLException {
        connection.close();
    }

    public void commit() throws SQLException {
        connection.commit();
    }

    public void rollback() throws SQLException {
        connection.rollback();
    }

    public void insert(DomainObject gdo) throws SQLException {
        String sql = "INSERT INTO " + gdo.vratiImeTabele() + "(" + gdo.getColumnNames() + ")" + " VALUES (" + gdo.getValueInsert() + ")";
        System.out.println(sql);
        Statement s = connection.createStatement();
        s.executeUpdate(sql);
        s.close();
    }

    public ResultSet select(DomainObject gdo) throws SQLException {
        String sql = "SELECT " + gdo.getColumnNamesForSelect() + " FROM " + gdo.vratiImeTabele() + " as " + gdo.getAlias()
                + gdo.getJoinCondition() + gdo.getWhereCondition() + gdo.getGrouping();
        System.out.println(sql);
        Statement s = connection.createStatement();
        ResultSet rs = s.executeQuery(sql);
        return rs;
    }

    public void update(DomainObject gdo) throws SQLException {
        String sql = "UPDATE " + gdo.vratiImeTabele() + " SET " + gdo.getValueUpdate() + gdo.getWhereUpdateCondition();
        System.out.println(sql);
        Statement s = connection.createStatement();
        s.executeUpdate(sql);
        s.close();
    }

    public void delete(DomainObject gdo) throws SQLException {
        String sql = "DELETE FROM " + gdo.vratiImeTabele() + " WHERE " + gdo.getWhereDeleteCondition();
        System.out.println(sql);
        Statement s = connection.createStatement();
        s.executeUpdate(sql);
        s.close();
    }

    public int getMaxId(DomainObject gdo) throws SQLException {
        int max = 0;
        String sql = "SELECT max(" + gdo.getMaxKey() + ") as maksKljuc FROM " + gdo.vratiImeTabele() + gdo.getWhereMaxIdCondition();
        System.out.println(sql);
        Statement s = connection.createStatement();
        ResultSet rs = s.executeQuery(sql);
        while (rs.next()) {
            max = rs.getInt("maksKljuc");
        }
        return max;
    }

    public ResultSet selectById(DomainObject gdo) throws SQLException {
        String sql = "SELECT * FROM " + gdo.vratiImeTabele() + " as " + gdo.getAlias()
                + gdo.getJoinCondition() + gdo.getIdCondition();
        System.out.println(sql);
        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery(sql);
        //rs.next()
        gdo = gdo.ucitajListu(rs).get(0);

        return rs;
    }

    public ResultSet selectSve(DomainObject gdo) throws SQLException {
        String sql = "SELECT " + gdo.getColumnNamesForSelect() + " FROM " + gdo.vratiImeTabele() + " as " + gdo.getAlias()
                + gdo.getJoinCondition() + gdo.getGrouping();
        System.out.println(sql);
        Statement s = connection.createStatement();
        ResultSet rs = s.executeQuery(sql);
        return rs;
    }
    
    
    
}
