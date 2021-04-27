/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api;

        import java.sql.Connection;
        import java.sql.DriverManager;
        import java.sql.SQLException;

/**
 *
 * @author Sérgio
 */
public class ConectionBD {
        
    String urlConection = null;
    Connection connection = null;
   
 



    public ConectionBD (){
        urlConection = "";
//               urlConection
//                = "jdbc:mysql://localhost:3306"
//                + "/FadeSolutions,"
//                + "user=fade,"
//                + "password=urubu1@@;";

    }

    public String getUrlConection() {
        return urlConection;
    }

    public void setUrlConection(String urlConection) {
        this.urlConection = urlConection;
    }




    public Connection conectar()  {
        try{ 
            connection = DriverManager.getConnection(getUrlConection());
            System.out.println("-----Conectado com Sucesso------");
        }catch (SQLException e){
            System.out.println("-----ERRO NA CONEXÃO------" + e);

        }
        return connection;
    }
}
