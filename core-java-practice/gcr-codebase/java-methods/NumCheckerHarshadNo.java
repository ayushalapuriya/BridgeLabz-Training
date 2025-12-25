import java.util.*;
public class NumCheckerHarshadNo {

    // Method to find the count of digits in the number
    public static int countDigits(int number) {
        int count=0;
        int temp=Math.abs(number);
        if(temp==0) return 1;
        while(temp>0) {
            count++;
            temp=temp/10;
        }
        return count;
    }

    // Method to store the digits of the number in a digits array
    public static int[] storeDigits(int number) {
        int count=countDigits(number);
        int[] digits=new int[count];
        int temp=Math.abs(number);
        for(int i=count-1;i>=0;i--) {
            digits[i]=temp%10;
            temp=temp/10;
        }
        return digits;
    }

    // Method to find the sum of the digits using the digits array
    public static int findSumOfDigits(int[] digits) {
        int sum=0;
        for(int i=0;i<digits.length;i++) {
            sum=sum+digits[i];
        }
        return sum;
    }

    // Method to find the sum of the squares of the digits using the digits array
    public static int findSumOfSquares(int[] digits) {
        int sum=0;
        for(int i=0;i<digits.length;i++) {
            sum=sum+(int)Math.pow(digits[i],2);
        }
        return sum;
    }

    // Method to check if a number is a Harshad number
    public static boolean isHarshadNumber(int number,int[] digits) {
        int sum=findSumOfDigits(digits);
        if(sum==0) return false;
        return number%sum==0;
    }

    // Method to find the frequency of each digit in the number
    public static int[][] findDigitFrequency(int[] digits) {
        int[] freq=new int[10];
        for(int i=0;i<digits.length;i++) {
            freq[digits[i]]++;
        }
        int uniqueCount=0;
        for(int i=0;i<10;i++) {
            if(freq[i]>0) uniqueCount++;
        }
        int[][] result=new int[uniqueCount][2];
        int index=0;
        for(int i=0;i<10;i++) {
            if(freq[i]>0) {
                result[index][0]=i;
                result[index][1]=freq[i];
                index++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        // User input
        System.out.print("Enter a number: ");
        int number=sc.nextInt();

        // Count digits
        int digitCount=countDigits(number);
        System.out.println("\nNumber of digits: "+digitCount);

        // Store digits in array
        int[] digits=storeDigits(number);
        System.out.print("Digits array: ");
        for(int i=0;i<digits.length;i++) {
            System.out.print(digits[i]+" ");
        }
        System.out.println();

        // Sum of digits
        int sumOfDigits=findSumOfDigits(digits);
        System.out.println("Sum of digits: "+sumOfDigits);

        // Sum of squares of digits
        int sumOfSquares=findSumOfSquares(digits);
        System.out.println("Sum of squares of digits: "+sumOfSquares);

        // Check Harshad number
        boolean isHarshad=isHarshadNumber(number,digits);
        if(isHarshad) System.out.println("The number is a Harshad Number");
        else System.out.println("The number is not a Harshad Number");

        // Digit frequency
        int[][] frequency=findDigitFrequency(digits);
        System.out.println("\nDigit Frequency:");
        for(int i=0;i<frequency.length;i++) {
            System.out.println("Digit "+frequency[i][0]+" appears "+frequency[i][1]+" time(s)");
        }

        sc.close();
    }
}
