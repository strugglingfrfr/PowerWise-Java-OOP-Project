/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Brian;

import power.wise.app.PowerWiseGUI;

/**
 *
 * @author apple
 */
public class TipGUI extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(TipGUI.class.getName());

    /**
     * Creates new form TipGUI
     */
    public TipGUI() {
        initComponents();
        setLocationRelativeTo(null); // center window
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        headerPanel = new javax.swing.JPanel();
        headingLabel = new javax.swing.JLabel();
        mainPanel = new javax.swing.JPanel();
        btnMainMenu = new javax.swing.JButton();
        btnDashboard = new javax.swing.JButton();
        btnAddTip = new javax.swing.JButton();   // NEW BUTTON ✔✔✔

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        // Header
        headerPanel.setBackground(new java.awt.Color(26, 101, 26));
        headingLabel.setFont(new java.awt.Font("Futura", 0, 22));
        headingLabel.setForeground(new java.awt.Color(255, 255, 255));
        headingLabel.setText("Tips Dashboard");

        javax.swing.GroupLayout headerPanelLayout = new javax.swing.GroupLayout(headerPanel);
        headerPanel.setLayout(headerPanelLayout);
        headerPanelLayout.setHorizontalGroup(
            headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(headerPanelLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(headingLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        headerPanelLayout.setVerticalGroup(
            headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(headingLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        // Main Panel
        mainPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        // Main Menu Button
        btnMainMenu.setBackground(new java.awt.Color(26, 101, 26));
        btnMainMenu.setFont(new java.awt.Font("Helvetica Neue", 0, 15));
        btnMainMenu.setForeground(new java.awt.Color(242, 242, 242));
        btnMainMenu.setText("Main Menu");
        btnMainMenu.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        btnMainMenu.addActionListener(evt -> {
            new PowerWiseGUI().setVisible(true);
            this.dispose();
        });
        mainPanel.add(btnMainMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 240, 170, 70));

        // Dashboard Button
        btnDashboard.setBackground(new java.awt.Color(26, 101, 26));
        btnDashboard.setFont(new java.awt.Font("Helvetica Neue", 0, 15));
        btnDashboard.setForeground(new java.awt.Color(242, 242, 242));
        btnDashboard.setText("Tip Dashboard");
        btnDashboard.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        btnDashboard.addActionListener(evt -> {
            new TipDashboardForm().setVisible(true);
            this.dispose();
        });
        mainPanel.add(btnDashboard, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 120, 170, 70));

        // NEW Add Tip Button ✔✔✔
        btnAddTip.setBackground(new java.awt.Color(26, 101, 26));
        btnAddTip.setFont(new java.awt.Font("Helvetica Neue", 0, 15));
        btnAddTip.setForeground(new java.awt.Color(242, 242, 242));
        btnAddTip.setText("Add New Tip");
        btnAddTip.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        btnAddTip.addActionListener(evt -> {
            new AddTipForm().setVisible(true);
            this.dispose();
        });
        mainPanel.add(btnAddTip, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 180, 170, 60));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(headerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(headerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new TipGUI().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel headerPanel;
    private javax.swing.JLabel headingLabel;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JButton btnMainMenu;
    private javax.swing.JButton btnDashboard;
    private javax.swing.JButton btnAddTip;   // ✔ ADDED
    // End of variables declaration//GEN-END:variables
}
