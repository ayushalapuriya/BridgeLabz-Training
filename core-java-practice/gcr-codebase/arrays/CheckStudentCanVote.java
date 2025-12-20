import java.util.*;
public class CheckStudentCanVote {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		// Declare 1D array of 10 length
		int[]age=new int[10];
		
		// Input the age of 10 students
		for(int i=0;i<10;i++) age[i]=sc.nextInt();
		
		// Check the student can vote or not
		for(int i=0;i<10;i++) {
			if(age[i]<0) System.out.println(age[i]+" Invalid age");
			else if(age[i]>=18) System.out.println("The student with the age "+age[i]+" can vote");
			else System.out.println("The student with the age "+age[i]+" can't vote");
		}
		sc.close();
	}
}
