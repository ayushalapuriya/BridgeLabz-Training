
// Super class
class BankAccount{
	String accountNumber;
	double balance;
	BankAccount(String accountNumber,double balance){
		this.accountNumber=accountNumber;
		this.balance=balance;
	}
	void displayAccountType(){
		System.out.println("Account Number: "+accountNumber);
		System.out.println("Balance: Rs. "+balance);
		System.out.println();
	}
}

// Subclass SavingsAccount - inherits from BankAccount
class SavingsAccount extends BankAccount{
	double interestRate;
	SavingsAccount(String accountNumber,double balance,double interestRate){
		super(accountNumber,balance);
		this.interestRate=interestRate;
	}
	// Method overriding
	void displayAccountType(){
		System.out.println("Account Type: Savings Account");
		System.out.println("Account Number: "+accountNumber);
		System.out.println("Balance: Rs. "+balance);
		System.out.println("Interest Rate: "+interestRate+"%");
		System.out.println();
	}
}

// Subclass CheckingAccount - inherits from BankAccount
class CheckingAccount extends BankAccount{
	double withdrawalLimit;
	CheckingAccount(String accountNumber,double balance,double withdrawalLimit){
		super(accountNumber,balance);
		this.withdrawalLimit=withdrawalLimit;
	}
	// Method overriding
	void displayAccountType(){
		System.out.println("Account Type: Checking Account");
		System.out.println("Account Number: "+accountNumber);
		System.out.println("Balance: Rs. "+balance);
		System.out.println("Withdrawal Limit: Rs. "+withdrawalLimit);
		System.out.println();
	}
}

// Subclass FixedDepositAccount - inherits from BankAccount
class FixedDepositAccount extends BankAccount{
	int maturityPeriod;
	FixedDepositAccount(String accountNumber,double balance,int maturityPeriod){
		super(accountNumber,balance);
		this.maturityPeriod=maturityPeriod;
	}
	// Method overriding
	void displayAccountType(){
		System.out.println("Account Type: Fixed Deposit Account");
		System.out.println("Account Number: "+accountNumber);
		System.out.println("Balance: Rs. "+balance);
		System.out.println("Maturity Period: "+maturityPeriod+" months");
		System.out.println();
	}
}

public class BankAccountTypes{
	public static void main(String[] args){
		// Creating objects and demonstrating hierarchical inheritance
		SavingsAccount savings=new SavingsAccount("SA001",50000,4.5);
		CheckingAccount checking=new CheckingAccount("CA001",30000,10000);
		FixedDepositAccount fd=new FixedDepositAccount("FD001",100000,24);
		
		System.out.println("=== Bank Account Types ===");
		System.out.println();
		
		savings.displayAccountType();
		checking.displayAccountType();
		fd.displayAccountType();
	}
}
