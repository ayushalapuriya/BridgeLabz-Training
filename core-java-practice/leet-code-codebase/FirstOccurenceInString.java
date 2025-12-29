import java.util.Scanner;
public class FirstOccurenceInString {
    public static int strStr(String haystack, String needle) {
        int m=haystack.length();
        int n=needle.length();
        for(int i=0;i<m-n+1;i++){
            String s=haystack.substring(i,i+n);
            if(s.equals(needle)) return i;
        }
        return -1;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String haystack=sc.nextLine();
        String needle=sc.nextLine();
        int index=strStr(haystack,needle);
        if(index!=-1) System.out.println(index);
        else System.out.println(index);
        sc.close();
    }
}