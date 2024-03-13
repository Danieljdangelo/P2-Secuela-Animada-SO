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
import static java.lang.Thread.sleep;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;

/**
 *
 * @author José
 */
public class Dashboard extends javax.swing.JFrame {

    /**
     * Creates new form Dashboard
     */
    
//    Semaphore mainMutex = new Semaphore(1);
    private Semaphore sem;
    private Admin admin;
    private AI ai;
    
    public Dashboard() {
        initComponents();
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.sem = new Semaphore(1);
        this.ai = new AI(sem, getSldDuracion().getValue(), this, admin);
        this.admin = new Admin(sem, 20, ai, getSldDuracion().getValue(), this);
    }
    
    public JTextPane getPanelAvatar(){
        return infoAvatar;
    }
    
    public JTextPane getPanelUsm(){
        return infoUsm;
    }
    
    public JTextField getVictoriasAvatarLabel(){
        return txtVictoriasAvatar;
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
        imgAvatar = new javax.swing.JPanel();
        imgUSM4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        duracionCombate.setText("10");

        txtVictoriasAvatar.setEditable(false);
        txtVictoriasAvatar.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtVictoriasAvatar.setText("0");

        jLabel16.setText("Victorias");

        txtRefuerzosAvatar.setEditable(false);
        txtRefuerzosAvatar.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtRefuerzosAvatar.setText("Vacío");

        jLabel15.setText("Refuerzos");

        txtP3Avatar.setEditable(false);
        txtP3Avatar.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtP3Avatar.setText("Vacío");

        jLabel14.setText("Prioridad 3");

        txtP2Avatar.setEditable(false);
        txtP2Avatar.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtP2Avatar.setText("Vacío");

        jLabel13.setText("Prioridad 2");

        txtP1Avatar.setEditable(false);
        txtP1Avatar.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtP1Avatar.setText("Vacío");

        jLabel12.setText("Prioridad 1");

        jLabel11.setText("Duración Combate:");

        sldDuracion.setMajorTickSpacing(1);
        sldDuracion.setMaximum(20);
        sldDuracion.setPaintLabels(true);
        sldDuracion.setPaintTicks(true);
        sldDuracion.setSnapToTicks(true);
        sldDuracion.setValue(10);
        sldDuracion.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sldDuracionStateChanged(evt);
            }
        });

        txtGanadores.setEditable(false);
        txtGanadores.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtGanadores.setText("Vacío");

        txtVictoriasUSM.setEditable(false);
        txtVictoriasUSM.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtVictoriasUSM.setText("0");

        jLabel10.setText("Victorias");

        txtRefuerzosUSM.setEditable(false);
        txtRefuerzosUSM.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtRefuerzosUSM.setText("Vacío");
        txtRefuerzosUSM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRefuerzosUSMActionPerformed(evt);
            }
        });

        txtP3USM.setEditable(false);
        txtP3USM.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtP3USM.setText("Vacío");

        txtP2USM.setEditable(false);
        txtP2USM.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtP2USM.setText("Vacío");

        txtP1USM.setEditable(false);
        txtP1USM.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtP1USM.setText("Vacío");

        txtDecisionIA.setEditable(false);
        txtDecisionIA.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtDecisionIA.setText("Está Durmiendo");

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("IA");

        btnStart.setText("Iniciar Combate");
        btnStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStartActionPerformed(evt);
            }
        });

        jLabel8.setText("Ganadores");

        jLabel7.setText("Refuerzos");

        jLabel6.setText("Prioridad 3");

        jLabel5.setText("Prioridad 2");

        jLabel4.setText("Prioridad 1");

        infoAvatar.setEditable(false);
        jScrollPane1.setViewportView(infoAvatar);

        infoUsm.setEditable(false);
        jScrollPane2.setViewportView(infoUsm);

        imgAvatar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout imgAvatarLayout = new javax.swing.GroupLayout(imgAvatar);
        imgAvatar.setLayout(imgAvatarLayout);
        imgAvatarLayout.setHorizontalGroup(
            imgAvatarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        imgAvatarLayout.setVerticalGroup(
            imgAvatarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 150, Short.MAX_VALUE)
        );

        imgUSM4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout imgUSM4Layout = new javax.swing.GroupLayout(imgUSM4);
        imgUSM4.setLayout(imgUSM4Layout);
        imgUSM4Layout.setHorizontalGroup(
            imgUSM4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 148, Short.MAX_VALUE)
        );
        imgUSM4Layout.setVerticalGroup(
            imgUSM4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 150, Short.MAX_VALUE)
        );

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("VS");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setText("Un Show Más");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Avatar: La Leyenda de Aang");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(419, 419, 419)
                        .addComponent(txtGanadores, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(541, 541, 541)
                        .addComponent(btnStart)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel13)
                    .addComponent(jLabel12)
                    .addComponent(jLabel14)
                    .addComponent(jLabel15))
                .addGap(766, 766, 766)
                .addComponent(jLabel4)
                .addContainerGap(319, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(181, 181, 181)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addGap(187, 187, 187))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(173, 173, 173)
                .addComponent(txtVictoriasAvatar, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtVictoriasUSM, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(179, 179, 179))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtDecisionIA, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(154, 154, 154)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtP1USM, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
                                .addComponent(txtP2USM)
                                .addComponent(txtP3USM)
                                .addComponent(txtRefuerzosUSM))
                            .addComponent(jLabel6)
                            .addComponent(jLabel5))
                        .addGap(37, 37, 37))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addGap(136, 136, 136))))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(35, 35, 35)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtP2Avatar, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtP1Avatar, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtRefuerzosAvatar, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                            .addGap(199, 199, 199)
                                            .addComponent(jLabel8))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                            .addGap(50, 50, 50)
                                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel2Layout.createSequentialGroup()
                                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(imgAvatar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGap(18, 18, 18)
                                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jLabel3))
                                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                            .addGap(18, 18, 18)
                                                            .addComponent(imgUSM4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                            .addGap(18, 18, 18)
                                                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE))))
                                                .addComponent(sldDuracion, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addComponent(txtP3Avatar, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(54, 54, 54)
                            .addComponent(jLabel1))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(546, 546, 546)
                            .addComponent(jLabel11)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(duracionCombate, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(464, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(117, 117, 117)
                        .addComponent(txtDecisionIA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jLabel4))
                .addGap(13, 13, 13)
                .addComponent(txtP1USM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel13))
                .addGap(18, 18, 18)
                .addComponent(txtP2USM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel14))
                .addGap(18, 18, 18)
                .addComponent(txtP3USM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel15))
                .addGap(18, 18, 18)
                .addComponent(txtRefuerzosUSM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel10))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtVictoriasUSM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtVictoriasAvatar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addComponent(txtGanadores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnStart)
                .addGap(13, 13, 13))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(duracionCombate))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(sldDuracion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel9)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGap(107, 107, 107)
                                    .addComponent(jLabel3))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGap(56, 56, 56)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(imgUSM4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(imgAvatar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addGap(46, 46, 46)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGap(72, 72, 72)
                                    .addComponent(txtP2Avatar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(52, 52, 52)
                                    .addComponent(txtP3Avatar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(txtP1Avatar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(54, 54, 54)
                            .addComponent(txtRefuerzosAvatar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGap(18, 18, 18)
                    .addComponent(jLabel8)
                    .addContainerGap(104, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
//        sem = new Semaphore(1);
//        
//        ai = new AI(sem, getSldDuracion().getValue(), this, admin);
//        admin = new Admin(sem, 20, ai, getSldDuracion().getValue(), this);
//        
//        try{
//            
//             
            while(true){
//                sem.acquire();
//                ai.setStatus("Decidiendo");
//                txtDecisionIA.setText(ai.getStatus());
////                sleep(2000);
//                sem.release();
//                
//                ai.start();
//                
//                sem.acquire();
//                ai.setStatus("Anunciando");
//                txtDecisionIA.setText(ai.getStatus());
////                sleep(2000);
//                sem.release();
//                
                admin.start();
                ai.start();
//                sem.acquire();
//                ai.setStatus("Esperando");
//                txtDecisionIA.setText(ai.getStatus());
////                sleep(2000);
//                sem.release();
                
//                sem.acquire();
//                txtP1Avatar.setText(admin.getP1Avatar().print());
//                txtP2Avatar.setText(admin.getP2Avatar().print());
//                txtP3Avatar.setText(admin.getP3Avatar().print());
//                txtRefuerzosAvatar.setText(admin.getRefuerzoAvatar().print());
//                txtP1USM.setText(admin.getP1USM().print());
//                txtP2USM.setText(admin.getP2USM().print());
//                txtP3USM.setText(admin.getP3USM().print());
//                txtRefuerzosUSM.setText(admin.getRefuerzoUSM().print());
//                txtGanadores.setText(admin.getWinners().print());
//                txtVictoriasAvatar.setText(Integer.toString(admin.getAvatarWinners()));
//                txtVictoriasUSM.setText(Integer.toString(admin.getUsmWinners()));
//                
//                sem.release();
            }
            
//        }catch (InterruptedException ex) {
//            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
//        }
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
    private javax.swing.JPanel imgUSM4;
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
        }
    }

    /**
     * @return the sldDuracion
     */
    public javax.swing.JSlider getSldDuracion() {
        return sldDuracion;
    }

}
