import java.util.*;
public class NumCheckerPalindromeNo {

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

    // Method to reverse the digits array
    public static int[] reverseArray(int[] digits) {
        int[] reversed=new int[digits.length];
        for(int i=0;i<digits.length;i++) {
            reversed[i]=digits[digits.length-1-i];
        }
        return reversed;
    }

    // Method to compare two arrays and check if they are equal
    public static boolean compareArrays(int[] arr1,int[] arr2) {
        if(arr1.length!=arr2.length) return false;
        for(int i=0;i<arr1.length;i++) {
            if(arr1[i]!=arr2[i]) return false;
        }
        return true;
    }

    // Method to check if a number is a palindrome using the digits
    public static boolean isPalindrome(int[] digits) {
        int[] reversed=reverseArray(digits);
        return compareArrays(digits,reversed);
    }

    // Method to check if a number is a duck number
    public static boolean isDuckNumber(int[] digits) {
        if(digits[0]==0) return false;
        for(int i=1;i<digits.length;i++) {
            if(digits[i]==0) return true;
        }
        return false;
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

        // Reverse digits array
        int[] reversed=reverseArray(digits);
        System.out.print("Reversed digits array: ");
        for(int i=0;i<reversed.length;i++) {
            System.out.print(reversed[i]+" ");
        }
        System.out.println();

        // Compare arrays
        boolean areEqual=compareArrays(digits,reversed);
        if(areEqual) System.out.println("Original and reversed arrays are equal");
        else System.out.println("Original and reversed arrays are not equal");

        // Check palindrome
        boolean isPalin=isPalindrome(digits);
        if(isPalin) System.out.println("The number is a Palindrome Number");
        else System.out.println("The number is not a Palindrome Number");

        // Check duck number
        boolean isDuck=isDuckNumber(digits);
        if(isDuck) System.out.println("The number is a Duck Number");
        else System.out.println("The number is not a Duck Number");

        sc.close();
    }
}
