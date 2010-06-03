/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package aesphere;

/**
 *
 * @author antonio
 */
// AESinvTest: test AES decryption
public class AESinvTest {

   public static void main(String[] args) {
      // for 128-bit key, use 16, 16, and 4 below
      // for 192-bit key, use 16, 24 and 6 below
      // for 256-bit key, use 16, 32 and 8 below
      GetBytes getInput = new GetBytes("/Users/antonio/Downloads/ciphertext.txt", 16);
      byte[] in = getInput.getBytes();
      GetBytes getKey = new GetBytes("/Users/antonio/Downloads/key.txt", 16);
      byte[] key = getKey.getBytes();
      AESdecrypt aesDec = new AESdecrypt(key, 4);
      Print.printArray("Ciphertext:    ", in);
      Print.printArray("Key:           ", key);
      byte[] out = new byte[16];
      aesDec.InvCipher(in, out);
      Print.printArray("Plaintext:     ", out);
   }
}
