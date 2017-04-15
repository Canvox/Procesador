/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package procesador;

import java.io.Serializable;

/**
 *
 * @author INTEL-COREi7
 */
public class Memoria implements Serializable {
    //Usar expresiones regulares
    //String cop;
    String direccion;
    String dato;
    private static final double serialVersionUID = 41256789;

    public Memoria() {
        //this.cop = " ";
        this.direccion = " ";
        this.dato = " ";
    }
    
    public Memoria(String cop, String direccion, String dato) {
        //this.cop = cop;
        this.direccion = direccion;
        this.dato = dato;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDato() {
        return dato;
    }

    public void setDato(String dato) {
        this.dato = dato;
    }

    /*public String getCop() {
        return cop;
    }
    public void setCop(String cop) {
        this.cop = cop;
    }*/

    @Override
    public String toString() {
        return "Instruccion{" + /*"cop=" + cop + "*/ "direccion=" + direccion + ", dato=" + dato + '}';
    }
    
}