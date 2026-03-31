import java.util.*;
public class FindAverageMinMax {

    // Method to generate array of 4 digit random numbers
    public static int[] generate4DigitRandomArray(int size) {
        int[] randomArray=new int[size];
        for(int i=0;i<size;i++) {
            randomArray[i]=(int)(Math.random()*9000)+1000;
        }
        return randomArray;
    }

    // Method to find average, min and max value
    public static double[] findAverageMinMax(int[] numbers) {
        int sum=0;
        int min=numbers[0];
        int max=numbers[0];
        for(int i=0;i<numbers.length;i++) {
            sum=sum+numbers[i];
            min=Math.min(min,numbers[i]);
            max=Math.max(max,numbers[i]);
        }
        double average=(double)sum/numbers.length;
        return new double[]{average,min,max};
    }

    public static void main(String[] args) {
        int[] randomNumbers=generate4DigitRandomArray(5);

        // Display output
        System.out.println("Generated 5 random 4-digit numbers:");
        for(int i=0;i<randomNumbers.length;i++) {
            System.out.println("Number "+(i+1)+": "+randomNumbers[i]);
        }

        double[] result=findAverageMinMax(randomNumbers);

        System.out.println("\nAverage: "+result[0]);
        System.out.println("Minimum: "+(int)result[1]);
        System.out.println("Maximum: "+(int)result[2]);
    }
}
