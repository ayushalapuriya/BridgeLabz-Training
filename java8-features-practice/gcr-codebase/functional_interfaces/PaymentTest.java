interface PaymentProcessor {
    void pay(double amount);
    default void refund(double amount) {
        System.out.println("Refund processed: $" + amount);
    }
}

class PayPalProcessor implements PaymentProcessor {
    public void pay(double amount) {
        System.out.println("Paid via PayPal: $" + amount);
    }
}

public class PaymentTest {
    public static void main(String[] args) {
        PaymentProcessor pp = new PayPalProcessor();
        pp.pay(100);
        pp.refund(50);
    }
}
