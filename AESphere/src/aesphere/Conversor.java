/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package aesphere;

/**
 *
 * @author admin
 */
public class Conversor {

    public static byte[] stringToASCII (String texto) {
        byte[] ascii = new byte[texto.length()];

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

    public static byte[] hexStringToByte (String texto, int tamano) {
        //byte[] ascii = new byte [texto.length() / 2];
        byte[] ascii = new byte [tamano];

        for (int i = 0; i < texto.length(); i += 2) {
            ascii[i / 2] = (byte)
                    ( (Character.digit(texto.charAt(i), 16) << 4)
                    + (Character.digit(texto.charAt(i+1), 16)) );
        }

        return ascii;
    }

}
