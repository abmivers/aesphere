/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package aesphere;

/**
 *
 * @author antonio
 */
// AESdecrypt: AES decryption
public class AESdecrypt {
   public final int Nb = 4; // words in a block, always 4 for now
   public int Nk; // key length in words
   public int Nr; // number of rounds, = Nk + 6
   private int wCount; // position in w (= 4*Nb*(Nr+1) each encrypt)
   AEStables tab; // all the tables needed for AES
   byte[] w; // the expanded key
   private String cadena = "";
   private boolean paso;

   // AESdecrypt: constructor for class.  Mainly expands key
   public AESdecrypt(byte[] key, int NkIn, boolean paso) {
       this.paso=paso;
      Nk = NkIn; // words in a key, = 4, or 6, or 8
      Nr = Nk + 6; // corresponding number of rounds
      tab = new AEStables(); // class to give values of various functions
      w = new byte[4*Nb*(Nr+1)]; // room for expanded key
      KeyExpansion(key, w); // length of w depends on Nr
   }

   // InvCipher: actual AES decryption
   public void InvCipher(byte[] in, byte[] out) {
      wCount = 4*Nb*(Nr+1); // count bytes during decryption
      byte[][] state = new byte[4][Nb]; // the state array
      Copy.copy(state, in); // actual component-wise copy
      InvAddRoundKey(state); // xor with expanded key
      for (int round = Nr-1; round >= 1; round--) {
         if (paso) cadena = cadena + Entorno.getTrans("Proc.round") + " " + (Nr - round) + "\n";
         if (paso) cadena = cadena + Entorno.getTrans("Proc.roundUnder") + "\n";
         if (paso) cadena = cadena + Print.printArray(Entorno.getTrans("Proc.startRound"), state);
         InvShiftRows(state); // mix up rows
         if (paso) cadena = cadena + Print.printArray(Entorno.getTrans("Proc.afterISR"), state);
         InvSubBytes(state); // inverse S-box substitution
         if (paso) cadena = cadena + Print.printArray(Entorno.getTrans("Proc.afterISB"), state);
         InvAddRoundKey(state); // xor with expanded key
         if (paso) cadena = cadena + Print.printArray(Entorno.getTrans("Proc.afterIARK"), state);
         InvMixColumns(state); // complicated mix of columns
         if (paso) cadena = cadena + Print.printArray(Entorno.getTrans("Proc.afterIMC"), state);
         if (paso) cadena = cadena + "\n";
      }
      if (paso) cadena = cadena + Entorno.getTrans("Proc.round") + " " + Nr + "\n";
      if (paso) cadena = cadena + Entorno.getTrans("Proc.roundUnder") + "\n";
      if (paso) cadena = cadena + Print.printArray(Entorno.getTrans("Proc.startRound"), state);
      InvShiftRows(state); // mix up rows
      if (paso) cadena = cadena + Print.printArray(Entorno.getTrans("Proc.afterISR"), state);
      InvSubBytes(state); // inverse S-box substitution
      if (paso) cadena = cadena + Print.printArray(Entorno.getTrans("Proc.afterISB"), state);
      InvAddRoundKey(state); // xor with expanded key
      if (paso) cadena = cadena + Print.printArray(Entorno.getTrans("Proc.afterIARK"), state);
      if (paso) cadena = cadena + "\n";
      Copy.copy(out, state);
   }

