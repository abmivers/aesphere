/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package aesphere;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 *
 * @author antonio
 */
public class ReadFileIntoByteArray {


    /**
     * Returns the contents of the file in a byte array
     * @param file File this method should read
     * @return byte[] Returns a byte[] array of the contents of the file
     */
    public static byte[] getBytesFromFile(File file) throws IOException {

        InputStream is = new FileInputStream(file);        

        // Get the size of the file
        long length = file.length();        

        /*
         * You cannot create an array using a long type. It needs to be an int
         * type. Before converting to an int type, check to ensure that file is
         * not loarger than Integer.MAX_VALUE;
         */
        if (length > Integer.MAX_VALUE) {            
            return null;
        }

        // Create the byte array to hold the data
        byte[] bytes = new byte[(int)length];

        // Read in the bytes
        int offset = 0;
        int numRead = 0;
        while ( (offset < bytes.length)
                &&
                ( (numRead=is.read(bytes, offset, bytes.length-offset)) >= 0) ) {

            offset += numRead;

        }

        // Ensure all the bytes have been read in
        if (offset < bytes.length) {
            throw new IOException("Could not completely read file " + file.getName());
        }

        is.close();
        return bytes;

    }

    public static byte[] getBytesFromFile (File file, int numBytes) throws IOException {
        InputStream is = new FileInputStream(file);        

        //obtenemos la longitud del archivo
        long length = file.length();        

        // creamos el array para los datos
        byte[] bytes = null;

        // leemos el primer bloque (si la longitud es mayor a 16)
        if (length < numBytes){
            bytes = new byte [(int) length];
            is.read(bytes, 0, (int) length);
        } else {
            bytes = new byte [numBytes];
            is.read(bytes, 0, 16);
        }

        is.close();
        return bytes;
    }
}



