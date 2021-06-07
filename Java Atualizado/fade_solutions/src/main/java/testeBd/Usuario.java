/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testeBd;

/**
 *
 * @author sergio.trindade
 */
public class Usuario {
    // Atributos - os nomes e os tipos devem ser os mesmos das colunas da tabela do BD
    private Integer idUsuario;
    private String login;   
    private String senha;

    @Override
    public String toString() {
        return "Usuario{" + "idUsuario=" + idUsuario +
                ", login=" + login + 
                ", senha=" + senha + '}';
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    
}
