/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package procesador;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.OptionalDataException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author INTEL-COREi7
 */
public class Operacion {

    private static final char[] CHARSET_AF_09 = "ABCDEF0123456789".toCharArray();
    private static final char[] CHARSET_01 = "01".toCharArray();
    private static final char[] CHARSET_09 = "0123456789".toCharArray();
    private String[] cops = {"SU", "RE"};

    ArrayList<Instruccion> listaInstrucciones = new ArrayList<>();
    ArrayList<Memoria> listaMemoria = new ArrayList<>();
    
    Instruccion instruccion = new Instruccion();
    MemoriaPrincipal memoriap = new MemoriaPrincipal();
    Memoria memoria = new Memoria();
    static Scanner scan = new Scanner(System.in);

    public void instruccionesUsuario() {
        int op = 0;
        memoriap.carga();
        for (int i = 0; i < memoriap.listarecuperada.size(); i++) {
            System.out.println(memoriap.listarecuperada.get(i).toString());
            
        }
        while (op != -1) {
            
            System.out.print("Ingrese cop: ");
            instruccion.cop = scan.nextLine();
            
            //Validar que sea una de las instrucciones dadas
            System.out.print("Ingrese direccion: ");
            instruccion.direccion = scan.nextLine();
            //Validar 4 digitos (Max hasta la F)
            System.out.print("Ingrese dato: ");
            instruccion.dato = scan.nextLine();
            
            this.listaInstrucciones.add(instruccion);
            System.out.print("Desea ingresar otra instruccion?: ");
            op = scan.nextInt();
        }
    }

    public void InstruccionesRandom() {
        
        String randomCops;
        String randomDatos = new String();
        memoriap.carga();
        for (int i = 0; i < 5; i++) {
            randomCops = randomString(CHARSET_01, 1);
            int x = Integer.parseInt(randomCops);
            instruccion.setCop(cops[x]);
            
            String randomDireccion = randomString(CHARSET_09, 1);
            int y = Integer.parseInt(randomDireccion);
            memoria = memoriap.listarecuperada.get(i);
            instruccion.setDireccion(memoria.direccion.toUpperCase());

            randomDatos = randomString(CHARSET_AF_09, 4);
            instruccion.setDato(randomDatos);
            //Partes[i][j] = randomDireccion;
            //j++;
            //Partes[i][j] = randomDatos;
            int decimal = Integer.parseInt(randomDireccion, 16);
            decimal++;
            randomDireccion = Integer.toHexString(decimal);
            listaInstrucciones.add(instruccion);
            instruccion = new Instruccion();
        }

    }

    public static String randomString(char[] characterSet, int length) {
        Random random = new SecureRandom();
        char[] result = new char[length];
        for (int i = 0; i < result.length; i++) {
            // picks a random index out of character set > random character
            int randomCharIndex = random.nextInt(characterSet.length);
            result[i] = characterSet[randomCharIndex];
        }
        return new String(result);
    }

    public void mostrar() {
        for (int i = 0; i < listaInstrucciones.size(); i++) {
            System.out.println(listaInstrucciones.get(i));
        }
    }

    public void obtener() throws OptionalDataException {
        int contador = 0;
        try {
            InputStream file = new FileInputStream("Memoria.txt");
            ObjectInput input = new ObjectInputStream(file);

            //deserialize the List
            while (contador != 10) {
                listaMemoria.add((Memoria) input.readObject());
                //Solucion temporal (arreglar asap [si se puede / VAMOS POR EL CAMBIO])
                contador++;
            }
        } catch (OptionalDataException e) {
            if (!e.eof) {
                throw e;
            }
        } catch (ClassNotFoundException e) {
            e.getMessage();
        } catch (IOException e) {
            e.getMessage();
        }
    }

}

