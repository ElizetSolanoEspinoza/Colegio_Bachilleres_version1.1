/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colegio;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author chico
 */
public class Principal extends javax.swing.JFrame {

    /**
     * Creates new form Principal
     */
    public Principal() {
        initComponents();
        
        
          cerrar();
        this.setLocationRelativeTo(null);
    }
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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnAlumnos = new javax.swing.JButton();
        btngestiodealumnos = new javax.swing.JButton();
        btngestiondecurso = new javax.swing.JButton();
        btncursos = new javax.swing.JButton();
        btngestiondecalificacion = new javax.swing.JButton();
        btnborrardatosdetablas = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        btnAlumnos.setText("Alumnos");
        btnAlumnos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlumnosActionPerformed(evt);
            }
        });

        btngestiodealumnos.setText("Gestion de alumnos");
        btngestiodealumnos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btngestiodealumnosActionPerformed(evt);
            }
        });

        btngestiondecurso.setText("Gestion de curso");
        btngestiondecurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btngestiondecursoActionPerformed(evt);
            }
        });

        btncursos.setText("cursos");
        btncursos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncursosActionPerformed(evt);
            }
        });

        btngestiondecalificacion.setText("Gestion de calificacion");
        btngestiondecalificacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btngestiondecalificacionActionPerformed(evt);
            }
        });

        btnborrardatosdetablas.setText("borrar datos de tablas");
        btnborrardatosdetablas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnborrardatosdetablasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(111, 111, 111)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnborrardatosdetablas)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btncursos)
                            .addComponent(btnAlumnos))
                        .addGap(186, 186, 186)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btngestiondecurso)
                            .addComponent(btngestiodealumnos)))
                    .addComponent(btngestiondecalificacion))
                .addContainerGap(69, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAlumnos)
                    .addComponent(btngestiodealumnos))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btngestiondecurso)
                    .addComponent(btncursos))
                .addGap(39, 39, 39)
                .addComponent(btngestiondecalificacion)
                .addGap(56, 56, 56)
                .addComponent(btnborrardatosdetablas)
                .addContainerGap(108, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAlumnosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlumnosActionPerformed
        //
        Registra_Alumnos registra_Alumnos=new Registra_Alumnos();
        registra_Alumnos.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnAlumnosActionPerformed

    private void btncursosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncursosActionPerformed
        // TODO add your handling code here:
        Registro_curso registro_curso=new Registro_curso();
        registro_curso.setVisible(true);
        dispose();
    }//GEN-LAST:event_btncursosActionPerformed

    private void btngestiodealumnosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btngestiodealumnosActionPerformed
        // 
        Gestion_alumnos gestion_alumnos=new Gestion_alumnos();
        gestion_alumnos.setVisible(true);
        dispose();
    }//GEN-LAST:event_btngestiodealumnosActionPerformed

    private void btngestiondecursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btngestiondecursoActionPerformed
        // TODO add your handling code here:
        Gestion_cursos gestion_cursos = new Gestion_cursos();
        gestion_cursos.setVisible(true);
        dispose();
    }//GEN-LAST:event_btngestiondecursoActionPerformed

    private void btngestiondecalificacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btngestiondecalificacionActionPerformed
       Gestion_calificaciones gestion_calificaciones = new Gestion_calificaciones();
       gestion_calificaciones.setVisible(true);
       dispose();
    }//GEN-LAST:event_btngestiondecalificacionActionPerformed

    private void btnborrardatosdetablasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnborrardatosdetablasActionPerformed
        // TODO add your handling code here:
        Eliminar_tareas eliminar_tareas=new Eliminar_tareas();
        eliminar_tareas.setVisible(true);
        dispose();
        
        
    }//GEN-LAST:event_btnborrardatosdetablasActionPerformed

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
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlumnos;
    private javax.swing.JButton btnborrardatosdetablas;
    private javax.swing.JButton btncursos;
    private javax.swing.JButton btngestiodealumnos;
    private javax.swing.JButton btngestiondecalificacion;
    private javax.swing.JButton btngestiondecurso;
    // End of variables declaration//GEN-END:variables
}