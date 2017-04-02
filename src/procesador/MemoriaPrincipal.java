/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package procesador;

import java.util.ArrayList;
import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.SecureRandom;
import java.util.Random;

/**
 *
 * @author INTEL-COREi7
 */
public class MemoriaPrincipal {

    //protected ArrayList listaDirecciones = new ArrayList();
    //protected ArrayList listaDatos = new ArrayList();
    //protected ArrayList listaMemoria = new ArrayList();
    protected char Random[] = new char[4];
    private static final char[] CHARSET_AF_09 = "ABCDEF0123456789".toCharArray();
    private static final char[] CHARSET_01 = "01".toCharArray();
    
    private String[] cops = {"SU","RE"};

    Memoria memoria = new Memoria();
    protected ArrayList<Memoria> lista = new ArrayList<>();

    //protected String[][] Partes = new String[10][10];
    
    ArrayList<Memoria> listarecuperada = new ArrayList<>();
    
    int contador = 0; 

    public void carga() {

        try {

            BufferedReader in = new BufferedReader(new FileReader("Memoria.txt"));
            //BufferedWriter bw = new BufferedWriter(new FileWriter("Memoria.txt"));

            String inputLine;

            //Mientras haya más contactos
            //Leer los valores del siguiente contacto
            //Construir un objeto contacto
            //Añadirlo a la lista de contactos
            while ((inputLine = in.readLine()) != null) {

                if (inputLine.isEmpty()) {
                    continue;
                }

                try {
                    InputStream file = new FileInputStream("Memoria.txt");
                    ObjectInput input = new ObjectInputStream(file);
                        
                    //deserialize the List
                    
                     while (contador != 10) {
                          listarecuperada.add((Memoria) input.readObject());
                        //Solucion temporal (arreglar asap [si se puede / VAMOS POR EL CAMBIO])
                        contador++;
                     }
                }catch(OptionalDataException e){
                    if (!e.eof) throw e;
                } catch (ClassNotFoundException e){
                    e.getMessage();
                }catch(IOException e){
                    e.getMessage();
                }
            }
                    //display its data

            

                //String[] contactVars = inputLine.split(":");
                //instruccion.setDireccion(contactVars[0]);
                //instruccion.setDato(contactVars[1]);
                //lista.add(instruccion);
            
            if (in.readLine() == null) {
                String randomDireccion = randomString(CHARSET_AF_09, 4);
                String randomCops;
                String randomDatos = new String();

                for (int i = 0; i < 10; i++) {
                    //randomCops = randomString(CHARSET_01, 1);
                    //int x = Integer.parseInt(randomCops);
                    //instruccion.setCop(cops[x]);
                    memoria.setDireccion(randomDireccion.toUpperCase());
                    randomDatos = randomString(CHARSET_AF_09, 4);
                    memoria.setDato(randomDatos);
                    //Partes[i][j] = randomDireccion;
                    //j++;
                    //Partes[i][j] = randomDatos;
                    int decimal = Integer.parseInt(randomDireccion, 16);
                    decimal++;
                    randomDireccion = Integer.toHexString(decimal);
                    lista.add(memoria);
                    memoria = new Memoria();
                }

            }
            
            //Mete la lista al file (write)
            FileOutputStream out = new FileOutputStream("Memoria.txt");
            ObjectOutputStream oos = new ObjectOutputStream(out);

            for (int i = 0; i < lista.size(); i++) {
                oos.writeObject(lista.get(i));
            }

            // outStream.close();
            //System.out.println("Data saved.");
        } catch (FileNotFoundException e) {
            System.out.println("Fichero no encontrado");
        } catch (IOException e) {
            System.out.println("Error de E/S");
        }

    }

    public void mostrar() throws IOException {

        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("Memoria.txt"));
            System.out.println(in.readObject());

            Object o;

            while ((o = in.readObject()) != null) {
                System.out.println(o);
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
    
    public void mostrar2(){
        for (int i = 0; i < listarecuperada.size(); i++) {
            System.out.println(listarecuperada.get(i));
        }
    }
}
