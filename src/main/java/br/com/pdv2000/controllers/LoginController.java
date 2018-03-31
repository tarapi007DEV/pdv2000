/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pdv2000.controllers;

import br.com.pdv2000.daos.UsuariosDao;
import br.com.pdv2000.models.Usuario;
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
public class LoginController {

    @Autowired
    private UsuariosDao uDao;

    // EXEMPLO DE REQUEST MAPPING USANDO REQUEST PARAM
    @RequestMapping(value = "/login",
            method = {RequestMethod.GET, RequestMethod.POST},
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Resposta login(@RequestParam("username") String userName, @RequestParam("senha") String senha, Resposta resposta) {
        try {
            Usuario usuarioDoBanco = new UsuariosDao().get(userName, senha);
            if (usuarioDoBanco == null) {
                resposta.setStatus(-1);
                resposta.setMessage("Usuario nao foi encontrado.");
            } else {
                resposta.setStatus(1);
            }
            return resposta;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            resposta.setStatus(-1);
            resposta.setMessage("Erro na tentativa de recuperação do usuario.");
        }
        return resposta;
    }

    // EXEMPLO DE REQUEST MAPPING LISTANDO UM ARRAY DE ENTIDADES
    @RequestMapping(value = "/getAll")
    @ResponseBody
    public Usuario[] getAllUsuarios() {
        try {
            return uDao.getAll();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Resposta addByJsonPost(@RequestBody Usuario usuario, Resposta resposta) {
        uDao.insert(usuario);
        resposta.setStatus(1);
        return resposta;
    }

    @GetMapping("/delete")
    public Resposta delete(@RequestParam("id") int id, Resposta resposta) {
        uDao.delete(id);
        resposta.setStatus(1);
        return resposta;
    }

}
