/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package aesphere;

/**
 *
 * @author antonio
 */

public class AESencrypt {
   private final int Nb = 4; // words in a block, always 4 for now
   private int Nk; // key length in words
   private int Nr; // number of rounds, = Nk + 6
   private int wCount; // position in w for RoundKey (= 0 each encrypt)
   private AEStables tab; // all the tables needed for AES
   private byte[] w; // the expanded key
   private String cadena= "";
   private boolean paso;


   public AESencrypt(){

       tab = new AEStables();

   }

   public AESencrypt(byte[] key, int NkIn, int valor) {
      Nk = NkIn; // words in a key, = 4, or 6, or 8
      Nr = Nk + 6; // corresponding number of rounds
      tab = new AEStables(); // class to give values of various functions
      w = new byte[4*Nb*(Nr+1)]; // room for expanded key
      KeyExpansion(key, w); // length of w depends on Nr
      wCount=valor;
   }



   // AESencrypt: constructor for class.  Mainly expands key
   public AESencrypt(byte[] key, int NkIn, boolean paso) {
      this.paso=paso;
      Nk = NkIn; // words in a key, = 4, or 6, or 8
      Nr = Nk + 6; // corresponding number of rounds
      tab = new AEStables(); // class to give values of various functions
      w = new byte[4*Nb*(Nr+1)]; // room for expanded key
      KeyExpansion(key, w); // length of w depends on Nr

   }

   // Cipher: actual AES encrytion
   public void Cipher(byte[] in, byte[] out) {
      wCount = 0; // count bytes in expanded key throughout encryption
      byte[][] state = new byte[4][Nb]; // the state array
      Copy.copy(state, in); // actual component-wise copy
      AddRoundKey(state); // xor with expanded key
      
      for (int round = 1; round < Nr; round++) {
         if (paso){
         cadena = cadena + Entorno.getTrans("Proc.round") + " " + round + "\n";
         cadena = cadena + Entorno.getTrans("Proc.roundUnder") + "\n";
         cadena = cadena + Print.printArray(Entorno.getTrans("Proc.startRound"), state);}
   
         SubBytes(state); // S-box
         if (paso) cadena = cadena + Print.printArray(Entorno.getTrans("Proc.afterSB"), state);
         ShiftRows(state); // mix up rows
         if (paso) cadena = cadena + Print.printArray(Entorno.getTrans("Proc.afterSR"), state);
         MixColumns(state); // complicated mix of columns
         if (paso) cadena = cadena + Print.printArray(Entorno.getTrans("Proc.afterMC"), state);
         AddRoundKey(state); // xor with expanded key
         if (paso) cadena = cadena + Print.printArray(Entorno.getTrans("Proc.afterARK"), state);
         if (paso) cadena = cadena + "\n";

      }
      if (paso) cadena = cadena + Entorno.getTrans("Proc.round") + " " + Nr + "\n";
      if (paso) cadena = cadena + Entorno.getTrans("Proc.roundUnder") + "\n";
      if (paso) cadena = cadena + Print.printArray(Entorno.getTrans("Proc.startRound"), state);
      SubBytes(state); // S-box substitution
      if (paso) cadena = cadena + Print.printArray(Entorno.getTrans("Proc.afterSB"), state);
      ShiftRows(state); // mix up rows
      if (paso) cadena = cadena + Print.printArray(Entorno.getTrans("Proc.afterSR"), state);
      AddRoundKey(state); // xor with expanded key
      if (paso) cadena = cadena + Print.printArray(Entorno.getTrans("Proc.afterARK"), state);
      Copy.copy(out, state);
      if (paso) cadena = cadena + "\n";

   }

   public String getCadena (){
       return cadena;
   }

   // KeyExpansion: expand key, byte-oriented code, but tracks words
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

   // SubBytes: apply Sbox substitution to each byte of state
   public void SubBytes(byte[][] state) {
      for (int row = 0; row < 4; row++)
         for (int col = 0; col < Nb; col++)
            state[row][col] = tab.SBox(state[row][col]);
      
   }

   // ShiftRows: simple circular shift of rows 1, 2, 3 by 1, 2, 3
   public void ShiftRows(byte[][] state) {
      byte[] t = new byte[4];
       for (int r = 1; r < 4; r++) {
         for (int c = 0; c < Nb; c++)
            t[c] = state[r][(c + r)%Nb];
         for (int c = 0; c < Nb; c++)
            state[r][c] = t[c];
      }
   }

   // MixColumns: complex and sophisticated mixing of columns
   public void MixColumns(byte[][] s) {
      int[] sp = new int[4];
      byte b02 = (byte)0x02, b03 = (byte)0x03;
      for (int c = 0; c < 4; c++) {
         sp[0] = tab.FFMul(b02, s[0][c]) ^ tab.FFMul(b03, s[1][c]) ^
                                s[2][c]  ^                s[3][c];
         sp[1] =                s[0][c]  ^ tab.FFMul(b02, s[1][c]) ^
                 tab.FFMul(b03, s[2][c]) ^                s[3][c];
         sp[2] =                s[0][c]  ^                s[1][c]  ^
                 tab.FFMul(b02, s[2][c]) ^ tab.FFMul(b03, s[3][c]);
         sp[3] = tab.FFMul(b03, s[0][c]) ^                s[1][c]  ^
                                s[2][c]  ^ tab.FFMul(b02, s[3][c]);
         for (int i = 0; i < 4; i++) s[i][c] = (byte)(sp[i]);
      }
   }

   // AddRoundKey: xor a portion of expanded key with state
   public void AddRoundKey(byte[][] state) {
      for (int c = 0; c < Nb; c++)
         for (int r = 0; r < 4; r++)
            state[r][c] = (byte)(state[r][c] ^ w[wCount++]);
   }

   public void AddRoundKey(byte[][] state, byte [][] key) {
       for (int i = 0; i < 4; i++)
         for (int j = 0; j < 4; j++)
            state[i][j] = (byte)(state[i][j] ^ key[i][j]);

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
