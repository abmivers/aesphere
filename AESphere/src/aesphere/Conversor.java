/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package aesphere;

import java.io.FileOutputStream;
import java.io.OutputStream;

/**
 *
 * @author admin
 */
public class Conversor {

    public static byte[] pad (byte [] noPad, int tam) {
        //Primero calculamos la longitud que tendrá el nuevo array
        int finalSize = ( (noPad.length / tam) * tam ) + tam;
        byte [] padArray = new byte [finalSize];

        //Calculamos el valor con el que vamos a rellenar
        int relleno = finalSize - noPad.length;

        /*Rellenamos el array con el byte de relleno y copiamos el origen en el
         * destino
         */
        for (int i = 0; i < finalSize; i++) {
            if (i < noPad.length) padArray[i] = noPad[i];
            else padArray[i] = (byte) relleno;
        }

        return padArray;
    }

    public static byte[] stringToASCII (String texto) {
        int slength = texto.length();
        byte[] ascii = new byte [slength];

        for (int i = 0; i < slength; i++) {
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
            texto = texto + byteToHexPair(letra);
        }

        return texto;
    }

    public static byte hexPairToByte (String par, int offset){
        return (byte) ( (Character.digit(par.charAt(offset), 16) << 4)
                + (Character.digit(par.charAt(offset + 1), 16)) );
    }

    public static String byteToHexPair (byte hexNum) {
        return String.format("%02x",byteToInt(hexNum));
    }

    /**
     * Devuelve el array de bytes correspondiente al String con dígitos
     * hexadecimales sin espacios que se le pasa, rellenándolo con un 0 a la
     * izquierda si el número de dígitos es impar.
     * @param texto El String con los dígitos hexadecimales sin espacios
     * @return Un array de bytes con la representación byte a byte de los
     * dígitos hexadecimales de la entrada
     */
    public static byte[] hexStringToByte (String texto) {
        /* si hay un número impar de dígitos hexadecimales, rellenamos el String
         * con un 0 a la izquierda
         */
        if ( (texto.length() % 2) == 1 ) texto = "0" + texto;
        int slength = texto.length();

        byte [] ascii = new byte[slength/2];
            
        for (int i = 0; i < slength; i += 2) {
            ascii[i/2] = (byte)
                ( (Character.digit(texto.charAt(i), 16) << 4)
                + (Character.digit(texto.charAt(i+1), 16)) );
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
