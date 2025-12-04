/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Odmaa;

import java.util.ArrayList;
import power.wise.app.SmartEnergyApp;
/**
 *
 * @author apple
 */
public class ApplianceManager {

    private ArrayList<Appliance> appliances = new ArrayList<>();

    public ArrayList<Appliance> getAppliances() {
        return appliances;
    }

    public void addAppliance(Appliance a) {
        appliances.add(a);
    }
}
