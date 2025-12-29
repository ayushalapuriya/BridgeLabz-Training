import java.util.Scanner;
public class EmployWageComputationProblem {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Welcome to Employee Wage Computation Program\n");
		
		// UC 1: Check Employee is Present or Absent
		int isPresent=(int)(Math.random()*2);
		if(isPresent==1) System.out.println("Employee is Present");
		else System.out.println("Employee is Absent");
		
		// UC 2: Calculate Daily Employee Wage
		int ratePerHour=20;
		int fullTimeHours=8;
		int fullTimeSalary=ratePerHour*fullTimeHours;
		System.out.println("\nDaily Wage (Full Time): "+fullTimeSalary+" Rs");
		
		// UC 3: Add Part Time Employee & Wage
		int halfDayHours=4;
		int halfDaySalary=ratePerHour*halfDayHours;
		System.out.println("Daily Wage (Part Time): "+halfDaySalary+" Rs");
		
		// UC 4: Solving using Switch Case Statement
		System.out.print("\nEnter employee type (0=Part Time, 1=Full Time): ");
		int empCategory=sc.nextInt();
		int dailyEarning=0;
		switch(empCategory) {
		case 0:
			dailyEarning=halfDaySalary;
			System.out.println("Part Time Employee Daily Wage: "+dailyEarning+" Rs");
			break;
		case 1:
			dailyEarning=fullTimeSalary;
			System.out.println("Full Time Employee Daily Wage: "+dailyEarning+" Rs");
			break;
		}
		
		// UC 5: Calculating Wages for a Month
		int daysInMonth=20;
		int monthlySalaryFull=fullTimeSalary*daysInMonth;
		int monthlySalaryHalf=halfDaySalary*daysInMonth;
		System.out.println("\nMonthly Wage (Full Time): "+monthlySalaryFull+" Rs");
		System.out.println("Monthly Wage (Part Time): "+monthlySalaryHalf+" Rs");
		
		// UC 6: Calculate Wages till condition is reached
		System.out.println("\n--- UC 6: Wage Calculation with Conditions ---");
		System.out.print("Enter employee type (0=Part Time, 1=Full Time): ");
		int workerType=sc.nextInt();
		
		int hoursWorked=0;
		int daysWorked=0;
		int salaryEarned=0;
		int hourLimit=100;
		int dayLimit=20;
		
		while(hoursWorked<hourLimit && daysWorked<dayLimit) {
			int checkPresent=(int)(Math.random()*2);
			if(checkPresent==1) {
				switch(workerType) {
				case 0:
					salaryEarned+=halfDaySalary;
					hoursWorked+=halfDayHours;
					daysWorked++;
					System.out.println("Day "+daysWorked+": Part Time - Earned "+halfDaySalary+" Rs (Total: "+salaryEarned+" Rs)");
					break;
				case 1:
					salaryEarned+=fullTimeSalary;
					hoursWorked+=fullTimeHours;
					daysWorked++;
					System.out.println("Day "+daysWorked+": Full Time - Earned "+fullTimeSalary+" Rs (Total: "+salaryEarned+" Rs)");
					break;
				}
			} else {
				System.out.println("Employee Absent Today");
			}
		}
		
		System.out.println("\n--- Final Summary ---");
		System.out.println("Total Days Worked: "+daysWorked);
		System.out.println("Total Hours Worked: "+hoursWorked);
		System.out.println("Total Wages Earned: "+salaryEarned+" Rs");
		
		sc.close();
	}
}
