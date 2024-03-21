/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Dashboard;

import Classes.AI;
import Classes.Admin;
import Classes.Queues;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.lang.Thread.sleep;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.Timer;

/**
 *
 * @author José
 */
public class Dashboard extends javax.swing.JFrame {

    /**
     * Creates new form Dashboard
     */
    
    public Semaphore sem;
    public Semaphore s;
    public Semaphore mutex;
    public Admin admin;
    private AI ai;
    private int counter = 0;
    
    public Dashboard() {
        initComponents();
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.sem = new Semaphore(0);
        this.s = new Semaphore(0);
        this.mutex = new Semaphore(1);
        this.admin = new Admin(sem, 20, ai, getSldDuracion().getValue(), this, s, mutex);
        
    }
    
    public JTextPane getPanelAvatar(){
        return infoAvatar;
    }
    
    public JTextPane getPanelUsm(){
        return infoUsm;
    }
    
    public JTextField getVictoriasAvatarLabel(){
        return getTxtVictoriasAvatar();
    }
    
    public JTextField getVictoriasUsmLabel(){
        return txtVictoriasUSM;
    }

    public JTextField getTxtGanadores() {
        return txtGanadores;
    }

    public JTextField getTxtP1Avatar() {
        return txtP1Avatar;
    }

    public JTextField getTxtP1USM() {
        return txtP1USM;
    }

    public JTextField getTxtP2Avatar() {
        return txtP2Avatar;
    }

    public JTextField getTxtP2USM() {
        return txtP2USM;
    }

    public JTextField getTxtP3Avatar() {
        return txtP3Avatar;
    }

    public JTextField getTxtP3USM() {
        return txtP3USM;
    }

    public JTextField getTxtRefuerzosAvatar() {
        return txtRefuerzosAvatar;
    }

    public JTextField getTxtRefuerzosUSM() {
        return txtRefuerzosUSM;
    }

    public JTextField getTxtVictoriasUSM() {
        return txtVictoriasUSM;
    }
    
    public JTextField getTxtDecisionIA(){
        return txtDecisionIA;
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new ImagePanel("/Images/Avatar_vs_USM.png");
        duracionCombate = new javax.swing.JLabel();
        txtVictoriasAvatar = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txtRefuerzosAvatar = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtP3Avatar = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtP2Avatar = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtP1Avatar = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        sldDuracion = new javax.swing.JSlider();
        txtGanadores = new javax.swing.JTextField();
        txtVictoriasUSM = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtRefuerzosUSM = new javax.swing.JTextField();
        txtP3USM = new javax.swing.JTextField();
        txtP2USM = new javax.swing.JTextField();
        txtP1USM = new javax.swing.JTextField();
        txtDecisionIA = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        btnStart = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        infoAvatar = new javax.swing.JTextPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        infoUsm = new javax.swing.JTextPane();
        imgUSM = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        imgAvatar = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        resultsPane = new javax.swing.JTextPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        duracionCombate.setText("10");
        jPanel2.add(duracionCombate, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 20, 43, -1));

