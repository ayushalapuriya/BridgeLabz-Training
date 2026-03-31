package digital_wallet_system;

public class BankTransfer implements TransferService {

    public void transfer(Wallet sender, Wallet receiver, double amount)
            throws InsufficientBalanceException {

        double bankFee = 10;

        if (sender.getBalance() < amount + bankFee) {
            throw new InsufficientBalanceException("Insufficient balance including bank charges");
        }

        sender.withdrawMoney(amount + bankFee);
        receiver.addMoney(amount);

        sender.recordTransaction("BANK_TRANSFER_SENT", amount);
        receiver.recordTransaction("BANK_TRANSFER_RECEIVED", amount);

        System.out.println("Bank transfer successful with fee " + bankFee);
    }
}
