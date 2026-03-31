import java.util.Scanner;

public class Leetcode9PalindromeNumber {

    public static boolean isPalindrome(int x){
        if(x<0) return false;

        int num=x,rev=0;
        while(num!=0){
            rev=rev*10+num%10;
            num/=10;
        }
        return rev==x;
    }

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        System.out.print("Enter number: ");
        int n=sc.nextInt();

        if(isPalindrome(n)) System.out.println("Palindrome Number");
        else System.out.println("Not Palindrome Number");

        sc.close();
    }
}
