/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package procesador;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author INTEL-COREi7
 */
public class Inicio {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        MemoriaPrincipal memoria = new MemoriaPrincipal();
        memoria.carga();
        memoria.mostrar2();
        
        /*try{
            memoria.mostrar();
        }catch(IOException e){
            e.getMessage();
        }*/
    }
    
}
