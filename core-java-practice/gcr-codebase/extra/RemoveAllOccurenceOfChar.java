import java.util.Scanner;
public class RemoveAllOccurenceOfChar {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		// User input
		System.out.print("Enter a string: ");
		String str=sc.nextLine();
		System.out.print("Enter character to remove: ");
		char ch=sc.next().charAt(0);
		
		// Remove all occurence of char ch
		String modified="";
		for(char c:str.toCharArray()) {
			if(c!=ch) modified+=c;
		}
		
		// Display output
		System.out.println("FInal string after remove all occurence of given char is: "+modified);
		
		sc.close();
	}
}
