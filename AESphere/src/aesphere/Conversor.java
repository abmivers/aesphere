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
        byte[] salida = new byte[texto.length()];

        for (int i = 0; i < texto.length(); i++) {
            salida[i] = (byte) texto.charAt(i);
        }

        return salida;
    }

}
