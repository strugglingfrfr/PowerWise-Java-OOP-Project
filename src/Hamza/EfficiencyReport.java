/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Hamza;

/**
 *
 * @author muhammadhamzaanjum
 */
public class EfficiencyReport extends Report {

    private String warningMessage;

    // Empty constructor
    public EfficiencyReport() { }

    // Main constructor that wraps the base Report
    public EfficiencyReport(Report base, String warningMessage) {

        // Copying required fields from the base report
        setApplianceName(base.getApplianceName());
        setDailyUsage(base.getDailyUsage());
        setWeeklyUsage(base.getWeeklyUsage());
        setMonthlyUsage(base.getMonthlyUsage());
        setYearlyUsage(base.getYearlyUsage());
        setMonthlyCost(base.getMonthlyCost());
        setRecommendedDailyUsage(base.getRecommendedDailyUsage());
        setRecommendedHours(base.getRecommendedHours());
        setUsageAnalysis(base.getUsageAnalysis());
        setPrediction(base.getPrediction());
        setTip(base.getTip());
        setDateGenerated(base.getDateGenerated());

        this.warningMessage = warningMessage;
    }

    // setter and getter
    public void setWarningMessage(String warningMessage) {
        this.warningMessage = warningMessage;
    }

    public String getWarningMessage() {
        return warningMessage;
    }

    // Adds the warning message above the normal report text
    @Override
    public String printReport() {

        return 
            "⚠ HIGH ENERGY WARNING ⚠\n" +
            warningMessage + "\n\n" +
            super.printReport();
    }
}

    

