
package dao.users;

public class User {
    private String nome, password;
    
    public User(){
        
    }

    public User(String nome, String password) {
        this.nome = nome;
        this.password = password;
    }
  

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "User{" + "nome=" + nome + ", password=" + password + '}';
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
}
