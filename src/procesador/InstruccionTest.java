/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package procesador;

import java.io.Serializable;
import java.util.Scanner;

/**
 *
 * @author INTEL-COREi7
 */
public class InstruccionTest implements Serializable {

    String cop;
    String dato;
    String data;
    int longitud;
    
    private static final double serialVersionUID = 41256768;
    
    static Scanner scan = new Scanner(System.in);

    public InstruccionTest() {
        this.cop = " ";
        this.dato = " ";
        this.data = " ";
        this.longitud = 0;
    }

    public InstruccionTest(String cop, String dato, String data, int longitud) {
        this.cop = cop;
        this.dato = dato;
        this.data = data;
        this.longitud = longitud;
    }

    public String getCop() {
        return cop;
    }

    public void setCop(String cop) {
        this.cop = cop;
    }

    public String getDato() {
        return dato;
    }

    public void setDato(String dato) {
        this.dato = dato;
    }

    public int getLongitud() {
        return longitud;
    }

    public void setLongitud(int longitud) {
        this.longitud = longitud;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
    
    public void instruccionUsuario() {

        //Validar para que cumpla con formato hexadecimal, etc
        System.out.print("Ingrese cop: ");
        this.cop = scan.nextLine();
        valor(this.cop);
        System.out.print("Ingrese dato: ");
        this.dato = scan.nextLine();

        this.data = this.cop.concat(this.dato);
    }

    public void valor(String cop) {
        switch (this.cop) {
            case "LOAD":
                this.cop = "1010";
                break;
            case "ADD":
                this.cop = "102A";
                break;
            case "JUMP":
                this.cop = "345F";
                break;
            case "CALL":
                this.cop = "202B";
                break;
            case "RETURN":
                this.cop = "202C";
                break;
        }
    }
    
    

    @Override
    public String toString() {
        return "InstruccionTest{" + "cop=" + cop.toUpperCase() + ", dato=" + dato + '}';
    }
    

}
