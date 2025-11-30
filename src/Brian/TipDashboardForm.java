/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Brian;

import java.util.ArrayList;
import javax.swing.DefaultListModel;

/**
 *
 * @author apple
 */
public class TipsDashboardForm extends javax.swing.JFrame {

    private DefaultListModel<String> model = new DefaultListModel<>();
    private TipManager manager;

    public TipsDashboardForm() {
        manager = new TipManager();  // Load saved tips
        initComponents();
        setLocationRelativeTo(null);
        loadTips();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        lstTips = new javax.swing.JList<>();
        btnAddTip = new javax.swing.JButton();
        btnAdopt = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        headerLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        headerLabel.setFont(new java.awt.Font("Futura", 0, 22));
        headerLabel.setText("Tips Dashboard");

        lstTips.setFont(new java.awt.Font("Helvetica Neue", 0, 14));
        jScrollPane1.setViewportView(lstTips);

        btnAddTip.setText("Add New Tip");
        btnAddTip.addActionListener(evt -> {
            new AddTipForm().setVisible(true);
            this.dispose();
        });

        btnAdopt.setText("Mark as Adopted");
        btnAdopt.addActionListener(evt -> adoptSelectedTip());

        btnBack.setText("Back");
        btnBack.addActionListener(evt -> {
            new TipGUI().setVisible(true);
            this.dispose();
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);

        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(headerLabel)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAddTip)
                        .addGap(18, 18, 18)
                        .addComponent(btnAdopt)
                        .addGap(18, 18, 18)
                        .addComponent(btnBack)))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(headerLabel)
                .addGap(15, 15, 15)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddTip)
                    .addComponent(btnAdopt)
                    .addComponent(btnBack))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }

    private void loadTips() {
        model.clear();
        ArrayList<Tip> tips = manager.getTips();

        for (Tip t : tips) {
            String adoptedMark = t.isAdopted() ? " (Adopted)" : "";
            model.addElement(t.getDescription() + adoptedMark);
        }

        lstTips.setModel(model);
    }

    private void adoptSelectedTip() {
        int index = lstTips.getSelectedIndex();
        if (index == -1) return;

        Tip tip = manager.getTips().get(index);
        tip.setAdopted(true);

        manager.saveTips();
        loadTips();
    }

    // Variables
    private javax.swing.JButton btnAddTip;
    private javax.swing.JButton btnAdopt;
    private javax.swing.JButton btnBack;
    private javax.swing.JLabel headerLabel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<String> lstTips;
}
