import java.util.Scanner;
public class TemperatureAnalyzer {
	
	// Method to find hottest day
	public static int findHottestDay(float[][]temp) {
		int hottestDay=0;
		float maxAvg=calculateDayAverage(temp,0);
		for(int i=1;i<temp.length;i++) {
			float avg=calculateDayAverage(temp,i);
			if(avg>maxAvg) {
				maxAvg=avg;
				hottestDay=i;
			}
		}
		return hottestDay;
	}
	
	// Method to find coldest day
	public static int findColdestDay(float[][]temp) {
		int coldestDay=0;
		float minAvg=calculateDayAverage(temp,0);
		for(int i=1;i<temp.length;i++) {
			float avg=calculateDayAverage(temp,i);
			if(avg<minAvg) {
				minAvg=avg;
				coldestDay=i;
			}
		}
		return coldestDay;
	}
	
	// Method to calculate average temperature for a specific day
	public static float calculateDayAverage(float[][]temp,int day) {
		float sum=0;
		for(int i=0;i<temp[day].length;i++) {
			sum+=temp[day][i];
		}
		return sum/temp[day].length;
	}
	
	// Method to return average temperature per day
	public static float[] averageTemperaturePerDay(float[][]temp) {
		float[]avgPerDay=new float[temp.length];
		for(int i=0;i<temp.length;i++) {
			avgPerDay[i]=calculateDayAverage(temp,i);
		}
		return avgPerDay;
	}
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		// Create 2D array for 7 days and 24 hours
		float[][]weekTemp=new float[7][24];
		
		// User input
		System.out.println("Enter temperature data for 7 days (24 hours each):");
		for(int day=0;day<7;day++) {
			System.out.println("Day "+(day+1)+":");
			for(int hour=0;hour<24;hour++) {
				System.out.print("Hour "+hour+": ");
				weekTemp[day][hour]=sc.nextFloat();
			}
		}
		
		// Find hottest and coldest day
		int hottestDay=findHottestDay(weekTemp);
		int coldestDay=findColdestDay(weekTemp);
		
		// Get average temperature per day
		float[]avgPerDay=averageTemperaturePerDay(weekTemp);
		
		// Display output
		String[]days={"Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday"};
		System.out.println("\n--- Temperature Analysis ---");
		System.out.println("Hottest day: "+days[hottestDay]+" (Day "+(hottestDay+1)+") with average temperature: "+String.format("%.2f",avgPerDay[hottestDay])+"°C");
		System.out.println("Coldest day: "+days[coldestDay]+" (Day "+(coldestDay+1)+") with average temperature: "+String.format("%.2f",avgPerDay[coldestDay])+"°C");
		
		System.out.println("\nAverage temperature per day:");
		for(int i=0;i<avgPerDay.length;i++) {
			System.out.println(days[i]+" (Day "+(i+1)+"): "+String.format("%.2f",avgPerDay[i])+"°C");
		}
		sc.close();
	}
}
