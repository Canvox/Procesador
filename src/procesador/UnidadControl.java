/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package procesador;

/**
 *
 * @author INTEL-COREi7
 */
public class UnidadControl {

    String PC;
    String IR; //Deberia ser de tipo de Instruccion
    Reloj reloj = new Reloj();

    public UnidadControl() {
        this.PC = " ";
        this.IR = " ";
        this.reloj = new Reloj();
    }

}
