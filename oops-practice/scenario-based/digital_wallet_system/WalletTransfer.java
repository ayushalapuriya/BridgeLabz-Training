package digital_wallet_system;

public class WalletTransfer implements TransferService {

    public void transfer(Wallet sender, Wallet receiver, double amount)
            throws InsufficientBalanceException {

        if (sender.getBalance() < amount) {
            throw new InsufficientBalanceException("Wallet balance too low");
        }

        sender.withdrawMoney(amount);
        receiver.addMoney(amount);

        sender.recordTransaction("WALLET_TRANSFER_SENT", amount);
        receiver.recordTransaction("WALLET_TRANSFER_RECEIVED", amount);

        System.out.println("Wallet to wallet transfer successful");
    }
}
