/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package aesphere;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;
import javax.swing.JOptionPane;


/**
 *
 * @author admin
 */
public class Entorno {
    private static Properties conf = new Properties();
    private static File confArchiv = null;

    public Entorno () {
        /*
         * Si no existe el archivo de configuración, creamos uno
         */
        confArchiv = new File("user.conf");
        if (!confArchiv.exists()) {
            //avisamos de que se va a crear un nuevo archivo de configuración
            JOptionPane.showMessageDialog(null,
                    "No se encuentra el archivo de configuración del programa," +
                    " restaurando ajustes\n" +
                    "The configuration file is missing, restoring program" +
                    " settings");
            //damos valor a las propiedades
            conf.setProperty("language", "ES");
            //creamos el archivo y lo almacenamos
            saveConf();
        } else //Cargamos la configuración
            loadConf();
    }

    /**
     * Procedimiento a lanzar cada vez que se cambie una configuración que sea
     * necesario almacenar entre ejecuciones.
     */
    private static void saveConf() {
        try {
          //Creamos una referencia para poder cerrar el fichero tras la escritura
          FileOutputStream out = new FileOutputStream(confArchiv);
          conf.store(out, null);
          out.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "Hubo un problema al guardar la configuración del programa");
        }
    }

    /**
     * Procedimiento a lanzar al inicio del programa para cargar la
     * configuración
     */
    private static void loadConf() {
      try {
          //Creamos una referencia para poder cerrar el fichero tras la escritura
          FileInputStream in = new FileInputStream(confArchiv);
          conf.load(in);
          in.close();
      } catch (Exception e) {
          JOptionPane.showMessageDialog(null,
                  "Hubo un problema al cargar la configuración del programa");
      }
    }

    /*
     * Interfaces dumb para acortar las sentencias en el programa y no permitir
     * acceso directo a la variable conf
     */
    public static void setProperty (String key, String value) {
        conf.setProperty(key, value);
        saveConf();
    }

    public static String getProperty (String key) {
        return conf.getProperty(key);
    }
}

