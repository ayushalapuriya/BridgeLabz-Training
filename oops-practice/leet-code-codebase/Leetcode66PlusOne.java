import java.util.Scanner;
class Leetcode66PlusOne {
    public static int[] plusOne(int[] digits) {
    	int n=digits.length;
        for(int i=n-1;i>=0;i--) {
        	if(digits[i]<9) {
        		digits[i]++;
        		return digits;
        	}
        	else digits[i]=0;
        }
        digits=new int[n+1];
        digits[0]=1;
        return digits;
    }
    public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.err.print("Enter a length of array: ");
		int n=sc.nextInt();
		int[]digits=new int[n];
		System.out.print("Enter digits: ");
		for(int i=0;i<n;i++) {
			digits[i]=sc.nextInt();
		}
		int[]ans=plusOne(digits);
		for(int i=0;i<ans.length;i++) System.out.print(ans[i]+" ");
		sc.close();
	}
}