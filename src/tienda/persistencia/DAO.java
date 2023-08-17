/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tienda.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.accessibility.AccessibleText;

/**
 *
 * @author Julieta Pilili
 */
public abstract class DAO {

    protected Connection connection = null;
    protected ResultSet resul = null;
    protected Statement statement = null;

    private final String USER = "root";
    private final String PASSWORD = "root";
    private final String DATABASE = "tienda";
    private final String DRIVER = "com.mysql.jdbc.Driver";

    protected void conectarBase() throws ClassNotFoundException, SQLException {
        try {
            Class.forName(DRIVER);
            String urlBaseDeDatos = "jdbc:mysql://localhost:3306/" + DATABASE + "?useSSL=false";
            connection = DriverManager.getConnection(urlBaseDeDatos, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException ex) {
            throw ex;
        }

    }

    protected void desconectarBase() throws Exception {
        try {
            if (connection != null) {
                connection.close();
            }
            if (resul != null) {
                resul.close();
            }
            if (statement != null) {
                statement.close();
            }
        } catch (Exception e) {
            throw e;
        }
    }

    protected void insertarModificarEliminar(String sql) throws Exception {

        try {
            conectarBase();
            statement = connection.createStatement();
            statement.executeUpdate(sql);
        } catch (ClassNotFoundException | SQLException ex) {
            /*connection.rollBack()
            es para que no se ejecute ninguna insercion ni nada si es que ocurre un error
            pero para esto deberiamos tener el autocommit en true:
            SET autocommit-1;
            COMMIT;
             */
            throw ex;
        } finally {
            desconectarBase();
        }

    }

    public void consultarBase(String sql) throws Exception{
        try {
            conectarBase();
            statement = connection.createStatement();
            resul = statement.executeQuery(sql);
        } catch (Exception e) {
            throw e;
        }
    }
    
    
}
