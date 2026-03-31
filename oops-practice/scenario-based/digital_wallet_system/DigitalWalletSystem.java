package digital_wallet_system;

public class DigitalWalletSystem {

    public static void main(String[] args) {

        try {
            User user1 = new User(1, "Ayush");
            User user2 = new User(2, "Rahul");

            Wallet wallet1 = user1.getWallet();
            Wallet wallet2 = user2.getWallet();

            wallet1.addMoney(5000);
            wallet2.addMoney(2000);

            wallet1.withdrawMoney(1000);

            TransferService walletTransfer = new WalletTransfer();
            TransferService bankTransfer = new BankTransfer();

            wallet1.transfer(1500, wallet2, walletTransfer);
            wallet2.transfer(1000, wallet1, bankTransfer);

            wallet1.displayTransactions();
            wallet2.displayTransactions();

        } catch (InsufficientBalanceException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}
