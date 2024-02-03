package com.lawal.transit.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connector {

    private static String server;
    private static String driver;
    private static final String user = "sa";
    private static final String password = "pass";

    private static String url;
    private String database;
    public static Connection connection;


    public Connector ()  {
        url = "jdbc:sqlserver://localhost;"
                + "database=transit;"
                + "integratedSecurity=True;"
                //+ "user=sa;"
                //+ "password=pass;"
                //+ "encrypt=true;"
                + "trustServerCertificate=true;"
                + "authenticationScheme=NTLM;";
        //       + "loginTimeout=30;";
        //connection = DriverManager.getConnection(url);
    } // close constructor

    public Connector (String driver, String server, String database, String user, String password) {
        url = driver
                +  ";" + server
                + ";" + database
                + ";" + user
                + ";" + password
                + "trustServerCertificate=true;authenticationScheme=NTLM;";
    } // close constructor

    public Connection getConnection ()  throws SQLException {
        connection = DriverManager.getConnection(url);
        return connection;
    }

} // end class Connector
