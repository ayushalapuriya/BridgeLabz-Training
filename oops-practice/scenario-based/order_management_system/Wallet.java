package order_management_system;

public class Wallet implements Payment {
    @Override
    public boolean payAmount(double amount) throws PaymentFailedException {
        if(amount <= 0) {
            throw new PaymentFailedException("Amount must be greater than zero!");
        }
        System.out.println("Paid "+amount+" using Wallet.");
        return true;
    }
}
