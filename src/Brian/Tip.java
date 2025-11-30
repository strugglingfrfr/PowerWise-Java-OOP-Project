/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Brian;

/**
 *
 * @author apple
 */
public class Tip {

    private String description;
    private boolean adopted;

    public Tip() {
    }

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
        return description + " | Adopted: " + adopted;
    }
}
