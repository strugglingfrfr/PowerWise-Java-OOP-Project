/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Brian;

import javax.swing.*;

/**
 * Add Tip Form
 * @author apple
 */
public class AddTipForm extends javax.swing.JFrame {

    private TipManager manager;

    public AddTipForm() {
        initComponents();
        setLocationRelativeTo(null); // center window
        manager = new TipManager();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        jPanel1 = new javax.swing.JPanel();
        headerLabel = new javax.swing.JLabel();
        tipLabel = new javax.swing.JLabel();
        tipScrollPane = new javax.swing.JScrollPane();
        tipTextArea = new javax.swing.JTextArea();
        adoptedCheckBox = new javax.swing.JCheckBox();
        saveButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Add Tip");

        jPanel1.setBackground(new java.awt.Color(245, 255, 245));

        headerLabel.setFont(new java.awt.Font("Arial", 1, 18));
        headerLabel.setForeground(new java.awt.Color(34, 139, 34));
        headerLabel.setHorizontalAlignment(SwingConstants.CENTER);
        headerLabel.setText("Add Tip");

        tipLabel.setFont(new java.awt.Font("Arial", 0, 14));
        tipLabel.setText("Tip Description:");

        tipTextArea.setFont(new java.awt.Font("Arial", 0, 14));
        tipTextArea.setLineWrap(true);
        tipTextArea.setWrapStyleWord(true);
        tipScrollPane.setViewportView(tipTextArea);

        adoptedCheckBox.setFont(new java.awt.Font("Arial", 0, 14));
        adoptedCheckBox.setText("Adopted");

        saveButton.setText("Save");
        saveButton.addActionListener(evt -> saveTip());

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(evt -> {
            // return to dashboard (open it)
            new TipDashboardForm().setVisible(true);
            this.dispose();
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(headerLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE)
                    .addComponent(tipLabel)
                    .addComponent(tipScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE)
                    .addComponent(adoptedCheckBox)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(saveButton)
                        .addGap(20)
                        .addComponent(cancelButton)))
                .addGap(30))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25)
                .addComponent(headerLabel)
                .addGap(15)
                .addComponent(tipLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tipScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15)
                .addComponent(adoptedCheckBox)
                .addGap(25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveButton)
                    .addComponent(cancelButton))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }

    private void saveTip() {
        String description = tipTextArea.getText().trim();
        if (description.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter a tip description.", "Validation", JOptionPane.WARNING_MESSAGE);
            return;
        }

        Tip t = new Tip(description, adoptedCheckBox.isSelected());
        manager.addTip(t);
        manager.saveTips();

        // Return to dashboard and refresh
        TipDashboardForm dash = new TipDashboardForm();
        dash.setVisible(true);
        this.dispose();
    }

    // Variables
    private javax.swing.JCheckBox adoptedCheckBox;
    private javax.swing.JButton cancelButton;
    private javax.swing.JLabel headerLabel;
    private javax.swing.JButton saveButton;
    private javax.swing.JLabel tipLabel;
    private javax.swing.JScrollPane tipScrollPane;
    private javax.swing.JTextArea tipTextArea;
    private javax.swing.JPanel jPanel1;
}
