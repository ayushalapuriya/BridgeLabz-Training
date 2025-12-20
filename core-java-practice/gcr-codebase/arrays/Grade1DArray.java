import java.util.Scanner;

public class Grade1DArray {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.print("Enter number of students: ");
		int students = sc.nextInt();

		int[] physics = new int[students];
		int[] chemistry = new int[students];
		int[] maths = new int[students];
		double[] percentage = new double[students];
		char[] grade = new char[students];

		for (int i = 0; i < students; i++) {
			System.out.println("\nStudent " + (i + 1));

			System.out.print("Enter Physics marks: ");
			physics[i] = sc.nextInt();
			if (physics[i] < 0) {
				System.out.println("Invalid marks, enter again");
				i--;
				continue;
			}

			System.out.print("Enter Chemistry marks: ");
			chemistry[i] = sc.nextInt();
			if (chemistry[i] < 0) {
				System.out.println("Invalid marks, enter again");
				i--;
				continue;
			}

			System.out.print("Enter Maths marks: ");
			maths[i] = sc.nextInt();
			if (maths[i] < 0) {
				System.out.println("Invalid marks, enter again");
				i--;
				continue;
			}
		}

		for (int i = 0; i < students; i++) {
			percentage[i] = (physics[i] + chemistry[i] + maths[i]) / 3.0;

			if (percentage[i] >= 80)
				grade[i] = 'A';
			else if (percentage[i] >= 70)
				grade[i] = 'B';
			else if (percentage[i] >= 60)
				grade[i] = 'C';
			else if (percentage[i] >= 50)
				grade[i] = 'D';
			else if (percentage[i] >= 40)
				grade[i] = 'E';
			else
				grade[i] = 'R';
		}

		System.out.println("\n----- Result -----");
		for (int i = 0; i < students; i++) {
			System.out.println("\nStudent " + (i + 1));
			System.out.println("Physics   : " + physics[i]);
			System.out.println("Chemistry : " + chemistry[i]);
			System.out.println("Maths     : " + maths[i]);
			System.out.println("Percentage: " + percentage[i]);
			System.out.println("Grade     : " + grade[i]);
		}

		sc.close();
	}
}
