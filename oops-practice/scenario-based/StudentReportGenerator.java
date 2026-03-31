import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Custom exception for invalid marks
class InvalidMarkException extends Exception{
    InvalidMarkException(String message){
        super(message);
    }
}

// Student class to store name and marks
class Student{
    String name;
    int[] marks; // subject-wise marks

    Student(String name,int[] marks){
        this.name=name;
        this.marks=marks;
    }
}

public class StudentReportGenerator{
    // Method to calculate average marks
    public static double calculateAverage(int[] marks){
        int sum=0;
        for(int m:marks) sum+=m;
        return sum*1.0/marks.length;
    }

    // Method to assign grade based on average
    public static String getGrade(double average){
        if(average>=90) return "A+";
        else if(average>=80) return "A";
        else if(average>=70) return "B";
        else if(average>=60) return "C";
        else return "F";
    }

    // Method to display report card
    public static void displayReport(Student s,String[] subjects){
        System.out.println("=== Report Card ===");
        System.out.println("Name: "+s.name);
        for(int i=0;i<subjects.length;i++){
            System.out.println(subjects[i]+": "+s.marks[i]);
        }
        double avg=calculateAverage(s.marks);
        String grade=getGrade(avg);
        System.out.println("Average: "+String.format("%.2f",avg));
        System.out.println("Grade: "+grade);
        System.out.println("==================");
    }

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        List<Student> students=new ArrayList<>(); // store multiple student records

        System.out.print("Enter number of students: ");
        int n=sc.nextInt();
        sc.nextLine(); // consume newline

        System.out.print("Enter number of subjects: ");
        int sub=sc.nextInt();
        sc.nextLine();

        String[] subjects=new String[sub];
        for(int i=0;i<sub;i++){
            System.out.print("Enter subject "+(i+1)+" name: ");
            subjects[i]=sc.nextLine().trim();
        }

        for(int i=0;i<n;i++){
            System.out.println("Student "+(i+1)+":");
            System.out.print("Enter name: ");
            String name=sc.nextLine().trim();
            int[] marks=new int[sub];
            for(int j=0;j<sub;j++){
                System.out.print(subjects[j]+" marks: ");
                marks[j]=sc.nextInt();
                // Validate marks 0-100
                while(marks[j]<0 || marks[j]>100){
                    System.out.print("Invalid! Enter 0-100: ");
                    marks[j]=sc.nextInt();
                }
            }
            sc.nextLine(); // consume newline
            students.add(new Student(name,marks));
        }

        // Display report cards for all students
        for(Student s:students){
            displayReport(s,subjects);
        }

        sc.close();
    }
}
