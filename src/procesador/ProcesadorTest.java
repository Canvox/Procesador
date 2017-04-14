/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package procesador;

import java.util.Random;

/**
 *
 * @author INTEL-COREi7
 */
public class ProcesadorTest {

    MemoriaTest memoria = new MemoriaTest();
    MemoriaPrincipalTest memoriap = new MemoriaPrincipalTest();
    InstruccionTest instruccion = new InstruccionTest();

    UnidadControl ucontrol = new UnidadControl();

    BusControl busc = new BusControl();
    BusDatos busd = new BusDatos();
    BusDirecciones busdi = new BusDirecciones();

    Reloj reloj = new Reloj();

    UnidadTratamiento utratamiento = new UnidadTratamiento();

    int contador = 0;

    public void opcion(String cop) {
        switch (cop) {
            case "1010":

            case "102A":

            case "345F":

            case "202B":

            case "202C":

        }
    }

    public void fetchCycle() {
        ucontrol.PC = memoriap.listaMemoria.get(contador).direccion;
        utratamiento.AR = ucontrol.PC;
        busd.dato();
        utratamiento.DR = memoriap.listaMemoria.get(contador).instruccion.data;
        ucontrol.IR = memoriap.listaMemoria.get(contador).instruccion.cop;
        contador++;
    }

    public void executionCycle() {

    }

    public void load() {
        Random r = new Random();
        int Low = 0;
        int High = memoriap.listaMemoria.size();
        int Result = r.nextInt(High - Low) + Low;

        utratamiento.BufferRegistros[0] = memoriap.listaMemoria.get(Result).direccion;
        utratamiento.AR = utratamiento.BufferRegistros[0];
        for (int i = 0; i < memoriap.listaMemoria.size(); i++) {
            if (utratamiento.AR.equals(memoriap.listaMemoria.get(i).direccion)) {
                utratamiento.DR = memoriap.listaMemoria.get(i).instruccion.data;
            }
        }
        utratamiento.BufferRegistros[0] = utratamiento.DR;
    }

    public void call() {

    }

    public void push() {

    }

    public void pop() {

    }

    public void add() {

    }

    public void jump() {
        Random r = new Random();
        int Low = 0;
        int High = memoriap.listaMemoria.size();
        int Result = r.nextInt(High - Low) + Low;
        utratamiento.BufferRegistros[0] = memoriap.listaMemoria.get(Result).direccion;
        ucontrol.PC = utratamiento.BufferRegistros[0];
    }
}
