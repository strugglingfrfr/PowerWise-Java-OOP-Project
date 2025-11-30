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
public class TipDashboardForm extends javax.swing.JFrame {

    private TipManager manager = new TipManager();

    /**
     * Creates new form TipDashboardForm
     */
    public TipDashboardForm() {
        initComponents();
        setLocationRelativeTo(null);
        loadTipsIntoTextArea();
        addListeners();
    }

    private void loadTipsIntoTextArea() {
        tipsTextArea.setText(""); // clear
        for (int i = 0; i < manager.getTips().size(); i++) {
            Tip t = manager.getTips().get(i);
            tipsTextArea.append((i + 1) + ". " + t.getDescription() + " (Adopted: " + t.isAdopted() + ")\n");
        }
    }

    private void addListeners() {

        addTipButton.addActionListener(e -> {
            new AddTipForm().setVisible(true);
            this.dispose();
        });

        backButton.addActionListener(e -> {
            new TipGUI().setVisible(true);
            this.dispose();
        });

        markAdoptedButton.addActionListener(e -> {
            String input = JOptionPane.showInputDialog(this, "Enter tip number to mark adopted:");
            try {
                int index = Integer.parseInt(input) - 1;
                manager.markTipAsAdopted(index);
                loadTipsIntoTextArea();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Invalid number.");
            }
        });
    }

    // ---------------- AUTO-GENERATED NETBEANS CODE BELOW ----------------
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new JPanel();
        headerLabel = new JLabel();
        jScrollPane1 = new JScrollPane();
        tipsTextArea = new JTextArea();
        markAdoptedButton = new JButton();
        addTipButton = new JButton();
        backButton = new JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new Color(245, 255, 245));

        headerLabel.setFont(new Font("Arial", Font.BOLD, 18));
        headerLabel.setForeground(new Color(34, 139, 34));
        headerLabel.setHorizontalAlignment(SwingConstants.CENTER);
        headerLabel.setText("Tips Dashboard");

        tipsTextArea.setEditable(false);
        tipsTextArea.setBackground(new Color(240, 255, 240));
        tipsTextArea.setColumns(20);
        tipsTextArea.setRows(5);
        tipsTextArea.setFont(new Font("Arial", Font.PLAIN, 14));
        tipsTextArea.setLineWrap(true);
        tipsTextArea.setWrapStyleWord(true);
        jScrollPane1.setViewportView(tipsTextArea);

        markAdoptedButton.setText("Mark as Adopted");
        styleButton(markAdoptedButton);

        addTipButton.setText("Add New Tip");
        styleButton(addTipButton);

        backButton.setText("Back to Menu");
        styleButton(backButton);

        // Layout code unchanged…
        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 460, Short.MAX_VALUE)
                .addGap(20, 20, 20))
            .addComponent(headerLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(markAdoptedButton, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(addTipButton, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(backButton, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(60, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(headerLabel)
                .addGap(15, 15, 15)
                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(markAdoptedButton, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                    .addComponent(addTipButton, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                    .addComponent(backButton, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
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
    private JButton addTipButton;
    private JButton backButton;
    private JLabel headerLabel;
    private JScrollPane jScrollPane1;
    private JPanel jPanel1;
    private JButton markAdoptedButton;
    private JTextArea tipsTextArea;
    // End of variables declaration//GEN-END:variables
}
