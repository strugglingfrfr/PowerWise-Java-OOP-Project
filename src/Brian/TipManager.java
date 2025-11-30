/*
 * TipManager.java
 * Handles saving and loading Green Tips from a file.
 *
 * @author apple
 */
package Brian;

import java.io.*;
import java.util.ArrayList;

public class TipManager {

    private static final String FILE_NAME = "tips.dat";
    private ArrayList<Tip> tips = new ArrayList<>();

    public TipManager() {
        loadTips();
    }

    public void addTip(Tip tip) {
        tips.add(tip);
    }

    public ArrayList<Tip> getTips() {
        return tips;
    }

    public void saveTips() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(tips);
        } catch (IOException ex) {
            System.out.println("Error saving tips: " + ex.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public void loadTips() {
        File f = new File(FILE_NAME);
        if (!f.exists()) return;

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            tips = (ArrayList<Tip>) ois.readObject();
        } catch (Exception ex) {
            System.out.println("Error loading tips: " + ex.getMessage());
        }
    }
}
