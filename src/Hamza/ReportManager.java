package Hamza;

import Odmaa.Appliance;           // using Odmaa’s appliance class now
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.time.LocalDate;

/**
 * Handles generating and saving energy reports.
 * Polymorphism included through returning EfficiencyReport when needed.
 */
public class ReportManager implements Savable {

    @Override
    public void save() {
        // Part of Savable (not used here, just required by interface)
        System.out.println("ReportManager save() called.");
    }

    @Override
    public void load() {
        // Part of Savable (not used here)
        System.out.println("ReportManager load() called.");
    }

    // Generates a full report using an Appliance object from user input
    // Supports polymorphism by returning EfficiencyReport in certain cases
    public Report generateReport(Appliance appliance) {

        String name = appliance.getApplianceName();
        double wattage = appliance.getWattage();
        double hours = appliance.getHours();

        // Converting to kWh
        double dailyUsage = (wattage * hours) / 1000.0;
        double weeklyUsage = dailyUsage * 7;
        double monthlyUsage = dailyUsage * 30;
        double yearlyUsage = dailyUsage * 365;

        // Cost estimate assuming €0.30 per kWh
        double monthlyCost = monthlyUsage * 0.30;

        // Recommended hours per day
        int recommendedHours = getRecommendedHours(name);
        double recommendedDailyUsage = (wattage * recommendedHours) / 1000.0;

        // Usage analysis compared to recommended hours
        String usageAnalysis =
                hours > recommendedHours ? "Your usage is higher than recommended."
                : hours == recommendedHours ? "Your usage is within the recommended range."
                : "Your usage is lower than recommended.";

        // Prediction for yearly usage
        String prediction = "If you continue like this, you will use "
                + String.format("%.2f", yearlyUsage)
                + " kWh this year.";

        // Simple default tip (full flow would use Brian’s input)
        String tip = "Try reducing usage during peak hours to save energy.";

        // Today's date
        String dateGenerated = LocalDate.now().toString();

        // Base report object
        Report base = new Report(
                name,
                dailyUsage,
                weeklyUsage,
                monthlyUsage,
                tip,
                dateGenerated
        );

        // Filling the remaining fields
        base.setYearlyUsage(yearlyUsage);
        base.setMonthlyCost(monthlyCost);
        base.setRecommendedDailyUsage(recommendedDailyUsage);
        base.setRecommendedHours(recommendedHours);
        base.setUsageAnalysis(usageAnalysis);
        base.setPrediction(prediction);

        // Polymorphism: return EfficiencyReport if far above recommended usage
        if (dailyUsage > recommendedDailyUsage * 1.5) {
            return new EfficiencyReport(
                    base,
                    "High consumption detected. Consider reducing usage."
            );
        }

        // Otherwise return standard Report
        return base;
    }

    // Returns recommended hours for common appliances
    private int getRecommendedHours(String name) {
        name = name.toLowerCase();

        if (name.contains("laptop")) return 6;
        if (name.contains("tv")) return 8;
        if (name.contains("heater")) return 3;
        if (name.contains("fridge")) return 24;
        if (name.contains("washing")) return 2;

        return 3; // Default recommendation
    }

    // Saves the generated report to text file
    public void saveReport(Report report) {
        try {
            File f = new File("data/reports.txt");
            BufferedWriter bw = new BufferedWriter(new FileWriter(f, true));

            bw.write("----- Report (" + report.getDateGenerated() + ") -----\n");
            bw.write(report.printReport() + "\n");
            bw.write("------------------------------------------\n\n");

            bw.close();
        } catch (Exception e) {
            System.out.println("Error saving report: " + e);
        }
    }
}
