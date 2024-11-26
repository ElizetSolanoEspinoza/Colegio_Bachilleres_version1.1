/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colegio;

import Conexiones.Conectar;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;

import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author chico
 */
public class Informacion_alumnos extends javax.swing.JFrame {

    /**
     * Creates new form Informacion_alumnos
     */
    
    DefaultTableModel modelo = new DefaultTableModel();
        int idalumno=0;
        public static int idcalificacion=0;
        String nombre="";
        String apellido="";
        
    public Informacion_alumnos() {
        initComponents();
        this.setLocationRelativeTo(null);
        txtnombre.setEditable(false);
         TextPrompt n=new TextPrompt("Ingrese su nombre",txtnombre);
        TextPrompt a=new TextPrompt("Ingrese su apellido",txtapellido);
        TextPrompt d=new TextPrompt("Ingrese su Telefono",txttelefono);
        cerrar();
        idalumno=Gestion_alumnos.idalumno;
        
        try{
            Connection cn=con.conexion();
            PreparedStatement ps=cn.prepareStatement("SELECT * FROM alumnos WHERE id_alumno='"+idalumno+"'");
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                setTitle("Informacion del alumno "+rs.getString("nombre"));
                lblinfo_alumno.setText("Informacion del alumno: "+rs.getString("nombre"));
                txtnombre.setText(rs.getString("nombre"));
                txtapellido.setText(rs.getString("apellido"));
                cmbgrado.setSelectedItem(rs.getString("grado"));
                txttelefono.setText(rs.getString("Telefono"));
                
            }
            ////////
           
        }catch(SQLException e){
            System.err.println(e);
            JOptionPane.showMessageDialog(null,"Error al cargar alumno...Contacte al administrador");
        }
        /////////////////////////////////////////////////////////////////////////////////////////
        try{
            PreparedStatement pst=cn.prepareStatement("SELECT id_nota, tarea,calificacion FROM notas WHERE id_alumno_nota='"+idalumno+"'");
            ResultSet rs=pst.executeQuery();
            tabla_calificacion=new JTable(modelo);
            jScrollPane1.setViewportView(tabla_calificacion);
            
            modelo.addColumn("Id nota");
            modelo.addColumn("Tarea");
            modelo.addColumn("Calificacion");
            
            while(rs.next()){
                Object[] fila=new Object[3];
                for(int i =0; i<3;i++){
                    
                    fila[i]=rs.getObject(i+1);
                }
                modelo.addRow(fila);
               ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
               int filax=0;
               int total=0;
               for(int i=0; i < tabla_calificacion.getRowCount();i++){
                   filax=Integer.parseInt(tabla_calificacion.getValueAt(i, 2).toString());
                   total+=filax;
                   txtcalificacion.setText(""+total);
               }
               int califa=Integer.parseInt(txtcalificacion.getText());
               if(califa>=80){
                   lblaprobado.setText(String.valueOf("Aprobado"));
                   txtcalificacion.setBackground(Color.green);
               }else{
                   lblaprobado.setText(String.valueOf("Reprobado"));
                   txtcalificacion.setBackground(Color.red);
               }
                
            }
        }catch(Exception e){
            System.err.println("Error en el llenado de la tabla calificaciones");
            //JOptionPane.showMessageDialog(null,"Error al cargar alumno...Contacte al administrador");
        }
        /////////////////////////////////////////////////////////
         tabla_calificacion.addMouseListener(new MouseAdapter(){
           
            @Override
            public void mouseClicked(MouseEvent e){
                int fila_point=tabla_calificacion.rowAtPoint(e.getPoint());
                int columna_point=0;
                if(fila_point>-1){
                    idcalificacion=(int)modelo.getValueAt(fila_point, columna_point);
                    Informacion_calificaciones informacion_calificaciones=new Informacion_calificaciones();
                    informacion_calificaciones.setVisible(true);
                    dispose();
                }
            }
            
        });
    }
    //////////////////////////////////////
    public void cerrar(){
       try{
           this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
           addWindowListener(new WindowAdapter(){
             public void windowClosing(WindowEvent e){
                 confirmarsalida();
             }  
           }
           );
           
       }catch (Exception e){
           
       }
    }
    ///Metodo
    public void confirmarsalida(){
       // int valor = JOptionPane.showConfirmDialog
        //(this,"¿Desea cerrar la aplicacion?","Advertencia",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
        /*if(valor==JOptionPane.YES_OPTION){
            JOptionPane.showMessageDialog(null, "Hasta Pronto","",JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);*/
            
             int confirmado = JOptionPane.showConfirmDialog(null, "Está seguro de Salir");
        if (JOptionPane.OK_OPTION==confirmado){
            LOGIN frm=new LOGIN();
       frm.setVisible(true);
        this.setVisible(false);
            
        }
    }
