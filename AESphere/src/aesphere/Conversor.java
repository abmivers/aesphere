/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package aesphere;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 *
 * @author admin
 */
public class Conversor {

    public static byte[] stringToASCII (String texto, int tamano) {
        byte[] ascii = null;
        int slength = texto.length();

        if (slength <= tamano){
            ascii = new byte[tamano];

            for (int i = 0; i < slength; i++) {
                ascii[tamano - slength + i] = (byte) texto.charAt(i);
            }
        } else {
            ascii = new byte[slength];

            for (int i = 0; i < slength; i++) {
                ascii[i] = (byte) texto.charAt(i);
            }
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
            texto = texto + String.format("%02x",byteToInt(letra));
        }
        return texto;
    }

    public static byte hexPairToByte (String par, int offset){
        return (byte) ( (Character.digit(par.charAt(offset), 16) << 4)
                + (Character.digit(par.charAt(offset + 1), 16)) );
    }

    /**
     * Devuelve el array de bytes correspondiente al String con dígitos
     * hexadecimales sin espacios que se le pasa, rellenándolo con 0 a la
     * izquierda hasta el tamaño indicado en tamano.
     * @param texto El String con los dígitos hexadecimales sin espacios
     * @param tamano El tamaño mínimo del array resultante
     * @return Un array de bytes con la representación byte a byte de los
     * dígitos hexadecimales de la entrada
     */
    public static byte[] hexStringToByte (String texto, int tamano) {
        byte[] ascii = null;

        /* si hay un número impar de dígitos hexadecimales, rellenamos el String
         * con un 0 a la izquierda
         */
        if ( (texto.length() % 2) == 1 ) texto = "0" + texto;
        int slength = texto.length();

        if ((slength/2) <= tamano) {
            /* por diseño de la aplicación, cuando se trate la clave nunca
             * se le pasará un String que contenga más bytes de los que indica
             * tamano
             */
            ascii = new byte [tamano];

            for (int i = 0; i < slength; i += 2) 
                ascii[tamano + (i - slength)/2] = hexPairToByte(texto,i);

        } else {
            /* por diseño de la aplicación, si el String que se le pasa tiene
             * más bytes que los indicados en tamano, sabemos que estamos
             * tratando la cadena de entrada
             */
            ascii = new byte[slength/2];
            
            for (int i = 0; i < slength; i += 2) {
                ascii[i/2] = (byte)
                    ( (Character.digit(texto.charAt(i), 16) << 4)
                    + (Character.digit(texto.charAt(i+1), 16)) );
            }
        }
        return ascii;
    }

    public static void byteToFile (byte [] texto, String ruta){
        OutputStream fichero = null;
        byte [] sinCero;

        try
        {
            fichero = new FileOutputStream(ruta);

            int  i = 0;
            while(texto[i] == 0) i++;
            sinCero = new byte [texto.length - i];
            for (int j = 0; i < texto.length; j++, i++){
                if (j < sinCero.length) sinCero[j] = texto[i];
                else System.out.println("WARNING: Puede que el archivo no se" +
                        "haya escrito bien");
            }
            
            fichero.write(sinCero);


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