        txtVictoriasAvatar.setEditable(false);
        txtVictoriasAvatar.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtVictoriasAvatar.setText("0");
        jPanel2.add(txtVictoriasAvatar, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 480, 71, -1));

        jLabel16.setText("Victorias");
        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 450, -1, -1));

        txtRefuerzosAvatar.setEditable(false);
        txtRefuerzosAvatar.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtRefuerzosAvatar.setText("Vacío");
        jPanel2.add(txtRefuerzosAvatar, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 404, 350, -1));

        jLabel15.setText("Refuerzos");
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(43, 389, -1, -1));

        txtP3Avatar.setEditable(false);
        txtP3Avatar.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtP3Avatar.setText("Vacío");
        jPanel2.add(txtP3Avatar, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 324, 350, -1));

        jLabel14.setText("Prioridad 3");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 300, -1, -1));

        txtP2Avatar.setEditable(false);
        txtP2Avatar.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtP2Avatar.setText("Vacío");
        jPanel2.add(txtP2Avatar, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 246, 350, -1));

        jLabel13.setText("Prioridad 2");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 222, -1, -1));

        txtP1Avatar.setEditable(false);
        txtP1Avatar.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtP1Avatar.setText("Vacío");
        jPanel2.add(txtP1Avatar, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 174, 350, -1));

        jLabel12.setText("Prioridad 1");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 149, -1, -1));

        jLabel11.setText("Duración Combate:");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 20, -1, -1));

        sldDuracion.setMajorTickSpacing(1);
        sldDuracion.setMaximum(20);
        sldDuracion.setMinimum(1);
        sldDuracion.setMinorTickSpacing(1);
        sldDuracion.setPaintLabels(true);
        sldDuracion.setPaintTicks(true);
        sldDuracion.setSnapToTicks(true);
        sldDuracion.setValue(10);
        sldDuracion.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sldDuracionStateChanged(evt);
            }
        });
        jPanel2.add(sldDuracion, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 40, 358, -1));

        txtGanadores.setEditable(false);
        txtGanadores.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtGanadores.setText("Vacío");
        jPanel2.add(txtGanadores, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 680, 387, -1));

        txtVictoriasUSM.setEditable(false);
        txtVictoriasUSM.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtVictoriasUSM.setText("0");
        jPanel2.add(txtVictoriasUSM, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 490, 71, -1));

        jLabel10.setText("Victorias");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 460, -1, -1));

        txtRefuerzosUSM.setEditable(false);
        txtRefuerzosUSM.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtRefuerzosUSM.setText("Vacío");
        txtRefuerzosUSM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRefuerzosUSMActionPerformed(evt);
            }
        });
        jPanel2.add(txtRefuerzosUSM, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 410, 350, -1));

        txtP3USM.setEditable(false);
        txtP3USM.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtP3USM.setText("Vacío");
        jPanel2.add(txtP3USM, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 330, 350, -1));

        txtP2USM.setEditable(false);
        txtP2USM.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtP2USM.setText("Vacío");
        jPanel2.add(txtP2USM, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 250, 350, -1));

        txtP1USM.setEditable(false);
        txtP1USM.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtP1USM.setText("Vacío");
        jPanel2.add(txtP1USM, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 170, 350, -1));

        txtDecisionIA.setEditable(false);
        txtDecisionIA.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtDecisionIA.setText("Está Durmiendo");
        jPanel2.add(txtDecisionIA, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 120, 180, -1));

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("IA");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 100, 23, -1));

        btnStart.setText("Iniciar Combate");
        btnStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStartActionPerformed(evt);
            }
        });
        jPanel2.add(btnStart, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 720, -1, -1));

        jLabel8.setText("Ganadores");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 650, -1, -1));

        jLabel7.setText("Refuerzos");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 390, -1, -1));

        jLabel6.setText("Prioridad 3");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 310, -1, -1));

        jLabel5.setText("Prioridad 2");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 230, -1, -1));

        jLabel4.setText("Prioridad 1");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 140, -1, -1));

        infoAvatar.setEditable(false);
        jScrollPane1.setViewportView(infoAvatar);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(435, 354, 150, 130));

        infoUsm.setEditable(false);
        jScrollPane2.setViewportView(infoUsm);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 350, 150, 130));

        imgUSM.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout imgUSMLayout = new javax.swing.GroupLayout(imgUSM);
        imgUSM.setLayout(imgUSMLayout);
        imgUSMLayout.setHorizontalGroup(
            imgUSMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 148, Short.MAX_VALUE)
        );
        imgUSMLayout.setVerticalGroup(
            imgUSMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 164, Short.MAX_VALUE)
        );

        jPanel2.add(imgUSM, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 170, 150, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("VS");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 220, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setText("Un Show Más");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(989, 101, -1, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Avatar: La Leyenda de Aang");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(54, 98, -1, -1));

        imgAvatar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout imgAvatarLayout = new javax.swing.GroupLayout(imgAvatar);
        imgAvatar.setLayout(imgAvatarLayout);
        imgAvatarLayout.setHorizontalGroup(
            imgAvatarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 148, Short.MAX_VALUE)
        );
        imgAvatarLayout.setVerticalGroup(
            imgAvatarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 163, Short.MAX_VALUE)
        );

        jPanel2.add(imgAvatar, new org.netbeans.lib.awtextra.AbsoluteConstraints(435, 174, -1, -1));

        jScrollPane3.setViewportView(resultsPane);

        jPanel2.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 500, 240, 130));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 1307, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 754, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void sldDuracionStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sldDuracionStateChanged
        duracionCombate.setText(String.valueOf(getSldDuracion().getValue()));
    }//GEN-LAST:event_sldDuracionStateChanged

    private void txtRefuerzosUSMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRefuerzosUSMActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRefuerzosUSMActionPerformed

    private void btnStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStartActionPerformed
   
            while(true){
              
                sem.release();
                admin.start();
                
                admin.ai.start();
            }
            
    }//GEN-LAST:event_btnStartActionPerformed

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
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Dashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnStart;
    private javax.swing.JLabel duracionCombate;
    private javax.swing.JPanel imgAvatar;
    private javax.swing.JPanel imgUSM;
    private javax.swing.JTextPane infoAvatar;
    private javax.swing.JTextPane infoUsm;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextPane resultsPane;
    private javax.swing.JSlider sldDuracion;
    private javax.swing.JTextField txtDecisionIA;
    private javax.swing.JTextField txtGanadores;
    private javax.swing.JTextField txtP1Avatar;
    private javax.swing.JTextField txtP1USM;
    private javax.swing.JTextField txtP2Avatar;
    private javax.swing.JTextField txtP2USM;
    private javax.swing.JTextField txtP3Avatar;
    private javax.swing.JTextField txtP3USM;
    private javax.swing.JTextField txtRefuerzosAvatar;
    private javax.swing.JTextField txtRefuerzosUSM;
    private javax.swing.JTextField txtVictoriasAvatar;
    private javax.swing.JTextField txtVictoriasUSM;
    // End of variables declaration//GEN-END:variables
    
    class ImagePanel extends JPanel{
        private Image image;
        private final String path;
        
        public ImagePanel(String path){
            this.path = path;
        }
        
        @Override
        public void paint(Graphics g){
            image = new ImageIcon(getClass().getResource(path)).getImage();
            
            g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
            
            setOpaque(false);
            
            super.paint(g);
            
//            jPanel2 = new ImagePanel("/Images/Avatar_vs_USM.png");
        }
    }

    /**
     * @return the sldDuracion
     */
    public javax.swing.JSlider getSldDuracion() {
        return sldDuracion;
    }

    /**
     * @return the imgAvatar
     */
    public javax.swing.JPanel getImgAvatar() {
        return imgAvatar;
    }

    /**
     * @param imgAvatar the imgAvatar to set
     */
    public void setImgAvatar(javax.swing.JPanel imgAvatar) {
        this.imgAvatar = imgAvatar;
    }

    /**
     * @return the imgUSM
     */
    public javax.swing.JPanel getImgUSM() {
        return imgUSM;
    }

    /**
     * @param imgUSM the imgUSM to set
     */
    public void setImgUSM(javax.swing.JPanel imgUSM) {
        this.imgUSM = imgUSM;
    }

    /**
     * @return the txtVictoriasAvatar
     */
    public javax.swing.JTextField getTxtVictoriasAvatar() {
        return txtVictoriasAvatar;
    }

    /**
     * @param txtVictoriasAvatar the txtVictoriasAvatar to set
     */
    public void setTxtVictoriasAvatar(javax.swing.JTextField txtVictoriasAvatar) {
        this.txtVictoriasAvatar = txtVictoriasAvatar;
    }

    /**
     * @param txtVictoriasUSM the txtVictoriasUSM to set
     */
    public void setTxtVictoriasUSM(javax.swing.JTextField txtVictoriasUSM) {
        this.txtVictoriasUSM = txtVictoriasUSM;
    }

    /**
     * @param sldDuracion the sldDuracion to set
     */
    public void setSldDuracion(javax.swing.JSlider sldDuracion) {
        this.sldDuracion = sldDuracion;
    }

    /**
     * @return the resultsPane
     */
    public javax.swing.JTextPane getResultsPane() {
        return resultsPane;
    }

    /**
     * @param resultsPane the resultsPane to set
     */
    public void setResultsPane(javax.swing.JTextPane resultsPane) {
        this.resultsPane = resultsPane;
    }

    /**
     * @return the counter
     */
    public int getCounter() {
        return counter;
    }

    /**
     * @param counter the counter to set
     */
    public void setCounter(int counter) {
        this.counter = counter;
    }
    
    

}
