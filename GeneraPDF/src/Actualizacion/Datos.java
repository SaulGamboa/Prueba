/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actualizacion;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Dell
 */
public class Datos {
   public static int con;
   public static   String name;
    public static void Actualizacion(String url){
    
      name = "SistemaConalep.jar"; //nombre del archivo destino
        //Directorio destino para las descargas y crear la carpeta
        String NombreCarpeta="Actualizaciones";
        
        generapdf.GenerarCarpetasyPDF.CrearCarpeta(NombreCarpeta);
        String folder = generapdf.GenerarCarpetasyPDF.ruta+"\\";
        //Crear el tipo de archivo
        File file = new File(folder+ name);
        //Establece la conexion con la url mediante una clase URLConnection:
        URLConnection conn;
       if(!( file.exists())){
        try {
            try{
            conn = new URL(url).openConnection();
            conn.connect();
        
        System.out.println("\nempezando descarga: \n");
        System.out.println(">> URL: " + url);
        System.out.println(">> Nombre: " + name);
        System.out.println(">> tamaño: " + conn.getContentLength() + " bytes");
        InputStream in = conn.getInputStream();
        OutputStream out = new FileOutputStream(file);
        
//        Mediante un bucle vamos leyendo del InputStream y vamos escribiendo en el OutputStream.
//        Vamos leyendo de a un byte por vez y los escribe en un archivo. El -1 significa que se llego al final.
        int b = 0;
        while (b != -1) {
        b = in.read();
        if (b != -1)
        out.write(b);
                         }
        out.close();
        in.close();
            }catch (MalformedURLException ex) {
            Logger.getLogger(Panel.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null,"Erro url:" +ex.getMessage());
        }
        } catch (IOException ex) {
          JOptionPane.showMessageDialog(null,"Erro file:" +ex.getMessage());
        }
    
    
    
   
         
  
          

           
       
       }else{
 System.exit(0);
       }
    }
   
}

