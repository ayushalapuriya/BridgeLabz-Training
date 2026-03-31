import java.util.*;
public class NumCheckerStrongNo {

    // Method to find sum of proper divisors
    public static int sumOfProperDivisors(int number) {
        int sum=0;
        for(int i=1;i<=number/2;i++) {
            if(number%i==0) sum=sum+i;
        }
        return sum;
    }

    // Method to check if a number is a perfect number
    public static boolean isPerfectNumber(int number) {
        if(number<=0) return false;
        int sum=sumOfProperDivisors(number);
        return sum==number;
    }

    // Method to check if a number is an abundant number
    public static boolean isAbundantNumber(int number) {
        if(number<=0) return false;
        int sum=sumOfProperDivisors(number);
        return sum>number;
    }

    // Method to check if a number is a deficient number
    public static boolean isDeficientNumber(int number) {
        if(number<=0) return false;
        int sum=sumOfProperDivisors(number);
        return sum<number;
    }

    // Method to find factorial of a digit
    public static int findFactorial(int digit) {
        int fact=1;
        for(int i=1;i<=digit;i++) {
            fact=fact*i;
        }
        return fact;
    }

    // Method to check if a number is a strong number
    public static boolean isStrongNumber(int number) {
        int sum=0;
        int temp=Math.abs(number);
        while(temp>0) {
            int digit=temp%10;
            sum=sum+findFactorial(digit);
            temp=temp/10;
        }
        return sum==Math.abs(number);
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        // User input
        System.out.print("Enter a number: ");
        int number=sc.nextInt();

        // Check perfect number
        boolean isPerfect=isPerfectNumber(number);
        if(isPerfect) System.out.println("The number is a Perfect Number");
        else System.out.println("The number is not a Perfect Number");

        // Check abundant number
        boolean isAbundant=isAbundantNumber(number);
        if(isAbundant) System.out.println("The number is an Abundant Number");
        else System.out.println("The number is not an Abundant Number");

        // Check deficient number
        boolean isDeficient=isDeficientNumber(number);
        if(isDeficient) System.out.println("The number is a Deficient Number");
        else System.out.println("The number is not a Deficient Number");

        // Check strong number
        boolean isStrong=isStrongNumber(number);
        if(isStrong) System.out.println("The number is a Strong Number");
        else System.out.println("The number is not a Strong Number");

        sc.close();
    }
}
