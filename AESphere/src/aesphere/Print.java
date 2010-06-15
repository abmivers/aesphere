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
   private static String[] dig = {"0","1","2","3","4","5","6","7",
                           "8","9","a","b","c","d","e","f"};

   public Print(){

   }

   // hex: print a byte as two hex digits
   public static String hex(byte a) {
      return dig[(a & 0xff) >> 4] + dig[a & 0x0f];
   }

   public String printArray(String name, byte[] a) {
      String cadena=new String();
      cadena= (name + " ");
      for (int i = 0; i < a.length; i++)
         cadena= cadena + hex(a[i]) + " //n";

      return cadena;
   
   }

   public String printArray(String name, byte[][] s) {
      String cadena2 = new String();
      cadena2 = (name + " ");
      for (int c = 0; c < Nb; c++)
         for (int r = 0; r < 4; r++)
            cadena2 = cadena2 + hex(s[r][c]) + " //n";
            
      return cadena2;
   }
}
