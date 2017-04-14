/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package procesador;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import static procesador.MemoriaPrincipal.randomString;

/**
 *
 * @author INTEL-COREi7
 */
public class MemoriaPrincipalTest {
    
    static Scanner scan = new Scanner(System.in);

    ArrayList<MemoriaTest> listaMemoria = new ArrayList<>();
    
    MemoriaTest memoria = new MemoriaTest();

    private static final char[] CHARSET_AF_09 = "ABCDEF0123456789".toCharArray();

    public void generar() {
        int i = 0;
        int op = 0;
        
        String randomDireccion = randomString(CHARSET_AF_09, 4);

        while (op != -1) {
            
            memoria.direccion = randomDireccion;

            int decimal = Integer.parseInt(randomDireccion, 16);
            decimal++;
            randomDireccion = Integer.toHexString(decimal);
            memoria.instruccion.instruccionUsuario();
            
            this.listaMemoria.add(memoria);

            i++;

            System.out.print("Desea ingresar otra palabra?: ");
            op = scan.nextInt();
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
    
    public void mostrar(){
        for (int i = 0; i < listaMemoria.size(); i++) {
            System.out.println(listaMemoria.get(i).toString());
        }
    }
}
