package bank_account_hierarchy;

public class Main {
	public static void main(String[] args) {
		BankAccount savings = new SavingsAccount("12345", 1000.0);
		System.out.printf("%.2f%n", savings.calculateFee());
		
		BankAccount savings2 = new SavingsAccount("12635", 500.0);
		System.out.printf("%.2f%n", savings2.calculateFee());
		
		BankAccount check = new CheckingAccount("12845", 1000.0);
		System.out.printf("%.2f%n", check.calculateFee());

		BankAccount check2 = new CheckingAccount("12845", 500.0);
		System.out.printf("%.2f%n", check2.calculateFee());
	}
}
