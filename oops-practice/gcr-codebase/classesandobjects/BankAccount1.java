
public class BankAccount1 {
	
	// Access modifiers
	public String accountNumber;
	protected String accountHolder;
	private double balance;
	
	// Constructor
	BankAccount1(String accountNumber,String accountHolder,double balance){
		this.accountNumber=accountNumber;
		this.accountHolder=accountHolder;
		this.balance=balance;
	}
	
	// Public method to get balance
	public double getBalance(){
		return balance;
	}
	
	// Public method to deposit money
	public void deposit(double amount){
		if(amount>0){
			balance=balance+amount;
			System.out.println("Deposited: "+amount);
			System.out.println("Current Balance: "+balance);
		}else{
			System.out.println("Invalid deposit amount");
		}
	}
	
	// Public method to withdraw money
	public void withdraw(double amount){
		if(amount>0&&balance>=amount){
			balance=balance-amount;
			System.out.println("Withdrawn: "+amount);
			System.out.println("Current Balance: "+balance);
		}else{
			System.out.println("Insufficient balance or invalid amount");
		}
	}
	
	// Method to display account details
	public void display(){
		System.out.println("Account Number: "+accountNumber);
		System.out.println("Account Holder: "+accountHolder);
		System.out.println("Balance: "+balance);
		System.out.println("--------------------------");
	}
}

// Subclass to demonstrate protected access
class SavingsAccount extends BankAccount1{
	
	double interestRate;
	
	// Constructor
	SavingsAccount(String accountNumber,String accountHolder,double balance,double interestRate){
		super(accountNumber,accountHolder,balance);
		this.interestRate=interestRate;
	}
	
	// Method to calculate interest
	public void calculateInterest(){
		double interest=getBalance()*interestRate/100;
		System.out.println("Interest earned: "+interest);
		deposit(interest);
	}
	
	// Method to display savings account details
	public void display(){
		System.out.println("Account Number: "+accountNumber);
		System.out.println("Account Holder: "+accountHolder);
		System.out.println("Balance: "+getBalance());
		System.out.println("Interest Rate: "+interestRate+"%");
		System.out.println("--------------------------");
	}
	
	// Method to demonstrate protected access
	public void displayProtectedAccountHolder(){
		System.out.println("Accessing protected accountHolder from subclass: "+accountHolder);
	}
	
	public static void main(String[] args) {
		BankAccount1 account=new BankAccount1("ACC12345","Rajesh Kumar",10000.0);
		System.out.println("Regular Bank Account:");
		account.display();
		
		System.out.println("Accessing public member directly: "+account.accountNumber);
		System.out.println("Accessing private member through getter: "+account.getBalance());
		account.deposit(5000.0);
		account.withdraw(2000.0);
		System.out.println();
		
		SavingsAccount savings=new SavingsAccount("SAV67890","Priya Sharma",20000.0,5.0);
		System.out.println("Savings Account:");
		savings.display();
		savings.displayProtectedAccountHolder();
		savings.calculateInterest();
	}
}
