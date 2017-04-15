/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package procesador;

import java.security.SecureRandom;
import java.util.Random;

/**
 *
 * @author INTEL-COREi7
 */
public class UnidadTratamiento {

    String BufferRegistros[] = new String[15];
    String Banderas[] = new String[4];
    String ALU;
    
    String AR;
    
    String DR;
    String RT;
    
     private static final char[] CHARSET_AF_09 = "ABCDEF0123456789".toCharArray();

    public UnidadTratamiento() {
        this.ALU = " ";
        this.AR = " ";
        this.DR = " ";
        this.RT = " ";
    }

    public UnidadTratamiento(String ALU, String AR, String DR, String RT) {
        this.ALU = ALU;
        this.AR = AR;
        this.DR = DR;
        this.RT = RT;
    }
    
    public void llenar(){
        
       
        
        for (int i = 0; i < BufferRegistros.length; i++) {
             String randomDireccion = randomString(CHARSET_AF_09, 4);
            BufferRegistros[i] = randomDireccion;     
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

}
