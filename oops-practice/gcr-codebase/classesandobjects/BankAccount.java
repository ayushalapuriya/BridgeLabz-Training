
public class BankAccount {
	
	// Attributes
	String accountHolder;
	String accountNumber;
	double balance;
	
	// Constructor
	BankAccount(String accountHolder,String accountNumber,double balance){
		this.accountHolder=accountHolder;
		this.accountNumber=accountNumber;
		this.balance=balance;
	}
	
	// Method to deposit money
	void deposit(double amount){
		balance=balance+amount;
		System.out.println("Deposited: "+amount);
	}
	
	// Method to withdraw money
	void withdraw(double amount){
		if(balance>=amount){
			balance=balance-amount;
			System.out.println("Withdraw amount is : "+amount);
		}else{
			System.out.println("Insufficient balance");
		}
	}
	
	// Method to display current balance
	void displayBalance(){
		System.out.println("Current balance: "+balance);
	}
	
	public static void main(String[] args) {
		System.out.println("State of Chennai");
		System.out.println();
		
		BankAccount account=new BankAccount("Ramesh","ACC12345",700.0);
		
		account.displayBalance();
		account.deposit(200.0);
		account.displayBalance();
		account.withdraw(100.0);
		account.displayBalance();
		account.withdraw(1000.0);
	}
}
