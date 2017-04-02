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
public class Procesador {

    BusControl busc = new BusControl();
    BusDatos busd = new BusDatos();
    BusDirecciones busdi = new BusDirecciones();
    Instruccion instruccion = new Instruccion();
    Memoria memoria = new Memoria();
    MemoriaPrincipal memoriap = new MemoriaPrincipal();
    Operacion operacion = new Operacion();
    Procesador procesador = new Procesador();
    Reloj reloj = new Reloj();
    UnidadControl ucontrol = new UnidadControl();
    UnidadTratamiento utratamiento = new UnidadTratamiento();

    public void gestion() {
        int i = 0;
        memoriap.carga();
        operacion.instruccionesUsuario();
        while (true) {
            this.instruccion = operacion.listaInstrucciones.get(i);
            if (this.instruccion.cop.compareTo("SU") == 0) {
                
            }
            if (this.instruccion.cop.compareTo("RE") == 0) {

            }
        }
    }
    
}
