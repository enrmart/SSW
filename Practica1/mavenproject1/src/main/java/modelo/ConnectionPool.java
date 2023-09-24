package modelo;

import java.sql.*;
import javax.sql.DataSource;
import javax.naming.InitialContext;

public class ConnectionPool {
    private static ConnectionPool pool = null;
    private static DataSource dataSource = null;


    private ConnectionPool() {
        try {
            InitialContext ic = new InitialContext();
            //En db_name se pone el noombre de nuestra base de datos.
            dataSource = (DataSource) ic.lookup("java:/comp/env/jdbc/mysql");
        }

        catch(Exception e) {
            e.printStackTrace();
        }
    }


    public static ConnectionPool getInstance() {
        if (pool == null) {
            pool = new ConnectionPool();
        }
        return pool;
    }



    public Connection getConnection() {

        try {
            return dataSource.getConnection();
        }   
        catch (SQLException sqle) {
            sqle.printStackTrace();
            return null;
        }
    }


    public void freeConnection(Connection c) {
        try {
            c.close();
        }

        catch (SQLException sqle) {
            sqle.printStackTrace();
        }
    }
}