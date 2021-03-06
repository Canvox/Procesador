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
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

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
    int contador2 = 0;
    int sp = 0;

    static Scanner scan = new Scanner(System.in);

    JFrame frame = new JFrame();
    ImageIcon image;

    public void opcion(String cop) {
        //No pasarle el cop como parametro
        switch (memoriap.listaMemoria.get(contador).instruccion.cop) {
            case "1010":
                load();
            case "102A":
                add();
            case "345F":
                jump();
            case "202B":
                call();
            case "202C":
                retorno();
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
                    memoriap.listaMemoria.add((MemoriaTest) input.readObject());

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
        System.out.println("\n(Inicializando captacion de datos ...)");
        reloj.ciclos += 3;
        //memoriap.generar();
        utratamiento.llenar();
        ucontrol.PC = memoriap.listaMemoria.get(contador).direccion;
        utratamiento.AR = ucontrol.PC;
        busd.dato();
        utratamiento.DR = memoriap.listaMemoria.get(contador).instruccion.data;
        ucontrol.IR = memoriap.listaMemoria.get(contador).instruccion.cop;
        contador++;
        System.out.println("Captacion exitosa!");
        System.out.println("(Listado memorias captadas: )");
        this.mostrarMemoriaProcesador();
        image = new ImageIcon("image4.png");
        JOptionPane.showMessageDialog(frame, "Captacion exitosa!", "Captacion de Datos", JOptionPane.INFORMATION_MESSAGE, image);
    }

    public void executionCycle() {
        if (contador2 >= memoriap.listaMemoria.size()) {
            System.out.println("No existen mas instrucciones a ejecutarse!");
            JOptionPane.showMessageDialog(frame, "No existen mas instrucciones a ejecutarse!", "Advertencia", JOptionPane.WARNING_MESSAGE);
            memoriap.listaMemoria.clear();
            contador = 0;
            contador2 = 0;
            try {
                PrintWriter pw = new PrintWriter("Memoria.txt");
                pw.print("");                             
                pw.close();
            } catch (FileNotFoundException e) {
                e.getMessage();
            }
        } else {
            switch (memoriap.listaMemoria.get(contador2).instruccion.cop) {
                case "1010":
                    this.load();
                    break;
                case "102A":
                    this.load();
                    this.add();
                    break;
                case "345F":
                    this.jump();
                    break;
                case "202B":
                    this.call();
                    break;
                case "202C":
                    this.retorno();
                    break;
                       
            }
            contador2++;
        }
    }

    public void load() {
        System.out.println("\n(Inicializando carga de datos...)");
        reloj.ciclos += 3;
        Random r = new Random();
        int Low = 0;
        int High = memoriap.listaMemoria.size();
        int Result = r.nextInt(High - Low) + Low;

        utratamiento.BufferRegistros[0] = memoriap.listaMemoria.get(Result).direccion;
        utratamiento.AR = utratamiento.BufferRegistros[0];
        for (int i = 0; i < memoriap.listaMemoria.size(); i++) {
            if (utratamiento.AR.equals(memoriap.listaMemoria.get(i).direccion)) {
                busd.dato();
                utratamiento.DR = memoriap.listaMemoria.get(i).instruccion.data;
            }
        }
        utratamiento.BufferRegistros[1] = memoriap.listaMemoria.get(Result).instruccion.dato;
        System.out.println("Buffer de Registros cargados exitosamente!");
    }

    public void call(){
        
        ucontrol.leer();
        utratamiento.AR = ucontrol.StackPointer.get(sp).direccion;
        busd.dato();
        utratamiento.DR = ucontrol.StackPointer.get(sp).instruccion.dato;
        ucontrol.PC = utratamiento.AR;
        System.out.println("Llamado exitoso!");
        
        //ucontrol.mostrar();
    }
    
    public void retorno(){
        this.call();
        System.out.println("(Inicializando retorno ...)");
        sp++;
        utratamiento.AR = ucontrol.StackPointer.get(sp).direccion;
        utratamiento.DR = ucontrol.PC;
        busdi.dato();
        utratamiento.AR = utratamiento.DR;
        ucontrol.PC = utratamiento.BufferRegistros[0];
        System.out.println("Retorno exitoso!");
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
        utratamiento.BufferRegistros[1] = utratamiento.BufferRegistros[Result];

        int RT = Integer.parseInt(utratamiento.RT, 16);
        int r7 = Integer.parseInt(utratamiento.BufferRegistros[1], 16);

        System.out.println("---Procesando suma...---");
        //Problema porque el r7 tiene el data (tiene mas digitos) que el RT
        int result = RT + r7;

        //Suponiendo que R0 sea el tercer puesto del Buffer De Registros
        utratamiento.BufferRegistros[2] = Integer.toString(result);
        System.out.println("Suma exitosa!");
    }

    public void jump() {
        System.out.println("\n(Inicializando salto ...)");
        reloj.ciclos += 1;
        Random r = new Random();
        int Low = 0;
        int High = memoriap.listaMemoria.size();
        int Result = r.nextInt(High - Low) + Low;
        busdi.dato();
        utratamiento.BufferRegistros[0] = memoriap.listaMemoria.get(Result).direccion;
        ucontrol.PC = utratamiento.BufferRegistros[0];
        System.out.println("Salto exitoso!");
    }
    
    public void mostrarMemoriaProcesador() {
        for (int i = 0; i < memoriap.listaMemoria.size(); i++) {
            System.out.println(memoriap.listaMemoria.get(i).toString());
        }
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
            System.out.println("1. Interfaz de Ingreso");
            System.out.println("2. Captacion de Datos");
            System.out.println("3. Ejecucion de Datos");
            System.out.println("4. Interfaz de Salida");
            System.out.println("6. Salir");
            System.out.print("Elija una opcion: ");

            op = scan.nextInt();

            switch (op) {
                case 1:
                    InterfazIngreso ingreso = new InterfazIngreso();
                    break;
                case 2:
                    //mostrarMemoria();
                    this.fetchCycle();
                    //this.mostrarMemoria();
                    break;
                case 3:
                    this.executionCycle();
                    break;
                case 4:
                    Interfaz salida = new Interfaz(ucontrol, utratamiento);
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
