
package dao.users;

import java.util.ArrayList;

public class CadastroUser {
    ArrayList<User> usuarios = new ArrayList();
    
    public void cadastroUser(User user){
        usuarios.add(user);
    }
    
    public String nomeUser(){
        return usuarios.toString();
    }
}
