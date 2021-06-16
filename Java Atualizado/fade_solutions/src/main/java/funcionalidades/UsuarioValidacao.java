
package funcionalidades;

import conecaoBanco.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class UsuarioValidacao {
    String getLogin = "Sergio";
    
    private Connection conectoryFactory;
    private String login1;

    public UsuarioValidacao() {
        Conexao connection = new Conexao();
        try {
            this.conectoryFactory = connection.getConnection();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public String getLogin1() {
        return login1;
    }
    
    
   public Boolean login(String login, String senha) {
       
       
        login1 = login;
       
        PreparedStatement stn = null;
        Boolean userLoged = false;
      
        try {
            String sql = "select * from dbo.usuario where login = ? and senha = ?;";
            stn = conectoryFactory.prepareStatement(sql);
            stn.setString(1, login);
            stn.setString(2, senha);
            
            boolean userExists = stn.executeQuery().next();

            if(userExists){
                userLoged = true;
                JOptionPane.showMessageDialog(null, "Login feito com sucesso");
                conectoryFactory.close();
            }else{
                userLoged = false;
                JOptionPane.showMessageDialog(null, "Usuario ou senha incorreto");
                conectoryFactory.close();
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return userLoged;
    }
    
}
