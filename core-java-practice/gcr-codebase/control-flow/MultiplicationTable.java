import java.util.Scanner;
class MultiplicationTable {
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int number=sc.nextInt();
      System.out.println("Multiplication table of " +number+ " from 6 to 9:");
      for(int i=6;i<=9;i++) {
         int product=number*i;
         System.out.println(number+" * "+i+" = "+product);
      }
      sc.close();
   }
}