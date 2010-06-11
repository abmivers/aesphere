/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package aesphere;

/**
 *
 * @author admin
 */
public class BlockManager {
    
    private byte [] key;
    private int keySize;
    private int blockSize;
    
    public BlockManager (byte [] clave, int claveTam, int bloqueTam) {
        key = clave;
        keySize = claveTam;
        blockSize = bloqueTam;
    }

    public byte [] ECB (byte [] in, String mode)
            throws IllegalArgumentException {
        byte [] outBlock = new byte [blockSize];

        int numBlocks = in.length / blockSize;
        if ( (in.length % blockSize) != 0) numBlocks++;

        byte [] out = new byte [numBlocks * blockSize];

        for (int i = 0; i <= numBlocks; i++) {
            byte [] inBlock = getBlock (in, i);

            if (mode.equals("cipher")) {

                AESencrypt cifrador = new AESencrypt(key, keySize);
                cifrador.Cipher(inBlock, outBlock);

            } else if (mode.equals("decipher")) {

                AESdecrypt descifrador = new AESdecrypt(key,keySize);
                descifrador.InvCipher(inBlock, outBlock);

            } else
                throw new IllegalArgumentException("Incorrect 'mode' argument");

            //TODO out = addBlock (out, outBlock, i);
        }
        return out;
    }

    private byte [] getBlock (byte [] arr, int numBlock) {
        byte [] aux = new byte [blockSize];

        //for ()

        return aux;
    }

}
