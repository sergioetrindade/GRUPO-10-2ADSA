/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testeBd;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;


/**
 *
 * @author sergio.trindade
 */
public class TesteBanco {
    public static void main(String[] args) {

        // Cria um objeto da classe Connection
        // Esse objeto será usado para fazer a conexão com o SGBD
        Connection config = new Connection();
        
        /* Instancia um objeto da classe JdbcTemplate, que será usado para passar
           os comandos para o banco de dados.
           Ao instanciar esta classe, passamos como argumento para o construtor o 
           config.getDataSource()
        */
        JdbcTemplate con = new JdbcTemplate(config.getDataSource());
        
        // O comando SQL deve ser passado como uma String, dentro de aspas duplas
        // esse comando foi apenas um teste    
        //con.queryForList("select * from aluno;");
        //List<Object> retornoTeste = new ArrayList<>();
        //        con.queryForList("select * from usuario;");
                //System.out.println(con.queryForList("select * from usuario;"));
        
        // Para efetuar insert, delete, update na tabela, utilize o método con.update() 
        
        // Inserindo dados na tabela Pokemon
        // É possível colocar a instrução do insert como argumento para o con.update:
        //con.update("insert into Usuario values ('castionezicadms','urubu100')");
        String login = "luizberto";
        String senha = "urubu1@@";
        con.update("insert into Usuario values (?,?)", login, senha);
        
        List<Usuario> dadosComp = con.query("select * from Usuario",new BeanPropertyRowMapper(Usuario.class));
        System.out.println(dadosComp);
            
        
    }
}
