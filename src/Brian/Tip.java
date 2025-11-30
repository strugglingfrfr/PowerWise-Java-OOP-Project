/*
 * Tip.java
 * Represents a single Green Tip.
 */
package Brian;

/**
 * @author apple
 */
public class Tip {
    
    private String description;
    private boolean adopted;

    public Tip(String description, boolean adopted) {
        this.description = description;
        this.adopted = adopted;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

