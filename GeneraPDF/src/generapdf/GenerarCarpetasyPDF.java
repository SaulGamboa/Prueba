
package generapdf;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileOutputStream;
import javax.swing.JOptionPane;


public class GenerarCarpetasyPDF {
    public static  String ruta;
    
    public static void CrearCarpeta(String Nombre){
        File directorio=new File(Nombre);
        if(!(directorio.exists())){
           
            
              //Crea la carpeta
              directorio.mkdir();
             //Obtene y guardamos la ubicacion
              ruta=directorio.getAbsolutePath();
            
                   }else{
                  //Obtene y guardamos la ubicacion
                  ruta=directorio.getAbsolutePath();
        }
      
            

    }
    public static void CrearPDF(String Titulo,String txt){
    
    
        try{
                  //Manda la ruta de donde lo va a aguardar y el nombre
                  FileOutputStream archivo= new FileOutputStream(ruta+"\\"+Titulo+".pdf");
                  ///////////////////////////////////////////////////////////
                  Document doc= new Document();
                  PdfWriter.getInstance(doc, archivo);
                  doc.open();
                  //Crea el pdf con el contenido
                  doc.addTitle("Perros");
                  doc.add(new Paragraph(txt));
                  ///////////////////////////////////
                  doc.close();
                  JOptionPane.showMessageDialog(null, "Pdf creado con exito");
              }
              catch(Exception e){
                  
            JOptionPane.showMessageDialog(null, "Errror:"+e.getMessage());
                  
              }
        
                                   }
}
