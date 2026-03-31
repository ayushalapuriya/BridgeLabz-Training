import java.util.Scanner;

public class Leetcode344ReverseString {

    public static void reverseString(char[] s){
        int st=0,end=s.length-1;
        while(st<=end){
            char temp=s[st];
            s[st]=s[end];
            s[end]=temp;
            st++;
            end--;
        }
    }
    
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        System.out.print("Enter length of array: ");
        int n=sc.nextInt();

        char[] arr=new char[n];
        System.out.print("Enter "+n+" elements: ");
        for(int i=0;i<n;i++) arr[i]=sc.next().charAt(0);

        reverseString(arr);

        // Print reversed array
        System.out.print("Reversed string: ");
        for(char c:arr) System.out.print(c+" ");

        sc.close();
    }
}
