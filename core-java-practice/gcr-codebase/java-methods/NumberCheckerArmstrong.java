import java.util.*;
public class NumberCheckerArmstrong {

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

    // Method to check if a number is a duck number
    public static boolean isDuckNumber(int[] digits) {
        if(digits[0]==0) return false;
        for(int i=1;i<digits.length;i++) {
            if(digits[i]==0) return true;
        }
        return false;
    }

    // Method to check if the number is an Armstrong number
    public static boolean isArmstrongNumber(int[] digits) {
        int sum=0;
        int power=digits.length;
        for(int i=0;i<digits.length;i++) {
            sum=sum+(int)Math.pow(digits[i],power);
        }
        int originalNumber=0;
        for(int i=0;i<digits.length;i++) {
            originalNumber=originalNumber*10+digits[i];
        }
        return sum==originalNumber;
    }

    // Method to find the largest and second largest elements in the digits array
    public static int[] findLargestAndSecondLargest(int[] digits) {
        int largest=Integer.MIN_VALUE;
        int secondLargest=Integer.MIN_VALUE;
        for(int i=0;i<digits.length;i++) {
            if(digits[i]>largest) {
                secondLargest=largest;
                largest=digits[i];
            } else if(digits[i]>secondLargest && digits[i]!=largest) {
                secondLargest=digits[i];
            }
        }
        return new int[]{largest,secondLargest};
    }

    // Method to find the smallest and second smallest elements in the digits array
    public static int[] findSmallestAndSecondSmallest(int[] digits) {
        int smallest=Integer.MAX_VALUE;
        int secondSmallest=Integer.MAX_VALUE;
        for(int i=0;i<digits.length;i++) {
            if(digits[i]<smallest) {
                secondSmallest=smallest;
                smallest=digits[i];
            } else if(digits[i]<secondSmallest && digits[i]!=smallest) {
                secondSmallest=digits[i];
            }
        }
        return new int[]{smallest,secondSmallest};
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

        // Check duck number
        boolean isDuck=isDuckNumber(digits);
        if(isDuck) System.out.println("The number is a Duck Number");
        else System.out.println("The number is not a Duck Number");

        // Check Armstrong number
        boolean isArmstrong=isArmstrongNumber(digits);
        if(isArmstrong) System.out.println("The number is an Armstrong Number");
        else System.out.println("The number is not an Armstrong Number");

        // Find largest and second largest
        int[] largestResults=findLargestAndSecondLargest(digits);
        System.out.println("Largest digit: "+largestResults[0]);
        if(largestResults[1]!=Integer.MIN_VALUE) System.out.println("Second largest digit: "+largestResults[1]);
        else System.out.println("Second largest digit: Not found");

        // Find smallest and second smallest
        int[] smallestResults=findSmallestAndSecondSmallest(digits);
        System.out.println("Smallest digit: "+smallestResults[0]);
        if(smallestResults[1]!=Integer.MAX_VALUE) System.out.println("Second smallest digit: "+smallestResults[1]);
        else System.out.println("Second smallest digit: Not found");

        sc.close();
    }
}
