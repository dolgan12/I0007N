package com.garpo.i0007n.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Conny Garpö on 4/23/2016.
 *
 * Singelton patern allows us to only have one database object
 */
public class MySQLDatabase {
    private static MySQLDatabase instance = new MySQLDatabase();

    // JDBC Drivers and db url
    static final String JDBC_DRIVER ="com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://mysql03.crossnet.net/LTUuser";

    // DB Login
    static final String USER = "LTUuser";
    static final String PASSWORD = "d0004n";

    private Connection conn;

    // Private constructor makes the any other class unable to instanciate.
    private MySQLDatabase(){

    }

    public Connection getConnection()throws Exception{
        connect();
        return conn;
    }
    public static MySQLDatabase getInstance(){
        return instance;
    }
    public void connect()throws Exception{
        if(conn != null){
            return;
        }
        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            throw new Exception("Driver not found");
        }
        String url = String.format(DB_URL);
        conn = DriverManager.getConnection(DB_URL,USER,PASSWORD);
    }

    public void disconnect() throws SQLException{
        if(conn != null){
            conn.close();
        }
        conn = null;
    }

}
