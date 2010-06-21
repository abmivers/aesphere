/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package aesphere;

/**
 *
 * @author antonio
 */

// Print: print arrays of bytes
public class Print {
   private static final int Nb = 4;

   public static String printArray(String name, byte[] a) {
      String cadena=new String();
      cadena= (name + " ");
      for (int i = 0; i < a.length; i++)
         cadena = cadena + Conversor.byteToHexPair(a[i]) ;
      cadena = cadena + "\n";

      return cadena;   
   }

   public static String printArray(String name, byte[][] s) {
      String cadena2 = new String();
      cadena2 = (name + " ");
      for (int c = 0; c < Nb; c++)
         for (int r = 0; r < 4; r++)
            cadena2 = cadena2 + Conversor.byteToHexPair(s[r][c]);
      cadena2 = cadena2 + "\n";
            
      return cadena2;
   }
}
