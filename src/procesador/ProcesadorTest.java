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
    
    int hertz;

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
        reloj.ciclos +=3;
        memoriap.generar();
        utratamiento.llenar();
        ucontrol.PC = memoriap.listaMemoria.get(contador).direccion;
        utratamiento.AR = ucontrol.PC;
        busd.dato();
        utratamiento.DR = memoriap.listaMemoria.get(contador).instruccion.data;
        ucontrol.IR = memoriap.listaMemoria.get(contador).instruccion.cop;
        contador++;
        memoriap.mostrar();
    }

    public void executionCycle() {

    }

    public void load() {
        reloj.ciclos +=3;
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
        utratamiento.BufferRegistros[1] = utratamiento.DR;
    }

    public void call() {
        
    }

    public void push() {

    }

    public void pop() {

    }

    public void add() {
        load();
        
        reloj.ciclos +=2;
        
         Random r = new Random();
        int Low = 0;
        int High = memoriap.listaMemoria.size();
        int Result = r.nextInt(High - Low) + Low;
        
        utratamiento.BufferRegistros[0] = utratamiento.BufferRegistros[Result];
        
        utratamiento.RT = utratamiento.BufferRegistros[0];
        utratamiento.BufferRegistros[1] = utratamiento.BufferRegistros[1].substring(utratamiento.BufferRegistros[1].length() - 4);
        
        
        int RT = Integer.parseInt(utratamiento.RT, 16);
        int r7 = Integer.parseInt(utratamiento.BufferRegistros[1], 16);
        
        //Problema porque el r7 tiene el data (tiene mas digitos) que el RT
        int result = RT + r7;
        
        //Suponiendo que R0 sea el tercer puesto del Buffer De Registros
        utratamiento.BufferRegistros[2] = Integer.toString(result);
    }

    public void jump() {
        reloj.ciclos +=1;
        Random r = new Random();
        int Low = 0;
        int High = memoriap.listaMemoria.size();
        int Result = r.nextInt(High - Low) + Low;
        utratamiento.BufferRegistros[0] = memoriap.listaMemoria.get(Result).direccion;
        ucontrol.PC = utratamiento.BufferRegistros[0];
    }
    
    public void mostrar(){
        
        add();
        //jump();
        System.out.println("IR: " + ucontrol.IR);
        System.out.println("AR: " + utratamiento.AR);
        System.out.println("DR: " + utratamiento.DR);
        System.out.println("r7: " + utratamiento.BufferRegistros[0]);
        System.out.println("RD: " + utratamiento.BufferRegistros[1]);
        System.out.println("RT: " + utratamiento.RT);
        System.out.println("Ciclos (sin buses de entrada y salida): " + reloj.ciclos);
        velocidad();
        System.out.println("Velocidad del procesador: " + reloj.ciclos + " ns");
    }
    
    public void velocidad(){
        hertz = 25000;
        reloj.calculo(hertz);
    }
}
