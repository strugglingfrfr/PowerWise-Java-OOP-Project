/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Brian;

import java.awt.Color;
import java.awt.Font;
import javax.swing.*;

/**
 *
 * @author apple
 */
public class AddTipForm extends javax.swing.JFrame {

    private TipManager manager = new TipManager();

    /**
     * Creates new form AddTipForm
     */
    public AddTipForm() {
        initComponents();
        setLocationRelativeTo(null);
        addListeners();
    }

    private void addListeners() {

        saveButton.addActionListener(e -> {
            String desc = tipTextArea.getText().trim();
            boolean adopted = adoptedCheckBox.isSelected();

            if (desc.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter a tip.");
                return;
            }

            manager.addTip(new Tip(desc, adopted));
            JOptionPane.showMessageDialog(this, "Tip saved!");

            new TipDashboardForm().setVisible(true);
            this.dispose();
        });

        cancelButton.addActionListener(e -> {
            new TipDashboardForm().setVisible(true);
            this.dispose();
        });
    }

    // -------------------- AUTO-GENERATED NETBEANS CODE --------------------
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new JPanel();
        headerLabel = new JLabel();
        tipLabel = new JLabel();
        tipTextArea = new JTextArea();
        tipScrollPane = new JScrollPane();
        adoptedCheckBox = new JCheckBox();
        saveButton = new JButton();
        cancelButton = new JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new Color(245, 255, 245));

        headerLabel.setFont(new Font("Arial", Font.BOLD, 18));
        headerLabel.setForeground(new Color(34, 139, 34));
        headerLabel.setHorizontalAlignment(SwingConstants.CENTER);
        headerLabel.setText("Add Tip");

        tipLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        tipLabel.setText("Tip Description:");

        tipTextArea.setFont(new Font("Arial", Font.PLAIN, 14));
        tipTextArea.setLineWrap(true);
        tipTextArea.setWrapStyleWord(true);
        tipScrollPane.setViewportView(tipTextArea);

        adoptedCheckBox.setFont(new Font("Arial", Font.PLAIN, 14));
        adoptedCheckBox.setText("Adopted");

        saveButton.setText("Save");
        cancelButton.setText("Cancel");
        styleButton(saveButton);
        styleButton(cancelButton);

        // Layout remains exactly the same…
        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(headerLabel, GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(tipLabel)
                    .addComponent(tipScrollPane, GroupLayout.PREFERRED_SIZE, 360, GroupLayout.PREFERRED_SIZE)
                    .addComponent(adoptedCheckBox))
                .addContainerGap(20, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(saveButton, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(cancelButton, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(headerLabel)
                .addGap(15, 15, 15)
                .addComponent(tipLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tipScrollPane, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(adoptedCheckBox)
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(saveButton, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancelButton, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void styleButton(JButton button) {
        button.setFont(new Font("Arial", Font.PLAIN, 14));
        button.setBackground(new Color(34, 139, 34));
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createLineBorder(new Color(0, 100, 0)));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JCheckBox adoptedCheckBox;
    private JButton cancelButton;
    private JLabel headerLabel;
    private JLabel tipLabel;
    private JScrollPane tipScrollPane;
    private JTextArea tipTextArea;
    private JButton saveButton;
    private JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