   // KeyExpansion: expand key, byte-oriented code, but tracks words
   //  (the same as for encryption)
   private void KeyExpansion(byte[] key, byte[] w) {
      byte[] temp = new byte[4];
      // first just copy key to w
      int j = 0;
      while (j < 4*Nk) {
         w[j] = key[j++];
      }
      // here j == 4*Nk;
      int i;
      while(j < 4*Nb*(Nr+1)) {
         i = j/4; // j is always multiple of 4 here
         // handle everything word-at-a time, 4 bytes at a time
         for (int iTemp = 0; iTemp < 4; iTemp++)
            temp[iTemp] = w[j-4+iTemp];
         if (i % Nk == 0) {
            byte ttemp, tRcon;
            byte oldtemp0 = temp[0];
            for (int iTemp = 0; iTemp < 4; iTemp++) {
               if (iTemp == 3) ttemp = oldtemp0;
               else ttemp = temp[iTemp+1];
               if (iTemp == 0) tRcon = tab.Rcon(i/Nk);
               else tRcon = 0;
               temp[iTemp] = (byte)(tab.SBox(ttemp) ^ tRcon);
            }
         }
         else if (Nk > 6 && (i%Nk) == 4) {
            for (int iTemp = 0; iTemp < 4; iTemp++)
               temp[iTemp] = tab.SBox(temp[iTemp]);
         }
         for (int iTemp = 0; iTemp < 4; iTemp++)
            w[j+iTemp] = (byte)(w[j - 4*Nk + iTemp] ^ temp[iTemp]);
         j = j + 4;
      }
   }

   // InvSubBytes: apply inverse Sbox substitution to each byte of state
   private void InvSubBytes(byte[][] state) {
      for (int row = 0; row < 4; row++)
         for (int col = 0; col < Nb; col++)
            state[row][col] = tab.invSBox(state[row][col]);
   }

   // InvShiftRows: right circular shift of rows 1, 2, 3 by 1, 2, 3
   private void InvShiftRows(byte[][] state) {
      byte[] t = new byte[4];
      for (int r = 1; r < 4; r++) {
         for (int c = 0; c < Nb; c++)
            t[(c + r)%Nb] = state[r][c];
         for (int c = 0; c < Nb; c++)
            state[r][c] = t[c];
      }
   }

   // InvMixColumns: complex and sophisticated mixing of columns
   private void InvMixColumns(byte[][] s) {
      int[] sp = new int[4];
      byte b0b = (byte)0x0b; byte b0d = (byte)0x0d;
      byte b09 = (byte)0x09; byte b0e = (byte)0x0e;
      for (int c = 0; c < 4; c++) {
         sp[0] = tab.FFMul(b0e, s[0][c]) ^ tab.FFMul(b0b, s[1][c]) ^
                 tab.FFMul(b0d, s[2][c]) ^ tab.FFMul(b09, s[3][c]);
         sp[1] = tab.FFMul(b09, s[0][c]) ^ tab.FFMul(b0e, s[1][c]) ^
                 tab.FFMul(b0b, s[2][c]) ^ tab.FFMul(b0d, s[3][c]);
         sp[2] = tab.FFMul(b0d, s[0][c]) ^ tab.FFMul(b09, s[1][c]) ^
                 tab.FFMul(b0e, s[2][c]) ^ tab.FFMul(b0b, s[3][c]);
         sp[3] = tab.FFMul(b0b, s[0][c]) ^ tab.FFMul(b0d, s[1][c]) ^
                 tab.FFMul(b09, s[2][c]) ^ tab.FFMul(b0e, s[3][c]);
         for (int i = 0; i < 4; i++) s[i][c] = (byte)(sp[i]);
      }
   }

   // InvAddRoundKey: same as AddRoundKey, but backwards
   private void InvAddRoundKey(byte[][] state) {
   for (int c = Nb - 1; c >= 0; c--)
      for (int r = 3; r >= 0 ; r--)
         state[r][c] = (byte)(state[r][c] ^ w[--wCount]);
   }

   public String getCadena (){
       return cadena;
   }
   
   public void setPaso(boolean nuevoPaso) {
       paso = nuevoPaso;
   }
   
   public void nuevoBloque (int nBlock){       
       if (paso)
           cadena += "\n" + Entorno.getTrans("Proc.block") + " " + nBlock + "\n" +
                   Entorno.getTrans("Proc.blockUnder") + "\n";
   }
}
