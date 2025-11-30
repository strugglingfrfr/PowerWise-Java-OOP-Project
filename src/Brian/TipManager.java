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

    private final ArrayList<Tip> tips = new ArrayList<>();
    private final File dataFile;

    public TipManager() {
        // store in project working directory; change path if you prefer /data folder
        this.dataFile = new File("tips.txt");
        loadTips();
    }

    public ArrayList<Tip> getTips() {
        return tips;
    }

    public void addTip(Tip t) {
        tips.add(t);
    }

    public void removeTip(int index) {
        if (index >= 0 && index < tips.size()) {
            tips.remove(index);
        }
    }

    public void saveTips() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(dataFile))) {
            for (Tip t : tips) {
                String line = escape(t.getDescription()) + ";" + Boolean.toString(t.isAdopted());
                bw.write(line);
                bw.newLine();
            }
        } catch (IOException ex) {
            System.err.println("Error saving tips: " + ex.getMessage());
        }
    }

    public void loadTips() {
        tips.clear();
        if (!dataFile.exists()) return;

        try (BufferedReader br = new BufferedReader(new FileReader(dataFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(";", 2);
                if (parts.length == 2) {
                    String desc = unescape(parts[0]);
                    boolean adopted = Boolean.parseBoolean(parts[1]);
                    tips.add(new Tip(desc, adopted));
                }
            }
        } catch (IOException ex) {
            System.err.println("Error loading tips: " + ex.getMessage());
        }
    }

    // simple escaping to allow semicolons/newlines in description if needed
    private String escape(String s) {
        return s.replace("\\", "\\\\").replace(";", "\\;");
    }

    private String unescape(String s) {
        StringBuilder sb = new StringBuilder();
        boolean slash = false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (slash) {
                sb.append(c);
                slash = false;
            } else if (c == '\\') {
                slash = true;
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
