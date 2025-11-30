/*
 * Tip.java
 * Represents a single Green Tip.
 * 
 * @author apple
 */
package Brian;

import java.io.Serializable;

public class Tip implements Serializable {

    private String description;
    private boolean adopted;

    public Tip(String description, boolean adopted) {
        this.description = description;
        this.adopted = adopted;
    }

    public String getDescription() {
        return description;
    }

    public boolean isAdopted() {
        return adopted;
    }

    public void setAdopted(boolean adopted) {
        this.adopted = adopted;
    }

    @Override
    public String toString() {
        return description + (adopted ? " (Adopted)" : "");
    }
}
