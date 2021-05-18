/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class ConnectionBD {
        
    String connectionUrl
            = "jdbc:sqlserver://"
            + "database=;"
            + "user=;"
            + "password=;"
          + "encrypt=true;";


    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(connectionUrl);
        
        
    }

    public PreparedStatement prepareStatement(String insertQuery) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}