/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package procesador;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author INTEL-COREi7
 */
public class MemoriaTest implements Serializable {
    String direccion;
    InstruccionTest instruccion;
    private static final double serialVersionUID = 41256789;
    
    public MemoriaTest() {
        this.direccion = " ";
        this.instruccion = new InstruccionTest();
    }

    public MemoriaTest(String direccion, InstruccionTest instruccion) {
        this.direccion = direccion;
        this.instruccion = instruccion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public InstruccionTest getInstruccion() {
        return instruccion;
    }

    public void setInstruccion(InstruccionTest instruccion) {
        this.instruccion = instruccion;
    }

    @Override
    public String toString() {
        return "MemoriaTest{" + "direccion=" + direccion + ", " + instruccion.toString()+"}";
    }

    
    
}
