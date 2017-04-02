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
public class UnidadTratamiento {

    String BufferRegistros[] = new String[15];
    String Banderas[] = new String[4];
    String ALU;
    String AR;
    String DR;
    String RT;

    public UnidadTratamiento() {
        this.ALU = " ";
        this.AR = " ";
        this.DR = " ";
        this.RT = " ";
    }

    public UnidadTratamiento(String ALU, String AR, String DR, String RT) {
        this.ALU = ALU;
        this.AR = AR;
        this.DR = DR;
        this.RT = RT;
    }

}
