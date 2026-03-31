
// Loanable interface - defines contract for loan operations
interface Loanable{
	void applyForLoan(double amount);
	boolean calculateLoanEligibility();
}

// Abstract BankAccount class
abstract class BankAccount{
	private String accountNumber;
	private String holderName;
	private double balance;
	
	// Setter for account number
	public void setAccountNumber(String accountNumber) {
		this.accountNumber=accountNumber;
	}
	
	// Setter for holder name
	public void setHolderName(String holderName) {
		this.holderName=holderName;
	}
	
	// Setter for balance
	public void setBalance(double balance) {
		this.balance=balance;
	}
	
	// Getter for account number
	public String getAccountNumber() {
		return this.accountNumber;
	}
	
	// Getter for holder name
	public String getHolderName() {
		return this.holderName;
	}
	
	// Getter for balance
	public double getBalance() {
		return this.balance;
	}
	
	BankAccount(String accountNumber,String holderName,double balance){
		setAccountNumber(accountNumber);
		setHolderName(holderName);
		setBalance(balance);
	}
	
	// Concrete method to deposit money
	void deposit(double amount) {
		if(amount>0) {
			setBalance(getBalance()+amount);
			System.out.println("Deposited: Rs."+amount);
			System.out.println("New Balance: Rs."+getBalance());
		}else {
			System.out.println("Invalid deposit amount!");
		}
	}
	
	// Concrete method to withdraw money
	void withdraw(double amount) {
		if(amount>0 && amount<=getBalance()) {
			setBalance(getBalance()-amount);
			System.out.println("Withdrawn: Rs."+amount);
			System.out.println("New Balance: Rs."+getBalance());
		}else {
			System.out.println("Insufficient balance or invalid amount!");
		}
	}
	
	// Abstract method - must be implemented by subclasses
	abstract double calculateInterest();
	
	// Concrete method to display account details
	void displayDetails() {
		System.out.println("Account Number: "+getAccountNumber());
		System.out.println("Holder Name: "+getHolderName());
		System.out.println("Balance: Rs."+getBalance());
	}
}

// SavingsAccount class - implements Loanable interface
class SavingsAccount extends BankAccount implements Loanable{
	private double interestRate=0.04;
	SavingsAccount(String accountNumber,String holderName,double balance){
		super(accountNumber,holderName,balance);
	}
	
	@Override
	double calculateInterest() {
		return getBalance()*interestRate;
	}
	public void applyForLoan(double amount) {
		if(calculateLoanEligibility()) {
			System.out.println("Loan of Rs."+amount+" approved for Savings Account!");
		}else {
			System.out.println("Loan application rejected. Insufficient balance.");
		}
    }
	public boolean calculateLoanEligibility() {
		return getBalance()>=50000;
    }
}

// CurrentAccount class - implements Loanable interface
class CurrentAccount extends BankAccount implements Loanable{
	private double interestRate=0.02;
	CurrentAccount(String accountNumber,String holderName,double balance){
		super(accountNumber,holderName,balance);
	}
	
	@Override
	double calculateInterest() {
		return getBalance()*interestRate;
	}	
	public void applyForLoan(double amount) {
		if(calculateLoanEligibility()) {
			System.out.println("Loan of Rs."+amount+" approved for Current Account!");
		}else {
			System.out.println("Loan application rejected. Insufficient balance.");
		}
	}
	public boolean calculateLoanEligibility() {
		return getBalance()>=100000;
	}
}

public class BankingSystem {
	public static void main(String[] args) {
		// Creating bank account objects
		SavingsAccount savings=new SavingsAccount("SA001","Ayush Kumar",80000);
		CurrentAccount current=new CurrentAccount("CA001","Prateek Singh",150000);
		
		// Polymorphism: Processing accounts using BankAccount reference
		BankAccount[] accounts={savings,current};
		
		for(int i=0;i<accounts.length;i++) {
			System.out.println("Account "+(i+1)+":");
			accounts[i].displayDetails();
			System.out.println("Interest Amount: Rs."+accounts[i].calculateInterest());
			
			// Testing deposit and withdraw
			accounts[i].deposit(5000);
			accounts[i].withdraw(2000);
			
			// Access interface method using downcasting
			if(accounts[i] instanceof Loanable) {
				Loanable loanableAccount=(Loanable)accounts[i];
				System.out.println("Loan Eligible: "+loanableAccount.calculateLoanEligibility());
				loanableAccount.applyForLoan(20000);
			}
			System.out.println();
		}
	}
}
