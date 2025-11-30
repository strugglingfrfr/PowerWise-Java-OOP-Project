/*
 * TipManager.java
 * Handles saving and loading Green Tips from a file.
 */
package Brian;

import java.io.*;
import java.util.ArrayList;

/**
 * @author apple
 */
public class TipManager {

    private ArrayList<Tip> tips = new ArrayList<>();
    private final String FILE_NAME = "tips.txt";

    public TipManager() {
        loadTips();
    }

    public ArrayList<Tip> getTips() {
        return tips;
    }

    public void addTip(Tip tip) {
        tips.add(tip);
    }

    public void removeTip(int index) {
        if (index >= 0 && index < tips.size()) {
            tips.remove(index);
        }
    }

    public void saveTips() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME))) {

            for (Tip t : tips) {
                bw.write(t.getDescription() + ";" + t.isAdopted());
                bw.newLine();
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void loadTips() {
        tips.clear();

        File f = new File(FILE_NAME);
        if (!f.exists()) return;

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {

            String line;
            while ((line = br.readLine()) != null) {

                String[] parts = line.split(";");
                if (parts.length == 2) {
                    tips.add(new Tip(parts[0], Boolean.parseBoolean(parts[1])));
                }
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
