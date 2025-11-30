/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Brian;

/**
 *
 * @author apple
 */
public class AddTipForm extends javax.swing.JFrame {

    private TipManager manager;

    public AddTipForm() {
        manager = new TipManager();  // Load existing tips
        initComponents();
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtDescription = new javax.swing.JTextField();
        chkAdopted = new javax.swing.JCheckBox();
        btnSave = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Tip Description:");

        chkAdopted.setText("Already Adopted");

        btnSave.setText("Save");
        btnSave.addActionListener(evt -> saveTip());

        btnCancel.setText("Cancel");
        btnCancel.addActionListener(evt -> {
            new TipsDashboardForm().setVisible(true);
            this.dispose();
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);

        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(txtDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chkAdopted)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnSave)
                        .addGap(20, 20, 20)
                        .addComponent(btnCancel)))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(chkAdopted)
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSave)
                    .addComponent(btnCancel))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pack();
    }

    private void saveTip() {
        String description = txtDescription.getText().trim();

        if (description.isEmpty()) {
            return;
        }

        Tip tip = new Tip(description, chkAdopted.isSelected());
        manager.addTip(tip);
        manager.saveTips();

        new TipsDashboardForm().setVisible(true);
        this.dispose();
    }

    // Variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnSave;
    private
