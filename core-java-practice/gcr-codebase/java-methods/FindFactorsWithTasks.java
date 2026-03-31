import java.util.*;
public class FindFactorsWithTasks {

    // Method to find factors of a number and return them as an array
    public static int[] findFactors(int number) {
        int count=0;
        for(int i=1;i<=number;i++) {
            if(number%i==0) count++;
        }
        int[] factors=new int[count];
        int index=0;
        for(int i=1;i<=number;i++) {
            if(number%i==0) {
                factors[index]=i;
                index++;
            }
        }
        return factors;
    }

    // Method to find the greatest factor using the factors array
    public static int findGreatestFactor(int[] factors) {
        int greatest=factors[0];
        for(int i=1;i<factors.length;i++) {
            if(factors[i]>greatest) greatest=factors[i];
        }
        return greatest;
    }

    // Method to find the sum of the factors using factors array
    public static int findSumOfFactors(int[] factors) {
        int sum=0;
        for(int i=0;i<factors.length;i++) {
            sum=sum+factors[i];
        }
        return sum;
    }

    // Method to find the product of the factors using factors array
    public static long findProductOfFactors(int[] factors) {
        long product=1;
        for(int i=0;i<factors.length;i++) {
            product=product*factors[i];
        }
        return product;
    }

    // Method to find the product of the cube of the factors using the factors array
    public static long findProductOfCubeOfFactors(int[] factors) {
        long product=1;
        for(int i=0;i<factors.length;i++) {
            product=product*(long)Math.pow(factors[i],3);
        }
        return product;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        // User input
        System.out.print("Enter a number: ");
        int number=sc.nextInt();

        // Find factors
        int[] factors=findFactors(number);
        System.out.print("\nFactors of "+number+": ");
        for(int i=0;i<factors.length;i++) {
            System.out.print(factors[i]+" ");
        }
        System.out.println();

        // Find greatest factor
        int greatest=findGreatestFactor(factors);
        System.out.println("Greatest factor: "+greatest);

        // Find sum of factors
        int sum=findSumOfFactors(factors);
        System.out.println("Sum of factors: "+sum);

        // Find product of factors
        long product=findProductOfFactors(factors);
        System.out.println("Product of factors: "+product);

        // Find product of cube of factors
        long productOfCube=findProductOfCubeOfFactors(factors);
        System.out.println("Product of cube of factors: "+productOfCube);

        sc.close();
    }
}
