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
    float ciclos;
    
    
    public Reloj() {
        this.tiempo = 0;
        this.ciclos = 0;
    }

    public void calculo(float hertz) {
        ciclos = 1 / hertz;
    }

    
}
