 
/* @author Job Zwiers  
 * @version  0, revision $Revision: 1.2 $,
 * $Date: 2001/10/23 15:44:11 $    
 * @since version 0       
 */


import java.io.*;

import java.util.*;

/**
 * A Configuration is an extension of Properties, that loads properties from a file.
 * It inherits methods like getProperty(String name), getProperty(String name, String default)
 * which can be used to retrieve properties loaded from file.
 * 
 */
public class Configuration extends Properties
{ 

   /**
    * creates an empty Configuration
    */
   public Configuration() {
      super();
   }
  
   /**
    * creates a new Configuration and loads it from file.
    */
   public Configuration(String configFile) {
      super();
      setProperty("configFile", configFile);
      load();
   }
  
 
   /**
    * creates Configuration and loads it from configFile.
    * If not found, and create ==true,  a new Configuration file with default settings
    * is created.
    */
   public Configuration(String configFile, boolean create) {
      super();
      setProperty("configFile", configFile);
      boolean loaded = load();
      if (!loaded && create) {
         reset();
         save(); 
      }
   } 
   
   /**
    * saves the current Configuration contents to the current configFile,
    * or to DEFAULT_CONFIG_FILE, if the configFile property has not been set.
    */
   public void save() {
      save(getProperty("configFile", DEFAULT_CONFIG_FILE));
   }

   /**
    * saves the current Configuration contents to configFile,
    */
   public void  save(String configFile) {
     try {
        OutputStream configOut = new FileOutputStream(configFile);
        store(configOut, "j3d configuration");
        configOut.close();
     } catch (IOException e) { System.out.println("Could not save configuration: " + e); }
   }

   /**
    * loads the Configuration contents from the current configFile,
    * or from DEFAULT_CONFIG_FILE, if the configFile property has not been set.
    */
   public boolean load() {
     return load(getProperty("configFile", DEFAULT_CONFIG_FILE));
   }

   /**
    * loads the Configuration contents from configFile,
    */   
   public boolean load(String configFile) {
     try {
        InputStream configIn = new FileInputStream(configFile);
        load(configIn);
        configIn.close();
        return true;
     }
     catch (FileNotFoundException e) { 
        System.out.println("Could not find configuration file \"" + configFile + "\""); 
        return false;
     }
     catch (IOException e) { 
        System.out.println("Could not load configuration: " + e); 
        return false;
     }
   }

   /**
    * resets the Configuration to a set of defaults.
    */
   public void reset() {
      //setProperty("configFile", DEFAULT_CONFIG_FILE);
      setProperty("texturePath", "texture");
      setProperty("vrmlPath", "vrml");
      setProperty("baseDirectory", ".");
   }
 
   public static String getBase() {
      if (base == null ) {
         String classpath = System.getProperty("java.class.path");
         //System.out.println("Classpath = " + classpath);
         char pathsep = (System.getProperty("path.separator")).charAt(0);
         File baseFile = new File(classpath.substring(0, classpath.indexOf(pathsep)));
         //System.out.println("Absolute path: " + base.getAbsolutePath());
         base = baseFile.getAbsolutePath();
      }
      return base;
   }
    
   public static final String DEFAULT_CONFIG_FILE = "j3dconfig.txt";
   public static String base;

 
}