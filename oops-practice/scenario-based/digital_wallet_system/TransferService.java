package digital_wallet_system;

public interface TransferService {
    void transfer(Wallet sender, Wallet receiver, double amount)
            throws InsufficientBalanceException;
}
