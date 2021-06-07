/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testeBd;

import org.apache.commons.dbcp2.BasicDataSource;

/** Classe Connection
 *
 *  Utilizada para fazer a conexão com o banco de dados SQL Azure
 *
 *   
 * @author Sergio
 */
public class Connection {
    
    // Atributo
    private final BasicDataSource dataSource;
    
    // Construtor
    public Connection() {
        dataSource = new BasicDataSource();
        
        dataSource.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        //dataSource.setUrl("jdbc:sqlserver://fadesolutions.database.windows.net:1433;");
        dataSource.setUrl("jdbc:sqlserver://fadesolutions.database.windows.net:1433;database=bdProjeto2sem;user=fadesolutions@fadesolutions;password={your_password_here};encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;");
        dataSource​.setUsername("fadesolutions");                 
        dataSource​.setPassword("urubu1@@");                                                    
    }
    
    // Getter do dataSource

    public BasicDataSource getDataSource() {
        return dataSource;
    }
    
    
}

