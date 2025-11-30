/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Brian;

import javax.swing.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class AddTipForm extends javax.swing.JFrame {

    public AddTipForm() {
        initComponents();
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
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

        /* Header panel */
        headerPL.setBackground(new java.awt.Color(26, 101, 26));

        titleLBL.setFont(new java.awt.Font("Helvetica Neue", 0, 24));
        titleLBL.setForeground(new java.awt.Color(255, 255, 255));
        titleLBL.setText("Power Wise - Add Tip Form");

        javax.swing.GroupLayout headerPLLayout = new javax.swing.GroupLayout(headerPL);
        headerPL.setLayout(headerPLLayout);
        headerPLLayout.setHorizontalGroup(
            headerPLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(headerPLLayout.createSequentialGroup()
                    .addGap(30, 30, 30)
                    .addComponent(titleLBL)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        headerPLLayout.setVerticalGroup(
            headerPLLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(headerPLLayout.createSequentialGroup()
                    .addGap(15, 15, 15)
                    .addComponent(titleLBL)
                    .addContainerGap(20, Short.MAX_VALUE))
        );

        /* Main panel */
        mainPL.setBackground(new java.awt.Color(204, 255, 204));
        mainPL.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tipLBL.setFont(new java.awt.Font("Arial", 0, 14));
        tipLBL.setText("Tip Description:");
        mainPL.add(tipLBL, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, -1, -1));

        tipTA.setColumns(20);
        tipTA.setRows(5);
        tipTA.setFont(new java.awt.Font("Arial", 0, 14));
        scrollPane.setViewportView(tipTA);
        mainPL.add(scrollPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 40, 240, 100));

        adoptedCB.setFont(new java.awt.Font("Arial", 0, 14));
        adoptedCB.setText("Adopted");
        mainPL.add(adoptedCB, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 150, -1, -1));

        saveButton.setBackground(new java.awt.Color(34, 139, 34));
        saveButton.setForeground(new java.awt.Color(255, 255, 255));
        saveButton.setFont(new java.awt.Font("Arial", 0, 14));
        saveButton.setText("Save");

        // 🔗 Add Action
        saveButton.addActionListener(evt -> saveButtonActionPerformed(evt));

        mainPL.add(saveButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 250, -1, -1));

        cancelButton.setBackground(new java.awt.Color(34, 139, 34));
        cancelButton.setForeground(new java.awt.Color(255, 255, 255));
        cancelButton.setFont(new java.awt.Font("Arial", 0, 14));
        cancelButton.setText("Cancel");

        // 🔗 Add Action
        cancelButton.addActionListener(evt -> cancelButtonActionPerformed(evt));

        mainPL.add(cancelButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 250, -1, -1));

        /* Window layout */
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(headerPL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(mainPL, javax.swing.GroupLayout.PREFERRED_SIZE, 488, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
    }

    // ------------------------ BUTTON ACTIONS ------------------------

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {
        String tip = tipTA.getText();
        boolean adopted = adoptedCB.isSelected();

        if (tip.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter a tip first.");
            return;
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("tips.txt", true))) {
            bw.write("Tip: " + tip);
            bw.newLine();
            bw.write("Adopted: " + adopted);
            bw.newLine();
            bw.write("-------------------------");
            bw.newLine();

            JOptionPane.showMessageDialog(this, "Tip saved successfully!");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error writing tip: " + e.getMessage());
        }
    }

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {
        this.dispose(); // Close window
    }

    // Variables
    private javax.swing.JPanel headerPL;
    private javax.swing.JLabel titleLBL;
    private javax.swing.JPanel mainPL;
    private javax.swing.JLabel tipLBL;
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JTextArea tipTA;
    private javax.swing.JCheckBox adoptedCB;
    private javax.swing.JButton saveButton;
    private javax.swing.JButton cancelButton;

}
