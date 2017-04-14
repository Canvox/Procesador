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
    Operacion operacion;
    //Procesador procesador = new Procesador();
    Reloj reloj = new Reloj();
    UnidadControl ucontrol = new UnidadControl();
    UnidadTratamiento utratamiento = new UnidadTratamiento();

    public void gestion() {
        int i = 0;
        int j = 0;
        int result = 0;
        operacion = new Operacion();
        memoriap.carga();
        //operacion.InstruccionesRandom();
        operacion.instruccionesUsuario();
        while (true) {
            this.instruccion = operacion.listaInstrucciones.get(i);
            if (this.instruccion.cop.equals("SU")) {
                for (j = 0; j < this.memoriap.listarecuperada.size(); j++) {
                    if (this.operacion.listaInstrucciones.get(i).direccion.equals(this.memoriap.listarecuperada.get(j).direccion)) {
                        int a = Integer.parseInt(this.memoriap.listarecuperada.get(j).dato);
                        int b = Integer.parseInt(this.operacion.listaInstrucciones.get(i).dato);
                        result = a + b;
                        this.memoriap.listarecuperada.get(j).dato = Integer.toString(result);
                        System.out.println(result);
                        break;
                    }

                }
                break;
            }

            if (this.instruccion.cop.equals("RE")) {
                for (j = 0; j < this.memoriap.listarecuperada.size(); j++) {
                    if (this.operacion.listaInstrucciones.get(i).direccion.compareTo(this.memoriap.listarecuperada.get(j).direccion) == 0) {
                        int a = Integer.parseInt(this.memoriap.listarecuperada.get(j).dato);
                        int b = Integer.parseInt(this.operacion.listaInstrucciones.get(i).dato);
                        result = b - a;
                        this.memoriap.listarecuperada.get(j).dato = Integer.toString(result);
                        System.out.println(result);
                        break;
                    }
                }

                break;
            }

        }
    }

}
