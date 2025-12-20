import java.util.*;

public class GradeAndRemarks {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int maths = sc.nextInt();
		int physics = sc.nextInt();
		int chemistry = sc.nextInt();
		double percent = (maths + chemistry + physics) / 3;
		if (percent >= 80)
			System.out.println("Average marks is: " + percent
					+ " Grade is A and Remarks is (Level 4, above agency-normalized standards");
		else if (percent >= 70 && percent <= 79)
			System.out.println("Average marks is: " + percent
					+ "Grade is B and Remarks is (Level 3, at agency-normalized standards");
		else if (percent>=60 && percent<=69) System.out.println("Average marks is: " + percent+
				"Grade is C and Remarks is (Level 2, below, but approach agency-normalized standards");
		else if(percent>=50 && percent<=59) System.out.println("Average marks is: " + percent+
				"Grade is D and Remarks is (Level 1, well below agency-normalized standards");
		else if(percent>=40 && percent<=49) System.out.println("Average marks is: " + percent
					+ "Grade is E and Remarks is (Level 1-, too below agency-normalized standards");
		else System.out.println("Average marks is: " + percent
				+ "Grade is R and Remarks is (Remedial standards");
			sc.close();
	}
}
