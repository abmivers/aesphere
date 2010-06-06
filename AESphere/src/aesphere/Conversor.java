/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package aesphere;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
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
            texto = texto + String.format("%02x ",byteToInt(letra));
        }
        
        return texto;
    }

    public static byte[] hexStringToByte (String texto, int tamano) {
        //byte[] ascii = new byte [texto.length() / 2];
        byte[] ascii = new byte [tamano];

        for (int i = 0; i < texto.length(); i += 2) {
            
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

    public static void byteToFile (String texto, String ruta){

        FileWriter fichero = null;
        PrintWriter pw = null;

        try
        {
            fichero = new FileWriter(ruta);
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

 public static byte[] getBytesFromFile(File file) throws Exception {
        InputStream is = new FileInputStream(file);

        // Get the size of the file
        long length = file.length();

        if (length > Integer.MAX_VALUE) {
            // File is too large
        }

        // Create the byte array to hold the data
        byte[] bytes = new byte[(int)length];

        // Read in the bytes
        int offset = 0;
        int numRead = 0;
        while (offset < bytes.length
               && (numRead=is.read(bytes, offset, bytes.length-offset)) >= 0) {
            offset += numRead;
        }

        // Ensure all the bytes have been read in
        if (offset < bytes.length) {
            throw new IOException("Could not completely read file "+file.getName());
        }

        // Close the input stream and return bytes
        is.close();
        return bytes;
    }

}
