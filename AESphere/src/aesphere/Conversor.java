/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package aesphere;

import java.io.FileWriter;
import java.io.PrintWriter;

/**
 *
 * @author admin
 */
public class Conversor {

    public static byte[] stringToASCII (String texto, int tamano) {
        byte[] ascii = new byte[tamano];

        for (int i = 0; i < texto.length(); i++) {
            ascii[i] = (byte) texto.charAt(i);
        }

        return ascii;
    }

    public static String byteToTextString (byte [] ascii) {
        String texto = new String();

        for (byte letra: ascii) {
            texto = texto + Character.toString(byteToChar(letra));
        }

        return texto;
    }

    public static char byteToChar (byte b) {
        return (char) (b & 0x00ff);
    }
    
    public static int byteToInt (byte b) {
        return (int) (b & 0x000000ff);
    }

    public static String byteToHexString (byte[] ascii) {
        String texto = new String();

        for (byte letra: ascii) {
            texto = texto + Integer.toHexString(byteToInt(letra)) + " ";
        }
        
        return texto;
    }

    //falla para impares. Accede al ultimo caracter q esta fuera del string
    public static byte[] hexStringToByte (String texto, int tamano) {
        //byte[] ascii = new byte [texto.length() / 2];
        byte[] ascii = new byte [tamano];

        for (int i = 0; i < texto.length(); i += 2) {
            
            //solucion anzo. Mirar si es correcta
            if ((i==texto.length()-1) & (texto.length()%2==1) ) {
                ascii[i / 2] = (byte)
                    ( (Character.digit(texto.charAt(i), 16) << 4));
            } else {

            ascii[i / 2] = (byte)
                    ( (Character.digit(texto.charAt(i), 16) << 4)
                    + (Character.digit(texto.charAt(i+1), 16)) );
            }
        }

        return ascii;
    }

    public static void byteToFile (String texto){

        FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {
            fichero = new FileWriter("/Users/antonio/Downloads/output.txt");
            pw = new PrintWriter(fichero);

            pw.print(texto);
           

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           try {
           // Nuevamente aprovechamos el finally para
           // asegurarnos que se cierra el fichero.
           if (null != fichero)
              fichero.close();
           } catch (Exception e2) {
              e2.printStackTrace();
           }
        }
    }

}
