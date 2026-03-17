package M1Question.SET1;

import java.util.Scanner;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Q1ShipmentValidate {

    static boolean validCode(String code){
        if(!code.matches("SHIP-[1-9][0-9]{5}")) return false;
        String digits = code.substring(5);
        int count=1;
        for(int i=1;i<6;i++){
            if(digits.charAt(i)==digits.charAt(i-1)){
                count++;
                if(count>3) return false;
            }
            else count = 1;
        }
        return true;
    }

    static boolean validDate(String date) {
        try {
            String[] parts = date.split("-");
            int year = Integer.parseInt(parts[0]);
            int month = Integer.parseInt(parts[1]);
            int day = Integer.parseInt(parts[2]);

            if (year < 2000 || year > 2099) return false;
            if (month < 1 || month > 12) return false;

            int[] daysInMonth = {31,28,31,30,31,30,31,31,30,31,30,31};
            if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) daysInMonth[1] = 29;
            if (day < 1 || day > daysInMonth[month - 1]) return false;
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    static boolean validMode(String mode) {
        Set<String> modes = new HashSet<>(Arrays.asList(
                "AIR", "SEA", "ROAD", "RAIL", "EXPRESS", "FREIGHT"
        ));
        return modes.contains(mode);
    }

    static boolean validWeight(String weight) {
        if (!weight.matches("(0|[1-9][0-9]{0,5})(\\.[0-9]{1,2})?"))
            return false;

        double w = Double.parseDouble(weight);
        return w > 0 && w <= 999999.99;
    }

    static boolean validStatus(String status) {
        return status.equals("DELIVERED")
                || status.equals("CANCELLED")
                || status.equals("IN_TRANSIT");
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        while(n-->0){
            String input = sc.next();
            String[]parts = input.split("\\|");
            if(parts.length < 5){
                System.out.println("NON-COMPLIANT RECORD");
                continue;
            }

            if(validCode(parts[0]) && validDate(parts[1]) && validMode(parts[2]) && validWeight(parts[3]) && validStatus(parts[4])) System.out.println("COMPLIANT RECORD");
            else System.out.println("NON-COMPLIANT RECORD");
        }
    }
}
