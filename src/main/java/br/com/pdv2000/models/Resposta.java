/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pdv2000.models;

/**
 *
 * @author Diego
 */
public class Resposta {

    private int status;
    private String message;
    private Object[] objetos;

    public Resposta() {
    }

    public Resposta(int id) {

    }
    
    public Resposta(int id, String message) {

    }


    public Object[] getObjetos() {
        return objetos;
    }

    public void setObjetos(Object[] objetos) {
        this.objetos = objetos;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
