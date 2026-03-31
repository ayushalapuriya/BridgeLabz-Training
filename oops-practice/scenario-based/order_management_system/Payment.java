package order_management_system;

public interface Payment {
	boolean payAmount(double amount) throws PaymentFailedException;
}
