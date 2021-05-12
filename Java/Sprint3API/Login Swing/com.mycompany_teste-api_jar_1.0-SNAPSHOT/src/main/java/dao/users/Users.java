/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.users;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Sergio
 */
public class Users {

    public static void main(String[] args) {
        ArrayList<User> usuarios = new ArrayList();

        User usuario = new User("sergio", "urubu100");
        User usuario1 = new User("soares", "urubu100");

        usuarios.add(usuario);
        usuarios.add(usuario1);

        for (User u : usuarios) {
            System.out.println(u);
            System.out.println(u.getNome());
        }

    }
}
