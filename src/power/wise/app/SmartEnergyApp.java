/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package power.wise.app;

import java.io.File;
import java.io.FileWriter;

/**
 *
 * @author apple
 */
public class SmartEnergyApp {

    public static void main(String[] args) {

        resetApplianceDataFile();

        java.awt.EventQueue.invokeLater(() -> {
            new PowerWiseGUI().setVisible(true);
        });
    }

    private static void resetApplianceDataFile() {
        try {
            File folder = new File("data");
            if (!folder.exists()) {
                folder.mkdir();
            }

            File f = new File(folder, "applianceList.txt");

            // overwrite file
            FileWriter fw = new FileWriter(f, false);
            fw.write("");  
            fw.close();

            System.out.println("Appliance data reset successfully.");

        } catch (Exception e) {
            System.out.println("Error resetting appliance data: " + e.getMessage());
        }
    }
}
