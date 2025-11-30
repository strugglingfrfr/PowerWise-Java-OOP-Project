/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Brian;

import javax.swing.*;
import java.util.ArrayList;

/**
 * Tips Dashboard — lists tips and allows marking as adopted
 * @author apple
 */
public class TipDashboardForm extends javax.swing.JFrame {

    private DefaultListModel<String> model = new DefaultListModel<>();
    private TipManager manager;

    public TipDashboardForm() {
        initComponents();
        setLocationRelativeTo(null); // center the window
        manager = new TipManager();
        loadTips();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        jPanel1 = new javax.swing.JPanel();
        headerLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstTips = new javax.swing.JList<>();
        markAdoptedButton = new javax.swing.JButton();
        addTipButton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Tips Dashboard");

        jPanel1.setBackground(new java.awt.Color(245, 255, 245));

        headerLabel.setFont(new java.awt.Font("Arial", 1, 18));
        headerLabel.setForeground(new java.awt.Color(34, 139, 34));
        headerLabel.setHorizontalAlignment(SwingConstants.CENTER);
        headerLabel.setText("Tips Dashboard");

        lstTips.setModel(model);
        lstTips.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        lstTips.setFont(new java.awt.Font("Arial", 0, 14));
        jScrollPane1.setViewportView(lstTips);

        markAdoptedButton.setText("Mark as Adopted");
        markAdoptedButton.addActionListener(evt -> adoptSelectedTip());
        styleButton(markAdoptedButton);

        addTipButton.setText("Add New Tip");
        addTipButton.addActionListener(evt -> {
            new AddTipForm().setVisible(true);
            this.dispose();
        });
        styleButton(addTipButton);

        backButton.setText("Back to Menu");
        backButton.addActionListener(evt -> {
            new TipGUI().setVisible(true);
            this.dispose();
        });
        styleButton(backButton);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(headerLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(60)
                .addComponent(markAdoptedButton, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30)
                .addComponent(addTipButton, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30)
                .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(60, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15)
                .addComponent(headerLabel)
                .addGap(15)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(markAdoptedButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addTipButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
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

    private void styleButton(JButton button) {
        button.setFont(new java.awt.Font("Arial", 0, 14));
        button.setBackground(new java.awt.Color(34, 139, 34));
        button.setForeground(java.awt.Color.WHITE);
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createLineBorder(new java.awt.Color(0, 100, 0)));
    }

    private void loadTips() {
        model.clear();
        manager.loadTips(); // ensure latest
        ArrayList<Tip> tips = manager.getTips();
        for (Tip t : tips) {
            model.addElement(t.toString());
        }
    }

    private void adoptSelectedTip() {
        int idx = lstTips.getSelectedIndex();
        if (idx == -1) {
            JOptionPane.showMessageDialog(this, "Please select a tip to mark adopted.", "No selection", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        Tip t = manager.getTips().get(idx);
        t.setAdopted(true);
        manager.saveTips();
        loadTips();
    }

    // Variables
    private javax.swing.JButton addTipButton;
    private javax.swing.JButton backButton;
    private javax.swing.JLabel headerLabel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton markAdoptedButton;
    private javax.swing.JList<String> lstTips;
}
