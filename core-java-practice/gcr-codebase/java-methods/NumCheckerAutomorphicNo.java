import java.util.*;
public class NumCheckerAutomorphicNo {

    // Method to check if a number is prime number
    public static boolean isPrimeNumber(int number) {
        if(number<=1) return false;
        if(number==2) return true;
        if(number%2==0) return false;
        for(int i=3;i*i<=number;i=i+2) {
            if(number%i==0) return false;
        }
        return true;
    }

    // Method to check if a number is a neon number
    public static boolean isNeonNumber(int number) {
        int square=number*number;
        int sum=0;
        while(square>0) {
            sum=sum+square%10;
            square=square/10;
        }
        return sum==number;
    }

    // Method to check if a number is a spy number
    public static boolean isSpyNumber(int number) {
        int sum=0;
        int product=1;
        int temp=Math.abs(number);
        while(temp>0) {
            int digit=temp%10;
            sum=sum+digit;
            product=product*digit;
            temp=temp/10;
        }
        return sum==product;
    }

    // Method to check if a number is an automorphic number
    public static boolean isAutomorphicNumber(int number) {
        int square=number*number;
        int temp=number;
        while(temp>0) {
            if(temp%10!=square%10) return false;
            temp=temp/10;
            square=square/10;
        }
        return true;
    }

    // Method to check if a number is a buzz number
    public static boolean isBuzzNumber(int number) {
        return number%7==0 || number%10==7;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        // User input
        System.out.print("Enter a number: ");
        int number=sc.nextInt();

        // Check prime number
        boolean isPrime=isPrimeNumber(number);
        if(isPrime) System.out.println("The number is a Prime Number");
        else System.out.println("The number is not a Prime Number");

        // Check neon number
        boolean isNeon=isNeonNumber(number);
        if(isNeon) System.out.println("The number is a Neon Number");
        else System.out.println("The number is not a Neon Number");

        // Check spy number
        boolean isSpy=isSpyNumber(number);
        if(isSpy) System.out.println("The number is a Spy Number");
        else System.out.println("The number is not a Spy Number");

        // Check automorphic number
        boolean isAutomorphic=isAutomorphicNumber(number);
        if(isAutomorphic) System.out.println("The number is an Automorphic Number");
        else System.out.println("The number is not an Automorphic Number");

        // Check buzz number
        boolean isBuzz=isBuzzNumber(number);
        if(isBuzz) System.out.println("The number is a Buzz Number");
        else System.out.println("The number is not a Buzz Number");

        sc.close();
    }
}
