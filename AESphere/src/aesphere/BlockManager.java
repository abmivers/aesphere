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
    private String resultado;
    
    public BlockManager (byte [] clave, int claveTam, int bloqueTam) {
        key = clave;
        keySize = claveTam;
        blockSize = bloqueTam;
    }

    public String getResultado () {
        return resultado;
    }

    /**
     * Function to encyrpt a byte array using the ECB method to manage the block
     * creation.
     * @param in The byte array to be encrypted/decrypted
     * @param cifrando A boolean that indicates if we are encrypting (true) or
     * decrypting (false)
     * @return The encrypted/decrypted array of bytes
     * @throws IllegalArgumentException To control the mode parameter
     */
    public byte [] ECB (byte [] in, Boolean cifrando) {
        byte [] outBlock = new byte [blockSize];

        int numBlocks = in.length / blockSize;
        if ( (in.length % blockSize) != 0) numBlocks++;

        byte [] out = new byte [numBlocks * blockSize];

        if (cifrando) {
            AESencrypt cifrador = new AESencrypt(key, keySize);
            
            for (int i = 0; i < numBlocks; i++) {
                byte [] inBlock = getBlock (in, i);
                cifrador.Cipher(inBlock, outBlock);
                out = addBlock (out, outBlock, i);
            }
            
            resultado = cifrador.getCadena();
        } else {
            AESdecrypt descifrador = new AESdecrypt(key,keySize);

            for (int i = 0; i < numBlocks; i++) {
                byte [] inBlock = getBlock (in, i);
                descifrador.InvCipher(inBlock, outBlock);
                out = addBlock (out, outBlock, i);
            }
        }

        return out;
    }

    private byte [] getBlock (byte [] arr, int numBlock) {
        int offset = numBlock * blockSize;
        byte [] aux = new byte [blockSize];

        for (int i = 0; i < blockSize; i++)
           aux[i] = arr[offset + i];

        return aux;
    }

    private byte [] addBlock (byte [] out, byte [] arr, int numBlock) {
        int offset = numBlock * blockSize;

        for (int i = 0; i < blockSize; i++)
            out[offset + i] = arr[i];

        return out;
    }

    /*public byte [] CBC (byte [] in, String mode)
            throws IllegalArgumentException {
        byte [] outBlock = new byte [blockSize];
    }*/
}
