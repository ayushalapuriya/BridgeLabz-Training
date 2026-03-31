package order_management_system;

public class PaymentFailedException extends Exception {
	PaymentFailedException(String msg){
		super(msg);
	}
}
