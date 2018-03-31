/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pdv2000.daos;

import br.com.pdv2000.connection.ConnMngr;
import br.com.pdv2000.models.Produto;
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
public class ProdutosDao {

    public Produto get(int id) throws SQLException, ClassNotFoundException {
        Produto produto = null;
        Connection conn = null; 
        String sql = "select * from produtos where id = :ID";
        try {
            conn = ConnMngr.getConnection();
            PreparedStatement pStmt = conn.prepareStatement(sql);
            pStmt.setInt(1, id);
            ResultSet rSet = pStmt.executeQuery();
            while(rSet.next()){
                if(produto == null)  produto = new Produto();
                produto.setId(rSet.getInt("id"));
                produto.setDescricao(rSet.getString("id"));
                // TODO RESTO
            }
            return produto;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ProdutosDao.class.getName()).log(Level.SEVERE, "Erro no get ProdutosDao", ex);
            throw ex;
        } finally{
            try {conn.close();} catch (Exception e) {};
        }
    }

    public Produto[] getAll() throws SQLException, ClassNotFoundException {
        List<Produto> produtosList = new ArrayList<>();
        Produto produto = null;
        Produto[] produtos = null;
        Connection conn = null;
        try {
            conn = ConnMngr.getConnection();
            String sql = "select * from produtos order by id";
            PreparedStatement pStmt = conn.prepareStatement(sql);
            ResultSet rSet = pStmt.executeQuery();
            while(rSet.next()){
                produto = new Produto();
                produto.setId(rSet.getInt("id"));
                produto.setDescricao(rSet.getString("descricao"));
                produtosList.add(produto);
                // TODO RESTO
            }
            return produtosList.toArray(new Produto[produtosList.size()]);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ProdutosDao.class.getName()).log(Level.SEVERE, "Erro no getAll ProdutosDao", ex);
            throw ex;
        } finally{
            try {conn.close();} catch (Exception e) {};
        }
    }

    public void insert(Produto produto) {
        throw new UnsupportedOperationException("TODO");
    }
    
    public void delete(int id) {
        throw new UnsupportedOperationException("TODO");
    }
    

}
