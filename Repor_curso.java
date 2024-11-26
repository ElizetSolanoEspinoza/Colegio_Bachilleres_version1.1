
package Reporte;

/**
 *
 * @author chico
 */
import Conexiones.Conectar;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.ClientAnchor;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Drawing;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Picture;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.util.IOUtils;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Repor_curso {
    public static void main(String[] args){
         reporte2();
        
    }
    
    
    
    
      public static void reporte2(){
           Workbook book = new XSSFWorkbook();
          Sheet sheet = book.createSheet("curso");
         
        try {
            //importar imagen para en excel
            InputStream is = new FileInputStream("src\\imagen\\tecnologico.png");
            byte[] bytes = IOUtils.toByteArray(is);
            int imgIndex = book.addPicture(bytes, Workbook.PICTURE_TYPE_PNG);
            is.close();
            
            CreationHelper help = book.getCreationHelper();
            Drawing draw = sheet.createDrawingPatriarch();
            
            ClientAnchor anchor = help.createClientAnchor();
            //en la coluna 1 se va poner la imagen
            anchor.setCol1(0);
            anchor.setRow1(1);
            Picture pict = draw.createPicture(anchor, imgIndex);
            //donde empieza el imagen y el espacio que va ocupar
            pict.resize(1, 2);
            //Estilo de titulo
            CellStyle tituloEstilo = book.createCellStyle();
            tituloEstilo.setAlignment(HorizontalAlignment.CENTER);
            tituloEstilo.setVerticalAlignment(VerticalAlignment.CENTER);
            //fuente
            Font fuenteTitulo=book.createFont();
            fuenteTitulo.setFontName("Arial");
            fuenteTitulo.setBold(true);
            fuenteTitulo.setFontHeightInPoints((short)14);
            tituloEstilo.setFont(fuenteTitulo);
            //creacion de fila donde esta el titulo
            Row filaTitulo = sheet.createRow(1);
            Cell celdaTitulo = filaTitulo.createCell(1);
            celdaTitulo.setCellStyle(tituloEstilo);
            celdaTitulo.setCellValue("Reporte de curso");
            sheet.addMergedRegion(new CellRangeAddress(1,2,1,2));
            //los titulos de reporte
            String[] cabecera = new String[]{"Id_Curso","Nombre_Curso","Horas","Id_Docente"};
            CellStyle headerStyle = book.createCellStyle();     
            headerStyle.setFillForegroundColor(IndexedColors.LIGHT_BLUE.getIndex());
            headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            headerStyle.setBorderBottom(BorderStyle.THIN);
            headerStyle.setBorderLeft(BorderStyle.THIN);
            headerStyle.setBorderRight(BorderStyle.THIN);
            headerStyle.setBorderBottom(BorderStyle.THIN);
            
            Font font=book.createFont();
            font.setFontName("Arial");
            font.setBold(true);
            font.setColor(IndexedColors.WHITE.getIndex());
            font.setFontHeightInPoints((short)12);
            headerStyle.setFont(font);
            
            Row filaEncabezados = sheet.createRow(4);
            //enbezado
            for(int i = 0; i < cabecera.length; i ++){
                
                Cell celdaEncabezado = filaEncabezados.createCell(i);
                celdaEncabezado.setCellStyle(headerStyle);
                celdaEncabezado.setCellValue(cabecera[i]);
                
            }
            //Contenido con mysql
            Conectar con= new Conectar();
            PreparedStatement ps;
            ResultSet rs;
            Connection conn = con.conexion();
            int numfilaDatos = 5;
             CellStyle datosEstilo = book.createCellStyle();     
            
            datosEstilo.setBorderBottom(BorderStyle.THIN);
            datosEstilo.setBorderLeft(BorderStyle.THIN);
            datosEstilo.setBorderRight(BorderStyle.THIN);
            datosEstilo.setBorderBottom(BorderStyle.THIN);
            
            ps = conn.prepareStatement("SELECT Id_Curso,Nombre_Curso, Horas,Id_Docente  FROM curso");
                    
            rs = ps.executeQuery();
            int numCol = rs.getMetaData().getColumnCount();
            double calificacion=0;
            
            
            //ajuste de la columnas
            sheet.autoSizeColumn(0);
            sheet.autoSizeColumn(1);
            sheet.autoSizeColumn(2);
            sheet.autoSizeColumn(3);
            //sheet.autoSizeColumn(4);
            sheet.setZoom(150);
            //aqui empieza el reporte
            //la ruta de nuestro formato de excel @francisco Diaz Diego
            
            FileOutputStream fileout = new FileOutputStream("C:\\Users\\chico\\Desktop\\Reporte de curso.xlsx");
             
            book.write(fileout);
            fileout.close();
         
           JOptionPane.showMessageDialog(null, "Reporte Fue creado en el Escritorio");  
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Excel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Excel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Excel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    
    
    
    
}
