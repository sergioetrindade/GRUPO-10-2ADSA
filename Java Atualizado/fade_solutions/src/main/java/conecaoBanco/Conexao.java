package conecaoBanco;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

public class Conexao {

    String connectionUrl
                = "jdbc:sqlserver://fadesolutions.database.windows.net:1433;database=bdProjeto2sem;user=fadesolutions@fadesolutions;password={your_password_here};encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;"
                + "database=bdProjeto2sem;"
                + "user=fadesolutions;"
                + "password=urubu1@@;"
            + "encrypt=true;";

    
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(connectionUrl);
    }
    

    
    
  public Connection getConnectionDocker() throws SQLException, ClassNotFoundException{
      Class.forName ("com.mysql.cj.jdbc.Driver");
      return DriverManager.getConnection("jdbc:mysql://locallhost:3306/fadesolutions", "root", "urubu100");
  };
    
 
}

