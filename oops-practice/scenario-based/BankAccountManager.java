import java.util.Scanner;

// BankAccount class using OOP concepts
class BankAccount {
    private String accountNumber;
    private double balance;

    public BankAccount(String accountNumber,double balance) {
        this.accountNumber=accountNumber;
        this.balance=balance;
    }

    // Deposit money
    public void deposit(double amount) {
        if(amount>0) {
            balance+=amount;
            System.out.println("Deposited: "+amount);
        } else {
            System.out.println("Invalid deposit amount");
        }
    }

    // Withdraw money with overdraft prevention
    public void withdraw(double amount) {
        if(amount>balance) {
            System.out.println("Insufficient balance! Withdrawal failed.");
        } else if(amount<=0) {
            System.out.println("Invalid withdrawal amount");
        } else {
            balance-=amount;
            System.out.println("Withdrawn: "+amount);
        }
    }

    // Check balance
    public void checkBalance() {
        System.out.println("Account: "+accountNumber+", Current Balance: "+balance);
    }

    // Getter for account number
    public String getAccountNumber() {
        return accountNumber;
    }

    // Getter for balance
    public double getBalance() {
        return balance;
    }
}

public class BankAccountManager {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        System.out.print("Enter Account Number: ");
        String accNo=sc.nextLine();
        System.out.print("Enter Initial Balance: ");
        double initBalance=sc.nextDouble();

        BankAccount account=new BankAccount(accNo,initBalance); // Create object

        while(true) {
            System.out.println("\n=== Bank Menu ===");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            int choice=sc.nextInt();

            switch(choice) {
                case 1:
                    System.out.print("Enter amount to deposit: ");
                    account.deposit(sc.nextDouble());
                    break;
                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    account.withdraw(sc.nextDouble());
                    break;
                case 3:
                    account.checkBalance();
                    break;
                case 4:
                    System.out.println("Thank you for using Bank Account Manager!");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please select 1-4");
            }
        }
    }
}
