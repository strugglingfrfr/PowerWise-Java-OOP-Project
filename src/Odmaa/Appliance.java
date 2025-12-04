/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Odmaa;

/**
 *
 * @author apple
 */
public class Appliance {

    private String applianceName;
    private double wattage;
    private double hours;
    private double energyUsage;   // Added because Hamza’s GUI reads this from file

    public Appliance() { }

    public Appliance(String applianceName, double energyUsage, double wattage, double hours) {
        this.applianceName = applianceName;
        this.energyUsage = energyUsage;
        this.wattage = wattage;
        this.hours = hours;
    }

    // setters and getters
    public void setApplianceName(String applianceName) {
        this.applianceName = applianceName;
    }

    public void setWattage(double wattage) {
        this.wattage = wattage;
    }

    public void setHours(double hours) {
        this.hours = hours;
    }

    public void setEnergyUsage(double energyUsage) {
        this.energyUsage = energyUsage;
    }

    public String getApplianceName() {
        return applianceName;
    }

    public double getWattage() {
        return wattage;
    }

    public double getHours() {
        return hours;
    }

    public double getEnergyUsage() {
        return energyUsage;
    }

    // for safety — if energyUsage wasn't saved, we calculate it
    public double calculateEnergyUsage() {
        return wattage * hours;
    }

    @Override
    public String toString() {
        return applianceName + " (Wattage: " + wattage + ", Hours/day: " + hours + ")";
    }
}