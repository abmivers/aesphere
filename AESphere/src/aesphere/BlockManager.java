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
    private String resultado = "";
    private byte [] IV;
    private boolean paso;
    
    public BlockManager (byte [] clave, int claveTam, int bloqueTam, 
            boolean step) {
        this.paso = step;
        key = clave;
        keySize = claveTam;
        blockSize = bloqueTam;
        IV = new byte[blockSize];
        for (int i =0; i < blockSize; i++)
            IV[i] = Conversor.hexPairToByte("ff", 0);
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
    public byte [] ECB (byte [] in, boolean cifrando) {
        byte [] outBlock = new byte [blockSize];

        int numBlocks = in.length / blockSize;
        if ( (in.length % blockSize) != 0) numBlocks++;

        byte [] out = new byte [numBlocks * blockSize];
        byte [] inBlock = null;

        if (cifrando) {
            System.out.println("[" + java.util.Calendar.getInstance().getTime() + "]");
            System.out.println("Cifrando");
            AESencrypt cifrador = new AESencrypt(key, keySize, paso);
            
            for (int i = 0; i < numBlocks; i++) {
                inBlock = getBlock (in, i);
                cifrador.Cipher(inBlock, outBlock);
                out = addBlock (out, outBlock, i);
            }

            System.out.println("[" + java.util.Calendar.getInstance().getTime() + "]");
            System.out.println("Cifrado\n");
            resultado = cifrador.getCadena();
            if (!resultado.equals("")) System.out.println("Paso a paso:\n" +
                    resultado + "\n");
        } else {
            System.out.println("[" + java.util.Calendar.getInstance().getTime() + "]");
            System.out.println("Descifrando");
            AESdecrypt descifrador = new AESdecrypt(key,keySize, paso);

            for (int i = 0; i < numBlocks; i++) {
                inBlock = getBlock (in, i);
                descifrador.InvCipher(inBlock, outBlock);
                out = addBlock (out, outBlock, i);
            }

            System.out.println("[" + java.util.Calendar.getInstance().getTime() + "]");
            System.out.println("Descifrado\n");
            resultado = descifrador.getCadena();
            if (!resultado.equals("")) System.out.println("Paso a paso:\n" +
                    resultado + "\n");
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

    public byte [] CBC (byte [] in, boolean cifrando) {
        byte [] outBlock = new byte [blockSize];

        int numBlocks = in.length / blockSize;
        if ( (in.length % blockSize) != 0) numBlocks++;

        byte [] out = new byte [numBlocks * blockSize];
        byte [] inBlock = null;

        if (cifrando) {
            AESencrypt cifrador = new AESencrypt(key, keySize,paso);

            for (int i = 0; i < numBlocks; i++) {
                inBlock = getBlock (in, i);

                if (i==0) inBlock = XOR(IV, inBlock);
                else inBlock = XOR(outBlock, inBlock);

                cifrador.Cipher(inBlock, outBlock);
                out = addBlock (out, outBlock, i);
            }

            resultado = cifrador.getCadena();
        } else {
            AESdecrypt descifrador = new AESdecrypt(key,keySize,paso);
            byte [] preBlock = null;

            for (int i = 0; i < numBlocks; i++) {
                inBlock = getBlock (in, i);
                descifrador.InvCipher(inBlock, outBlock);

                if (i == 0) outBlock = XOR(IV, outBlock);
                else outBlock = XOR(preBlock,outBlock);

                preBlock = inBlock;
                out = addBlock (out, outBlock, i);
            }

            resultado = descifrador.getCadena();
        }

        return out;
    }

    private byte [] XOR (byte [] a, byte [] b) {
        byte [] aux = new byte[a.length];

        for (int i=0; i < a.length; i++)
            aux[i] = (byte) (a[i] ^ b[i]);

        return aux;
    }
}
