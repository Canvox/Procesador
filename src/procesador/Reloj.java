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
public class Reloj {

    float tiempo;
    int ciclos;
    
    
    public Reloj() {
        this.tiempo = 0;
        this.ciclos = 0;
    }

    public float ciclos(float hertz) {
        float resultado = 0;
        resultado = 1 / hertz;
        return resultado;
    }

    
}
