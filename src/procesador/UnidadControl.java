/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package procesador;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author INTEL-COREi7
 */
public class UnidadControl {

    String PC;
    String IR; //Deberia ser de tipo de Instruccion

    ArrayList<MemoriaTest> StackPointer;

    Reloj reloj = new Reloj();

    MemoriaTest memoria;

    public UnidadControl() {
        StackPointer = new ArrayList<>();
        this.PC = " ";
        this.IR = " ";
        this.reloj = new Reloj();
    }

    /*public void llenar(){
        for (int i = 0; i < StackPointer.length; i++) {
             String randomDireccion = randomString(CHARSET_AF_09, 4);
            BufferRegistros[i] = randomDireccion;     
        }
    }*/
    public void leer() {
        try {

            BufferedReader in = new BufferedReader(new FileReader("MemoriasAleatorias.txt"));

            String inputLine;

            while ((inputLine = in.readLine()) != null) {

                if (inputLine.isEmpty()) {
                    continue;
                }

                InputStream file = new FileInputStream("Memoria.txt");
                ObjectInput input = new ObjectInputStream(file);

                memoria = new MemoriaTest();

                String[] contactVars = inputLine.split(":");
                memoria.setDireccion(contactVars[0]);
                memoria.instruccion.setCop(contactVars[1]);
                memoria.instruccion.setDato(contactVars[2]);

                StackPointer.add(memoria);
            }
        } catch (IOException e) {
            e.getMessage();

        }
        Collections.reverse(StackPointer);
    }
    
    public void mostrar(){
        for (int i = 0; i < StackPointer.size(); i++) {
            System.out.println(StackPointer.get(i).toString());
        }
    }

}
