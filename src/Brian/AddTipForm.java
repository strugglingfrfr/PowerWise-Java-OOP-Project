/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Brian;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author apple
 */
public class AddTipForm extends javax.swing.JFrame {

    String tipDescription;
    boolean adopted;

    /**
     * Creates new form AddTipForm
     */
    public AddTipForm() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        headerPL = new javax.swing.JPanel();
        titleLBL = new javax.swing.JLabel();
        mainPL = new javax.swing.JPanel();
        tipLBL = new javax.swing.JLabel();
        scrollPane = new javax.swing.JScrollPane();
        tipTA = new javax.swing.JTextArea();
        adoptedCB = new javax.swing.JCheckBox();
        saveButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Add Tip");

        headerPL.setBackground(new java.awt.Color(26, 101, 26));

        titleLBL.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        titleLBL.setForeground(new java.awt.Color(255, 255, 255));
        titleLBL.setText("Power Wise - Add Tip Form");

        javax.swing.GroupLayout headerPLLayout = new javax.swing.GroupLayout(headerPL);
        headerPL.setLayout(headerPLLayout);
        headerPLLayout.setHorizontalGroup(
            headerPLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerPLLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(titleLBL)
                .addContainerGap(200, Short.MAX_VALUE))
        );
        headerPLLayout.setVerticalGroup(
            headerPLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerPLLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(titleLBL)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        mainPL.setBackground(new java.awt.Color(204, 255, 204));
        mainPL.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tipLBL.setFont(new java.awt.Font("Arial", 0, 14)); 
        tipLBL.setText("Tip Description:");
        mainPL.add(tipLBL, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, -1, -1));

        tipTA.setColumns(20);
        tipTA.setFont(new java.awt.Font("Arial", 0, 14)); 
        tipTA.setRows(5);
        scrollPane.setViewportView(tipTA);

        mainPL.add(scrollPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 40, 240, 100));

        adoptedCB.setFont(new java.awt.Font("Arial", 0, 14)); 
        adoptedCB.setText("Adopted");
        mainPL.add(adoptedCB, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 150, -1, -1));

        saveButton.setBackground(new java.awt.Color(34, 139, 34));
        saveButton.setForeground(new java.awt.Color(255, 255, 255));
        saveButton.setFont(new java.awt.Font("Arial", 0, 14)); 
        saveButton.setText("Save");
        saveButton.addActionListener(this::saveButtonActionPerformed);
        mainPL.add(saveButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 250, -1, -1));

        cancelButton.setBackground(new java.awt.Color(34, 139, 34));
        cancelButton.setForeground(new java.awt.Color(255, 255, 255));
        cancelButton.setFont(new java.awt.Font("Arial", 0, 14)); 
        cancelButton.setText("Cancel");
        cancelButton.addActionListener(this::cancelButtonActionPerformed);
        mainPL.add(cancelButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 250, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(headerPL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(mainPL, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(headerPL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mainPL, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        
        tipDescription = tipTA.getText();
        adopted = adoptedCB.isSelected();

        try {
            File f = new File("tipsList.txt");
            BufferedWriter bw = new BufferedWriter(new FileWriter(f, true));

            bw.write("Tip Description: " + tipDescription);
            bw.newLine();
            bw.write("Adopted: " + adopted);
            bw.newLine();
            bw.newLine();
            bw.close();

            JOptionPane.showMessageDialog(this, "Tip saved successfully!");
        } 
        catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error writing to file: " + e.getMessage());
        }

    }//GEN-LAST:event_saveButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        new TipDashboardForm().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new AddTipForm().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox adoptedCB;
    private javax.swing.JButton cancelButton;
    private javax.swing.JPanel headerPL;
    private javax.swing.JPanel mainPL;
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JButton saveButton;
    private javax.swing.JLabel tipLBL;
    private javax.swing.JTextArea tipTA;
    private javax.swing.JLabel titleLBL;
    // End of variables declaration//GEN-END:variables
}
