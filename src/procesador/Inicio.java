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
        import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 *
 * @author INTEL-COREi7
 */
public class Inicio {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //MemoriaPrincipal memoria = new MemoriaPrincipal();
        //memoria.carga();
        //memoria.mostrar2();
        //Procesador procesador = new Procesador();
        //procesador.gestion();
        /*try{
            memoria.mostrar();
        }catch(IOException e){
            e.getMessage();
        }*/
        MemoriaPrincipalTest gestion = new MemoriaPrincipalTest();
        gestion.generar();
        gestion.mostrar();
        Interfaz interfaz = new Interfaz();
        //printUsage();
        
    }

public static void printUsage() {
  OperatingSystemMXBean operatingSystemMXBean = ManagementFactory.getOperatingSystemMXBean();
  for (Method method : operatingSystemMXBean.getClass().getDeclaredMethods()) {
    method.setAccessible(true);
    if (method.getName().startsWith("get") 
        && Modifier.isPublic(method.getModifiers())) {
            Object value;
        try {
            value = method.invoke(operatingSystemMXBean);
        } catch (Exception e) {
            value = e;
        } // try
        System.out.println(method.getName() + " = " + value);
    } // if
  } // for
}
    }
    

