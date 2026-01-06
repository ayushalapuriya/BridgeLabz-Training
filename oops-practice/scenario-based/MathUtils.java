
public class MathUtils {

    private int number;

    // Constructor to set the number
    public MathUtils(int number){
        this.number=number;
    }

    // Calculate factorial of the number
    public long factorial(){
        if(number<0) throw new IllegalArgumentException("Factorial not defined for negative numbers");
        long result=1;
        for(int i=2;i<=number;i++) result*=i;
        return result;
    }

    // Check if the number is prime
    public boolean isPrime(){
        if(number<=1) return false;
        for(int i=2;i*i<=number;i++) if(number%i==0) return false;
        return true;
    }

    // Find GCD of two numbers using Euclidean algorithm
    public static int gcd(int a,int b){
        while(b!=0){
            int temp=b;
            b=a%b;
            a=temp;
        }
        return Math.abs(a);
    }

    // Find nth Fibonacci number
    public long fibonacci(){
        if(number<0) throw new IllegalArgumentException("Fibonacci not defined for negative numbers");
        if(number==0) return 0;
        if(number==1) return 1;
        long a=0,b=1,c=0;
        for(int i=2;i<=number;i++){
            c=a+b;
            a=b;
            b=c;
        }
        return c;
    }

    public static void main(String[] args){
        // Create MathUtils objects with different numbers
        MathUtils num5=new MathUtils(5);
        MathUtils num0=new MathUtils(0);
        MathUtils num10=new MathUtils(10);
        MathUtils num13=new MathUtils(13);

        // Test factorial
        System.out.println("Factorial of 0: "+num0.factorial()); // 1
        System.out.println("Factorial of 5: "+num5.factorial()); // 120

        // Test prime
        System.out.println("Is 0 prime? "+num0.isPrime()); // false
        System.out.println("Is 13 prime? "+num13.isPrime()); // true

        // Test GCD
        System.out.println("GCD of 54 and 24: "+MathUtils.gcd(54,24)); // 6
        System.out.println("GCD of -54 and 24: "+MathUtils.gcd(-54,24)); // 6

        // Test Fibonacci
        System.out.println("Fibonacci of 0: "+num0.fibonacci()); // 0
        System.out.println("Fibonacci of 10: "+num10.fibonacci()); // 55
    }
}
