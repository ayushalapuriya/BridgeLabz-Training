import java.util.Scanner;
public class LengthOfLastWord {
    public static int lengthOfLastWord(String s) {
        String[]str=s.split(" ");
        String lastWord=str[str.length-1];
        int l=lastWord.length();
        return l;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        int length=lengthOfLastWord(s);
        System.out.println(length);
        sc.close();
    }
}