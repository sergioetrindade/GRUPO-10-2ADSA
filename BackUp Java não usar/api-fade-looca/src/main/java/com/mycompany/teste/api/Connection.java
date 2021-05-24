/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.teste.api;

import org.apache.commons.dbcp2.BasicDataSource;

/**
 *
 * @author Sérgio
 */
public class Connection {
    
    private BasicDataSource dataSource;
    
    public Connection() {
        dataSource = new BasicDataSource();
        dataSource​.setDriverClassName("\"com.mysql.cj.jdbc.Driver");
        dataSource​.setUrl("jdbc:mysql://localhost:3306/Localhost Fade");  
        dataSource​.setUsername("fade");
        dataSource​.setPassword("urubu1@@");   
    }
}
