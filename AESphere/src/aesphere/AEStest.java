/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package aesphere;

/**
 *
 * @author antonio
 */

// AEStest: test AES encryption
public class AEStest {

   public static void main(String[] args) {
      // for 128-bit key, use 16, 16, and 4 below
      // for 192-bit key, use 16, 24 and 6 below
      // for 256-bit key, use 16, 32 and 8 below
      GetBytes getInput = new GetBytes("/Users/antonio/Downloads/plaintext.txt", 16);
      byte[] in = getInput.getBytes();
      GetBytes getKey = new GetBytes("/Users/antonio/Downloads/key.txt", 32);
      byte[] key = getKey.getBytes();
      AESencrypt aes = new AESencrypt(key, 8);
      Print.printArray("Plaintext:     ", in);
      Print.printArray("Key:           ", key);
      byte[] out = new byte[16];
      aes.Cipher(in, out);
      Print.printArray("Ciphertext:    ", out);
   }
}
