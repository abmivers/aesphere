/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package aesphere;

import java.io.FileOutputStream;
import java.io.OutputStream;
import javax.swing.JOptionPane;

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

    public static byte[] unpad (byte [] padArray, int tam) {
        //comprobamos que el array de entrada no sea nulo
        if (padArray == null) return null;
        //almacenamos el byte de relleno
        byte relleno = padArray[padArray.length - 1];
        int rellenoInt = byteToInt(relleno);
        //comprobamos si el relleno tiene un valor correcto
        if ( (rellenoInt <= 0) || (rellenoInt > tam) )
            return null;

        //Primero calculamos la longitud que tendrá el nuevo array
        int size = padArray.length - rellenoInt;

        //comprobamos si el relleno es correcto
        boolean corr = true;
        for (int i = size; (i < padArray.length) && corr; i++) {
            if (padArray[i] != relleno) corr = false;
        }
        if (!corr) 
            return null;

        //declaramos el nuevo array
        byte [] noPad = new byte [size];
        //Copiamos un array en el otro
        for (int i = 0; i < size; i++)
                noPad[i] = padArray[i];

        return noPad;
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
        String texto = "";

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
        String texto = "";

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
    
    public static String byteToHexShortString (byte [] in) {
        String texto = "";
        int len = in.length;
        
        for (int i = 0; i < len;i++) {
            if (len > 112) {
                if (i < 16) {                        
                    texto += byteToHexPair(in[i]);
                    if (i == 15) texto += "... ";
                } else if (i >= (len - 16)) {
                    if (i == (len - 16)) texto += " ...";
                    texto += byteToHexPair(in[i]);                    
                }
            } else
                texto += byteToHexPair(in[i]);
        }

        return texto;
    }

    public static byte [] longToByte (long num) {
        byte [] aux = new byte[Long.SIZE/8];

        for (int i = aux.length - 1; i >= 0; i--) {
            aux[i] = (byte) num;
            if (num != 0) num >>= 8;
        }
        
        return aux;
    }

    public static byte [] intToByte (int num) {
        byte [] aux = new byte[Integer.SIZE/8];

        for (int i = aux.length - 1; i >= 0; i--) {
            aux[i] = (byte) num;
            if (num != 0) num >>= 8;
        }

        return aux;
    }

    public static long byteToLong (byte [] num) {
        long aux = 0;

        int len = num.length;
        for (int i = 0; i < len; i++) {
            aux <<= 8;
            aux += (long) (0x00ff & num[i]);            
        }

        return aux;
    }

    public static int byteToInt (byte [] num) {
        int aux = 0;

        int len = num.length;
        for (int i = 0; i < len; i++) {
            aux <<= 8;
            aux += (int) (0x00ff & num[i]);
        }

        return aux;
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
            }
            
            fichero.write(sinCero);


        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, Entorno.getTrans("gen.fileWriteErr") +
                    ruta, Entorno.getTrans("gen.err"), JOptionPane.ERROR_MESSAGE);

        } finally {
           try {
           // Nuevamente aprovechamos el finally para
           // asegurarnos que se cierra el fichero.
           if (null != fichero)
              fichero.close();
           } catch (Exception e2) {
              JOptionPane.showMessageDialog(null, Entorno.getTrans("gen.fileCloseErr") +
                    ruta, Entorno.getTrans("gen.err"), JOptionPane.ERROR_MESSAGE);

           }
        }
    }

}
