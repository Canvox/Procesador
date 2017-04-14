/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package procesador;

import static procesador.Operacion.scan;

/**
 *
 * @author INTEL-COREi7
 */
public class InstruccionTest {

    String cop;
    String dato;
    int longitud;

    public InstruccionTest() {
        this.cop = " ";
        this.dato = " ";
        this.longitud = 0;
    }

    public InstruccionTest(String cop, String dato, int longitud) {
        this.cop = cop;
        this.dato = dato;
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

    
    public void instruccionUsuario() {

        //Validar para que cumpla con formato hexadecimal, etc
        System.out.print("Ingrese cop: ");
        this.cop = scan.nextLine();
        valor();
        System.out.print("Ingrese dato: ");
        this.dato = scan.nextLine();

    }

    public void valor() {
        switch (this.cop) {
            case "LOAD":
                this.cop = "1010";
            case "ADD":
                this.cop = "102A";
            case "JUMP":
                this.cop = "345F";
            case "PUSH":
                this.cop = "202B";
            case "POP":
                this.cop = "202C";
        }
    }

    @Override
    public String toString() {
        return "InstruccionTest{" + "cop=" + cop + ", dato=" + dato + '}';
    }
    

}
