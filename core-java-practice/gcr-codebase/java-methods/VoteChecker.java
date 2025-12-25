import java.util.*;
public class VoteChecker {

    // Method to check vote
    public static boolean canStudentVote(int age) {
        if(age<0) return false;
        if(age>=18) return true;
        else return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] ages=new int[10];

        // User input and display output
        System.out.println("Enter ages of 10 students:");
        for(int i=0;i<10;i++) {
            System.out.print("Enter age of student "+(i+1)+": ");
            ages[i]=sc.nextInt();
            boolean canVote=canStudentVote(ages[i]);
            if(canVote) {
                System.out.println("Student "+(i+1)+" can vote");
            } else {
                System.out.println("Student "+(i+1)+" cannot vote");
            }
        }

        sc.close();
    }
}
