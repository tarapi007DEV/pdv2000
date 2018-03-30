/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pdv2000.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Diego
 */
public class ConnMngr {
    public static Connection getConnection() throws SQLException, ClassNotFoundException{
        try {
            Class.forName("org.firebirdsql.jdbc.FBDriver");
            return DriverManager.getConnection("jdbc:firebirdsql:127.0.0.1:c:/PROJETOS/GIT PROJECTS/pdv2000/DB/pdv2000.fdb", "sysdba", "masterkey");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ConnMngr.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Erro ao tentar recuperar conexão.");
            throw ex;
        }
    }
}
