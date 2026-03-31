import java.util.*;
public class Bonus {

    // Method to determine the salary and years of service
    public static double[][] generateEmployeeData(int numEmployees) {
        double[][] data=new double[numEmployees][2];
        for(int i=0;i<numEmployees;i++) {
            data[i][0]=(int)(Math.random()*90000)+10000;
            data[i][1]=(int)(Math.random()*10)+1;
        }
        return data;
    }

    // Method to calculate the new salary and bonus
    public static double[][] calculateNewSalaryAndBonus(double[][] employeeData) {
        int numEmployees=employeeData.length;
        double[][] result=new double[numEmployees][2];
        for(int i=0;i<numEmployees;i++) {
            double oldSalary=employeeData[i][0];
            double yearsOfService=employeeData[i][1];
            double bonusPercentage;
            if(yearsOfService>5) bonusPercentage=0.05;
            else bonusPercentage=0.02;
            double bonus=oldSalary*bonusPercentage;
            double newSalary=oldSalary+bonus;
            result[i][0]=newSalary;
            result[i][1]=bonus;
        }
        return result;
    }

    // Method to calculate and display sum of old salary, new salary, and total bonus
    public static void displaySummary(double[][] employeeData,double[][] newData) {
        double totalOldSalary=0;
        double totalNewSalary=0;
        double totalBonus=0;
        
        System.out.println("\n=== Employee Bonus Report ===");
        System.out.println("Emp No\tYears\tOld Salary\tBonus\t\tNew Salary");
        System.out.println("--------------------------------------------------------------");
        
        for(int i=0;i<employeeData.length;i++) {
            double oldSalary=employeeData[i][0];
            double yearsOfService=employeeData[i][1];
            double newSalary=newData[i][0];
            double bonus=newData[i][1];
            
            totalOldSalary=totalOldSalary+oldSalary;
            totalNewSalary=totalNewSalary+newSalary;
            totalBonus=totalBonus+bonus;
            
            System.out.printf("%d\t%.0f\t%.2f\t%.2f\t\t%.2f\n",(i+1),yearsOfService,oldSalary,bonus,newSalary);
        }
        
        System.out.println("--------------------------------------------------------------");
        System.out.printf("Total:\t\t%.2f\t%.2f\t\t%.2f\n",totalOldSalary,totalBonus,totalNewSalary);
    }

    public static void main(String[] args) {
        int numEmployees=10;
        
        // Generate employee data
        double[][] employeeData=generateEmployeeData(numEmployees);
        
        // Calculate new salary and bonus
        double[][] newData=calculateNewSalaryAndBonus(employeeData);
        
        // Display summary
        displaySummary(employeeData,newData);
    }
}
