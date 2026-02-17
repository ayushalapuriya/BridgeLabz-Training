package model;

import java.util.ArrayList;

public class CompanyEmpWage {

    private String companyName;
    private int wagePerHour;
    private int workingDays;
    private int maxHours;
    private int totalWage;

    private ArrayList<Integer> dailyWages = new ArrayList<>();

    public CompanyEmpWage(String companyName,
                          int wagePerHour,
                          int workingDays,
                          int maxHours){

        this.companyName = companyName;
        this.wagePerHour = wagePerHour;
        this.workingDays = workingDays;
        this.maxHours = maxHours;
    }

    public String getCompanyName(){
        return companyName;
    }

    public int getWagePerHour(){
        return wagePerHour;
    }

    public int getWorkingDays(){
        return workingDays;
    }

    public int getMaxHours(){
        return maxHours;
    }

    public void addDailyWage(int wage){
        dailyWages.add(wage);
    }

    public void setTotalWage(int totalWage){
        this.totalWage = totalWage;
    }

    public int getTotalWage(){
        return totalWage;
    }
}