//////////////////////////////////////////////////
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblinfo_alumno = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtnombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtapellido = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        cmbgrado = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        txttelefono = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_calificacion = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        lblaprobado = new javax.swing.JTextField();
        btnimprimir = new javax.swing.JButton();
        btnvolver = new javax.swing.JButton();
        btnregistrarcalificacion = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txtcalificacion = new javax.swing.JTextField();
        btnconstacia = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 0, 153));

        lblinfo_alumno.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N
        lblinfo_alumno.setForeground(new java.awt.Color(255, 255, 255));
        lblinfo_alumno.setText("Información Alumno");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(365, 365, 365)
                .addComponent(lblinfo_alumno, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblinfo_alumno)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos"));

        jLabel2.setText("Nombre:");

        txtnombre.setEnabled(false);

        jLabel3.setText("Apellido:");

        txtapellido.setEnabled(false);

        jLabel4.setText("Grado:");

        cmbgrado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6" }));
        cmbgrado.setEnabled(false);

        jLabel5.setText("Telefono:");

        txttelefono.setEnabled(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtapellido, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel4)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(cmbgrado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txttelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 20, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtapellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(cmbgrado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txttelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        tabla_calificacion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tabla_calificacion);

        jLabel6.setText("Estatus:");

        lblaprobado.setEnabled(false);

        btnimprimir.setText("imprimir");
        btnimprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnimprimirActionPerformed(evt);
            }
        });

        btnvolver.setText("Volver");
        btnvolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnvolverActionPerformed(evt);
            }
        });

        btnregistrarcalificacion.setText("Registrar calificaciones");
        btnregistrarcalificacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnregistrarcalificacionActionPerformed(evt);
            }
        });

        jLabel7.setText("Calificaciones:");

        btnconstacia.setText("Costancia de buen conducta");
        btnconstacia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnconstaciaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnvolver)
                        .addGap(28, 28, 28)
                        .addComponent(btnregistrarcalificacion)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 718, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblaprobado, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48))
            .addGroup(layout.createSequentialGroup()
                .addGap(345, 345, 345)
                .addComponent(btnimprimir)
                .addGap(95, 95, 95)
                .addComponent(btnconstacia)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtcalificacion, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(80, 80, 80))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblaprobado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnvolver)
                                    .addComponent(btnregistrarcalificacion)))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(79, 79, 79))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnimprimir)
                            .addComponent(jLabel7)
                            .addComponent(txtcalificacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnconstacia))
                        .addGap(27, 27, 27))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnvolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnvolverActionPerformed
        // TODO add your handling code here:
         Gestion_alumnos gestion_alumnos=new Gestion_alumnos();
        gestion_alumnos.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnvolverActionPerformed

    private void btnregistrarcalificacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnregistrarcalificacionActionPerformed
        // TODO add your handling code here:
        Registra_calificaciones registra_calificaciones=new Registra_calificaciones();
        registra_calificaciones.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnregistrarcalificacionActionPerformed

    private void btnimprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnimprimirActionPerformed
        // TODO add your handling code here:
        Document documento=new Document();
        
        Calendar cal= Calendar.getInstance();
        Date fecha=new Date(cal.getTimeInMillis());
        SimpleDateFormat  formato=new SimpleDateFormat("dd/MM/yyyy");
        
        String verfecha=formato.format(fecha);
        
        try{
            String ruta=System.getProperty("user.home");
            PdfWriter.getInstance(documento, new FileOutputStream(ruta+"/desktop/"+txtnombre.getText()+".pdf"));
            
            Paragraph parrafo=new Paragraph();
            parrafo.setAlignment(Paragraph.ALIGN_CENTER);
            parrafo.setFont(FontFactory.getFont("Arial", 20, BaseColor.BLACK));
            parrafo.add("Informacion del alumno. \n \n ");
            
            Paragraph poner_fecha=new Paragraph();
            poner_fecha.setAlignment(Paragraph.ALIGN_RIGHT);
            poner_fecha.add("Fecha: "+verfecha+"\n \n");
            
            documento.open();
            documento.add(parrafo);
            documento.add(poner_fecha);
            PdfPTable tablaalumno=new PdfPTable(4);
            tablaalumno.addCell("Nombre");
            tablaalumno.addCell("Apellido");
            tablaalumno.addCell("Grado");
            tablaalumno.addCell("Materia");
            
            try{
                PreparedStatement ps=cn.prepareStatement("SELECT * FROM alumnos WHERE id_alumno='"+idalumno+"'");
                ResultSet rs=ps.executeQuery();
                if(rs.next()){
                    do {
                        //los datos de base de datos
                        tablaalumno.addCell(rs.getString("nombre"));
                        tablaalumno.addCell(rs.getString("apellido"));
                        tablaalumno.addCell(rs.getString("grado"));
                        tablaalumno.addCell(rs.getString("id_curso_asignado"));
                        
                    }while(rs.next());{
                    documento.add(tablaalumno);
                }
                 
                }
                Paragraph parrafo2=new Paragraph();
               parrafo2.setAlignment(Paragraph.ALIGN_CENTER);
                parrafo2.setFont(FontFactory.getFont("Arial", 20, BaseColor.BLACK));
                parrafo2.add("\n \n Tareas Registradas \n \n");
                documento.add(parrafo2);
                PdfPTable tablatareas=new PdfPTable(2);
                
                tablatareas.addCell("Tarea");
                 tablatareas.addCell("Calificacion");
                 try{
                     Connection cn2=con.conexion();
                     PreparedStatement ps2=cn2.prepareStatement("SELECT tarea,calificacion FROM notas WHERE id_alumno_nota='"+idalumno+"'");
                     ResultSet rs2=ps2.executeQuery();
                     if(rs2.next()){
                         do{
                            tablatareas.addCell(rs2.getString(1));
                            tablatareas.addCell(rs2.getString(2));
                         }while(rs2.next());{
                         documento.add(tablatareas);
                       }
                     }
                     
                     
                     
                 }catch(SQLException e){
                     System.err.println("Error al carga de tarea "+e);
                 }
                /////////////////////////////////////////////////////////
            }catch(SQLException e){
                 System.err.println("Error al obtener datos del alumno "+e);
            }
            
            /////////////////////////////////////////////////////////////////////////
            documento.close();
            JOptionPane.showMessageDialog(null, "Documento fue creado existosamento");
            
            
            
        }catch(DocumentException | IOException e){
             System.err.println("Error al obtener datos del alumno "+e);
             JOptionPane.showMessageDialog(null, "Error al generar PDF....Contactar al administrador");
            
        }
        
    }//GEN-LAST:event_btnimprimirActionPerformed

    private void btnconstaciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnconstaciaActionPerformed
        // TODO add your handling code here:
        
           Document documento=new Document();
        String nombre_alumno;
        Calendar cal= Calendar.getInstance();
        Date fecha=new Date(cal.getTimeInMillis());
        SimpleDateFormat  formato=new SimpleDateFormat("dd/MM/yyyy");
        
        String verfecha=formato.format(fecha);
        
        try{
            String ruta=System.getProperty("user.home");
            PdfWriter.getInstance(documento, new FileOutputStream(ruta+"/desktop/CONSTANCIA DE BUENA CONDUCTA DE "+txtnombre.getText()+".pdf"));
            
            Image header = Image.getInstance("src/imagen/cole.jpg");
            header.scaleToFit(45,45);
            header.setAlignment(Chunk.ALIGN_LEFT);
            
            
            
            
            
            Paragraph parrafo=new Paragraph();
            parrafo.setAlignment(Paragraph.ALIGN_CENTER);
            parrafo.setFont(FontFactory.getFont("Arial", 20,Font.BOLD, BaseColor.BLACK));
            parrafo.add("COLEGIO DE BACHILLERES PLANTEL \n");
            parrafo.add("MUNICIPAL INCORPORADO TLAQUILTZINAPA  \n \n ");
            
          /*  Paragraph poner_fecha=new Paragraph();
            poner_fecha.setAlignment(Paragraph.ALIGN_RIGHT);
            poner_fecha.add("Fecha: "+verfecha+"\n \n ");
            */
            Paragraph parrafo1=new Paragraph();
            parrafo1.setAlignment(Paragraph.ALIGN_RIGHT);
            parrafo1.setFont(FontFactory.getFont("Arial", 11,Font.BOLD, BaseColor.BLACK));
            parrafo1.add("CONSTACIA DE\n");
            parrafo1.add("CONDUCTA \n \n");
            
            
             Paragraph parrafo3=new Paragraph();
            parrafo3.setAlignment(Paragraph.ALIGN_LEFT);
            parrafo3.setFont(FontFactory.getFont("Arial", 11, BaseColor.BLACK));
            parrafo3.add("A QUEN CORRESPONDA. \n\n");
             
            
             Paragraph parrafo4=new Paragraph();
            parrafo4.setAlignment(Paragraph.ALIGN_JUSTIFIED);
            parrafo4.setFont(FontFactory.getFont("Arial", 11, BaseColor.BLACK));
            parrafo4.add("El quen suscribe NORA CORTAZAR Director de la Escuela 'CARMEN SARDAN' Con el matricula\n\n");

            Paragraph parrafo5=new Paragraph();
            parrafo5.setAlignment(Paragraph.ALIGN_CENTER);
            parrafo5.setFont(FontFactory.getFont("Arial", 20,Font.BOLD, BaseColor.BLACK));
            parrafo5.add("H A C E  C O N S T A R \n\n");
            
             Paragraph parrafo6=new Paragraph();
            parrafo6.setAlignment(Paragraph.ALIGN_LEFT);
            parrafo6.setFont(FontFactory.getFont("Arial", 11, BaseColor.BLACK));
            parrafo6.add("Que ella alumno(a)\n\n");
            
           
            documento.open();
             documento.add(header);
            
            documento.add(parrafo);
            //documento.add(poner_fecha);
            documento.add(parrafo1);
            documento.add(parrafo3);
            documento.add(parrafo4);
            documento.add(parrafo5);
            documento.add(parrafo6);
            
          PdfPTable tablaalumno=new PdfPTable(2);
          /*tablaalumno.addCell("Nombre");
            tablaalumno.addCell("Apellido");
            tablaalumno.addCell("Grado");
            tablaalumno.addCell("Materia");*/
            
            try{
                PreparedStatement ps=cn.prepareStatement("SELECT nombre, apellido FROM alumnos WHERE id_alumno='"+idalumno+"'");
                ResultSet rs=ps.executeQuery();
                if(rs.next()){
                    do {
                        //los datos de base de datos
                       tablaalumno.addCell(rs.getString("nombre"));
                        tablaalumno.addCell(rs.getString("apellido"));
                       /////////////////////////////////////
                 nombre=rs.getString("nombre");
               apellido=rs.getString("apellido");
               Paragraph parranombre1=new Paragraph();
               parranombre1.setAlignment(Paragraph.ALIGN_CENTER);
                parranombre1.setFont(FontFactory.getFont("Arial", 13,Font.BOLD, BaseColor.BLACK));
                parranombre1.add("\n"+nombre+"   "+apellido+"");
                parranombre1.add("\n\n");
                 documento.add(parranombre1); 
                       //////////////////////////////////////////////////////
                    }while(rs.next());{
                    //documento.add(parranombre1);
                   //documento.add(tablaalumno);
                }
                 
                }
                Paragraph parrafo2=new Paragraph();
               parrafo2.setAlignment(Paragraph.ALIGN_JUSTIFIED);
                parrafo2.setFont(FontFactory.getFont("Arial", 11, BaseColor.BLACK));
                parrafo2.add("\n \n Curso su Educacion PRIMARIA GENERAL en esta institucion  Educativa a mi cargo, y durante \n");
                parrafo2.add("su estancia en la misma observo \n\n");
                
                 Paragraph parrafo8=new Paragraph();
               parrafo8.setAlignment(Paragraph.ALIGN_CENTER);
                parrafo8.setFont(FontFactory.getFont("Arial", 14,Font.BOLD, BaseColor.BLACK));
                parrafo8.add("Buena CONDUCTA \n\n");
                
                Paragraph parrafo9=new Paragraph();
               parrafo9.setAlignment(Paragraph.ALIGN_JUSTIFIED);
                parrafo9.setFont(FontFactory.getFont("Arial", 11, BaseColor.BLACK));
                parrafo9.add("\n \n A peticion de la parte interesada y para los usos legales que le convengan se extiende la\n");
                parrafo9.add("presente CONSTANCIA  en COATZACOALCON con la fecha "+verfecha+"\n\n");
                
                 Paragraph parrafo10=new Paragraph();
               parrafo10.setAlignment(Paragraph.ALIGN_CENTER);
                parrafo10.setFont(FontFactory.getFont("Arial", 14,Font.BOLD, BaseColor.BLACK));
                parrafo10.add(" ATENTAMENTE\n\n\n");
                
                 Paragraph parrafo11=new Paragraph();
               parrafo11.setAlignment(Paragraph.ALIGN_CENTER);
                parrafo11.setFont(FontFactory.getFont("Arial", 14,Font.BOLD, BaseColor.BLACK));
                parrafo11.add("_________________________________\n");
                parrafo11.add("NORA CORTAZAR LUNA\n");
                   parrafo11.add("DIRECTOR(A)\n");
                
                
                documento.add(parrafo2);
                 documento.add(parrafo8);
                 documento.add(parrafo9);
                  documento.add(parrafo10);
                   documento.add(parrafo11);
             
                
                
                /////////////////////////////////////////////////////////
            }catch(SQLException e){
                 System.err.println("Error al obtener datos del alumno "+e);
            }
            
            /////////////////////////////////////////////////////////////////////////
            documento.close();
            JOptionPane.showMessageDialog(null, "Documento fue creado existosamento");
            
            
            
        }catch(DocumentException | IOException e){
             System.err.println("Error al obtener datos del alumno "+e);
             JOptionPane.showMessageDialog(null, "Error al generar PDF....Contactar al administrador");
            
        }
        
    }//GEN-LAST:event_btnconstaciaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Informacion_alumnos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Informacion_alumnos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Informacion_alumnos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Informacion_alumnos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Informacion_alumnos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnconstacia;
    private javax.swing.JButton btnimprimir;
    private javax.swing.JButton btnregistrarcalificacion;
    private javax.swing.JButton btnvolver;
    private javax.swing.JComboBox<String> cmbgrado;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField lblaprobado;
    private javax.swing.JLabel lblinfo_alumno;
    private javax.swing.JTable tabla_calificacion;
    private javax.swing.JTextField txtapellido;
    private javax.swing.JTextField txtcalificacion;
    private javax.swing.JTextField txtnombre;
    private javax.swing.JTextField txttelefono;
    // End of variables declaration//GEN-END:variables
     Conectar con = new Conectar();
    Connection cn=con.conexion();
}
