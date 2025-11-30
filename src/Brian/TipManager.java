/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Brian;

import java.io.*;
import java.util.ArrayList;

/**
 *
 * @author apple
 */
public class TipManager {

    private static final String FILE_NAME = "tips.txt";
    private ArrayList<Tip> tips = new ArrayList<>();

    public TipManager() {
        loadTips();
    }

    public ArrayList<Tip> getTips() {
        return tips;
    }

    public void addTip(Tip tip) {
        tips.add(tip);
        saveTips();
    }

    public void removeTip(Tip tip) {
        tips.remove(tip);
        saveTips();
    }

    public void markTipAsAdopted(int index) {
        if (index >= 0 && index < tips.size()) {
            Tip t = tips.get(index);
            t.setAdopted(true);
            saveTips();
        }
    }

    // -------------------------------
    // LOAD TIPS FROM FILE
    // -------------------------------
    public void loadTips() {
        tips.clear();

        File file = new File(FILE_NAME);
        if (!file.exists()) return;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {

            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(";;");
                if (parts.length == 2) {
                    String desc = parts[0];
                    boolean adopted = Boolean.parseBoolean(parts[1]);
                    tips.add(new Tip(desc, adopted));
                }
            }

        } catch (IOException e) {
            System.out.println("Error loading tips: " + e.getMessage());
        }
    }

    // -------------------------------
    // SAVE TIPS TO FILE
    // -------------------------------
    public void saveTips() {

        try (PrintWriter pw = new PrintWriter(new FileWriter(FILE_NAME))) {

            for (Tip t : tips) {
                pw.println(t.getDescription() + ";;" + t.isAdopted());
            }

        } catch (IOException e) {
            System.out.println("Error saving tips: " + e.getMessage());
        }
    }
}
