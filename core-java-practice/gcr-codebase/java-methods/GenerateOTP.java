import java.util.*;
public class GenerateOTP {

    // Method to generate a 6-digit OTP number using Math.random()
    public static int generateOTP() {
        int otp=(int)(Math.random()*900000)+100000;
        return otp;
    }

    // Method to ensure that the OTP numbers generated are unique
    public static boolean areOTPsUnique(int[] otps) {
        for(int i=0;i<otps.length;i++) {
            for(int j=i+1;j<otps.length;j++) {
                if(otps[i]==otps[j]) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] otps=new int[10];

        // Generate OTP 10 times and store in array
        System.out.println("Generating 10 OTP numbers:");
        for(int i=0;i<10;i++) {
            otps[i]=generateOTP();
            System.out.println("OTP "+(i+1)+": "+otps[i]);
        }

        // Validate if all OTPs are unique
        boolean isUnique=areOTPsUnique(otps);
        System.out.println("\nValidation Result:");
        if(isUnique) System.out.println("All OTP numbers are unique");
        else System.out.println("Some OTP numbers are duplicate");
    }
}
