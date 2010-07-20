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
     * method to convert a byte to a hex string.
     *
     * @param data the byte to convert
     * @return String the converted byte
     */
    public static String byteToHex(byte data) {

        StringBuffer buf = new StringBuffer();
        buf.append(toHexChar((data >>> 4) & 0x0F));
        buf.append(toHexChar(data & 0x0F));

        return buf.toString();
    }


    /**
     * Convenience method to convert an int to a hex char.
     *
     * @param i the int to convert
     * @return char the converted char
     */
    public static char toHexChar(int i) {
        if ((0 <= i) && (i <= 9)) {
            return (char) ('0' + i);
        } else {
            return (char) ('a' + (i - 10));
        }
    }


    /**
     * Returns the contents of the file in a byte array
     * @param file File this method should read
     * @return byte[] Returns a byte[] array of the contents of the file
     */
    public static byte[] getBytesFromFile(File file) throws IOException {

        InputStream is = new FileInputStream(file);
        System.out.println("\nDEBUG: FileInputStream is " + file);

        // Get the size of the file
        long length = file.length();
        System.out.println("DEBUG: Length of " + file + " is " + length + "\n");

        /*
         * You cannot create an array using a long type. It needs to be an int
         * type. Before converting to an int type, check to ensure that file is
         * not loarger than Integer.MAX_VALUE;
         */
        if (length > Integer.MAX_VALUE) {
            System.out.println("File is too large to process");
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
        System.out.println("\nDEBUG: FileInputStream is " + file);

        //obtenemos la longitud del archivo
        long length = file.length();
        System.out.println("DEBUG: Length of " + file + " is " + length + "\n");

        // creamos el array para los datos
        byte[] bytes = null;

        // leemos el primer bloque (si la longitud es mayor a 16)
        if (length < numBytes)
            is.read(bytes, 0, (int) length);
        else
            is.read(bytes, 0, 16);

        is.close();
        return bytes;
    }


    /**
     * Sole entry point to the class and application.
     * @param args Array of String arguments.
     */
    public static void main(String[] args) {

        byte[] fileArray = null;

        try {
            fileArray = getBytesFromFile(new File("c:/plaintext.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (fileArray != null) {
            for (int i=0; i<fileArray.length; i++) {

                System.out.println(
                    "fileArray[" + i + "] = " +
                    ((int)fileArray[i] < 9  ? "  " : "") +
                    ( ((int)fileArray[i] > 9 && (int)fileArray[i] <= 99) ? " " : "") +
                    fileArray[i] + " : " +
                    " HEX=(0x" + byteToHex(fileArray[i]) + ") : " +
                    " charValue=(" + (char)fileArray[i] + ")");
            }
        }

    }

}



