/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pdv2000.daos;

import br.com.pdv2000.connection.ConnMngr;
import br.com.pdv2000.models.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.stereotype.Component;

/**
 *
 * @author Diego
 */
@Component
public class UsuariosDao {

    public Usuario get(String userName, String senha) throws SQLException, ClassNotFoundException {
        try {
            Usuario usuario = null;
            Connection conn = ConnMngr.getConnection();
            String sql = "select * from usuarios where username = ? and senha = ?";
            PreparedStatement pStmt = conn.prepareStatement(sql);
            pStmt.setString(1, userName);
            pStmt.setString(2, senha);
            ResultSet rSet = pStmt.executeQuery();
            while (rSet.next()) {
                if (usuario == null) {
                    usuario = new Usuario();
                }
                usuario.setId(rSet.getInt("id"));
                usuario.setNome(rSet.getString("nome"));
                usuario.setUserName(userName);
                usuario.setSenha(senha);
                // TODO RESTO
            }
            return usuario;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(UsuariosDao.class.getName()).log(Level.SEVERE, "Erro no get UsuariosDao", ex);
            throw ex;
        }
    }

    public Usuario[] getAll() throws SQLException, ClassNotFoundException {
        List<Usuario> usuariosList = new ArrayList<>();
        Usuario usuario = null;
        Usuario[] usuarios = null;
        try {
            Connection conn = ConnMngr.getConnection();
            String sql = "select * from usuarios order by id";
            PreparedStatement pStmt = conn.prepareStatement(sql);
            ResultSet rSet = pStmt.executeQuery();
            while (rSet.next()) {
                usuario = new Usuario();
                usuario.setId(rSet.getInt("id"));
                usuario.setNome(rSet.getString("nome"));
                usuario.setUserName(rSet.getString("username"));
                // TODO RESTO
            }
            return usuariosList.toArray(new Usuario[usuariosList.size()]);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(UsuariosDao.class.getName()).log(Level.SEVERE, "Erro no getAll UsuariosDao", ex);
            throw ex;
        }
    }

    public void insert(Usuario usuario) {
        throw new UnsupportedOperationException("TODO");
    }

    public void delete(int id) {
        throw new UnsupportedOperationException("TODO");
    }

}
