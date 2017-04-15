/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package procesador;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.OptionalDataException;
import java.util.Random;
import java.util.Scanner;

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

    static Scanner scan = new Scanner(System.in);

    public void opcion(String cop) {
        //No pasarle el cop como parametro
        switch (memoriap.listaMemoria.get(contador).instruccion.cop) {
            case "1010":

                //contador++;
                load();
            case "102A":
                add();
            case "345F":
                jump();
            case "202B":

            case "202C":

        }
    }

    public void generar() {
        InterfazIngreso interfaz = new InterfazIngreso();
    }

    public void leer() {
        try {

            BufferedReader in = new BufferedReader(new FileReader("Memoria.txt"));

            String inputLine;

            while ((inputLine = in.readLine()) != null) {

                if (inputLine.isEmpty()) {
                    continue;
                }

                InputStream file = new FileInputStream("Memoria.txt");
                ObjectInput input = new ObjectInputStream(file);

                while (contador != 2) {
                    memoriap.listaMemoria.add((MemoriaTest)input.readObject());

                    // contador++;readLine
                }
            }
        } catch (IOException e) {
            e.getMessage();
        } catch (ClassNotFoundException e) {
            e.getMessage();
        }

    }
    
     public void mostrarMemoria() {

        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("Memoria.txt"));
            System.out.println(in.readObject());

            Object o;

            while ((o = in.readObject()) != null) {
                System.out.println(o.toString());
            }

        } catch (EOFException e) {
            System.out.println("Deadpool");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();

        }
     }

    public void fetchCycle() {
        this.leer();
        reloj.ciclos += 3;
        //memoriap.generar();
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
        reloj.ciclos += 3;
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

        reloj.ciclos += 2;

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
        reloj.ciclos += 1;
        Random r = new Random();
        int Low = 0;
        int High = memoriap.listaMemoria.size();
        int Result = r.nextInt(High - Low) + Low;
        utratamiento.BufferRegistros[0] = memoriap.listaMemoria.get(Result).direccion;
        ucontrol.PC = utratamiento.BufferRegistros[0];
    }

    public void mostrar() {

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

    public void velocidad() {
        hertz = 25000;
        reloj.calculo(hertz);
    }

    public void menu() {

        int op = 0;
        int contador = 0;

        while (op != 6) {

            System.out.println("\n---Microprocesador---");
            System.out.println("1. Interfaz");
            System.out.println("2. Procesador");

            System.out.println("6. Salir");
            System.out.print("Elija una opcion: ");

            op = scan.nextInt();

            switch (op) {
                case 1:
                    InterfazIngreso ingreso = new InterfazIngreso();
                    break;
                case 2:
                    this.fetchCycle();
                    //this.mostrarMemoria();
                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:

                    break;
                case 6:

                    break;
                default:

                    break;
            }
        }
    }
}
