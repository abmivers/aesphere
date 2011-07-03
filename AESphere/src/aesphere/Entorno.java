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
    private static Properties trans = new Properties();
    private static File confArchiv = null;
    private static File transArchiv = null;
    private static boolean badInit = false;

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
                    " settings", "Error", JOptionPane.ERROR_MESSAGE);
            //damos valor a las propiedades
            conf.setProperty("language", "ES");
            //creamos el archivo y lo almacenamos
            saveConf();
        } else //Cargamos la configuración
            loadConf();
        
        changeLang(conf.getProperty("language") );          
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
                    "Hubo un problema al guardar la configuración del programa.\n" +
                    "An error occurred while saving program configuration.", "Error",
                    JOptionPane.ERROR_MESSAGE);
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
                  "Hubo un problema al cargar la configuración del programa.\n" +
                  "An error occurred while loading program configuration.", "Error",
                  JOptionPane.ERROR_MESSAGE);
            badInit = true;
        }
    }
    
    private static void loadTrans() {
        try {
            //Creamos una referencia para poder cerrar el fichero tras la escritura
            FileInputStream in = new FileInputStream(transArchiv);
            trans.load(in);
            in.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                  "Hubo un problema al cargar la traducción.\n" +
                  "An error occurred while loading program translation.", "Error",
                  JOptionPane.ERROR_MESSAGE);
            badInit = true;
      }
    }

    /*
     * Interfaces dumb para acortar las sentencias en el programa y no permitir
     * acceso directo a la variable conf y otras
     */
    public static boolean getBadInit () {
        return badInit;
    }
    
    public static void setProperty (String key, String value) {
        conf.setProperty(key, value);
        saveConf();
    }

    public static String getProperty (String key) {
        return conf.getProperty(key);
    }
    
    public static String getTrans (String key) {
        return trans.getProperty(key);
    }
    
    public static void changeLang (String lang) {
        //limpiamos la traducción que hubiese cargada previamente
        if (transArchiv != null) {
            transArchiv = null;
            trans.clear();
        }
        
        //almacenamos el idioma nuevo en el fichero de configuración
        setProperty("language",lang);
        
        //obtenemos la cadena de idioma        
        String langCad = "translation_" + lang + ".conf";        
        transArchiv = new File("translations\\" + langCad);
        if (!transArchiv.exists()) {
            //avisamos de que la isntalación del programa está corrupta
            JOptionPane.showMessageDialog(null, "Faltan archivos de traducciones, " +
                    "por favor reinstale el programa.\n" +
                    "Translation files missing, please reinstall program.", "Error",
                    JOptionPane.ERROR_MESSAGE);
            badInit = true;
        } else  //Cargamos el fichero de traducciones
            loadTrans();
    }
}

