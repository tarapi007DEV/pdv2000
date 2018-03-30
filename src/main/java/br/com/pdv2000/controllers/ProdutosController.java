/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pdv2000.controllers;

import br.com.pdv2000.daos.ProdutosDao;
import br.com.pdv2000.models.Produto;
import br.com.pdv2000.models.Resposta;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Diego
 */
@Controller
@RequestMapping("/produtos")
public class ProdutosController {

    @Autowired
    private ProdutosDao pDao;


    // EXEMPLO DE REQUEST MAPPING USANDO REQUEST PARAM
    @RequestMapping(value = "/get", //&sort[webname]
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Produto getProduto(@RequestParam("id") int id, Produto produto) {
        try {
            pDao.get(id);
            return produto;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ProdutosController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    // EXEMPLO DE REQUEST MAPPING LISTANDO UM ARRAY DE ENTIDADES
    @RequestMapping(value = "/getAll")
    @ResponseBody
    public Produto[] getAllProdutos() {
        try {
            return pDao.getAll();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ProdutosController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Resposta addByJsonPost(@RequestBody Produto produto, Resposta resposta) {
        pDao.insert(produto);
        resposta.setStatus(1);
        return resposta;
    }

    @GetMapping("/delete")
    public Resposta delete(@RequestParam("id") int id, Resposta resposta) {
        pDao.delete(id);
        resposta.setStatus(1);
        return resposta;
    }

}
