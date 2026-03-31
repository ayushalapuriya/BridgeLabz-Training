import java.util.*;
public class CheckNumAndEvenOdd {

    // Method to check if number is positive
    public static boolean isPositive(int num) {
        if(num>=0) return true;
        else return false;
    }

    // Method to check if number is even
    public static boolean isEven(int num) {
        if(num%2==0) return true;
        else return false;
    }

    // Method to compare two numbers
    public static int compare(int num1, int num2) {
        if(num1>num2) return 1;
        else if(num1==num2) return 0;
        else return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] numbers=new int[5];

        // User input
        System.out.println("Enter 5 numbers:");
        for(int i=0;i<5;i++) {
            System.out.print("Enter number "+(i+1)+": ");
            numbers[i]=sc.nextInt();
        }

        // Check positive/negative and even/odd
        System.out.println("\nAnalysis of numbers:");
        for(int i=0;i<5;i++) {
            if(isPositive(numbers[i])) {
                if(isEven(numbers[i])) {
                    System.out.println(numbers[i]+" is positive and even");
                } else {
                    System.out.println(numbers[i]+" is positive and odd");
                }
            } else {
                System.out.println(numbers[i]+" is negative");
            }
        }

        int result=compare(numbers[0],numbers[4]);
        
        // Display output
        System.out.println("\nComparison of first and last elements:");
        if(result==1) {
            System.out.println("First element "+numbers[0]+" is greater than last element "+numbers[4]);
        } else if(result==0) {
            System.out.println("First element "+numbers[0]+" is equal to last element "+numbers[4]);
        } else {
            System.out.println("First element "+numbers[0]+" is less than last element "+numbers[4]);
        }

        sc.close();
    }
}
