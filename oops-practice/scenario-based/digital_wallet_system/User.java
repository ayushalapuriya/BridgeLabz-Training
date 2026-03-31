package digital_wallet_system;

public class User {
    private int userId;
    private String name;
    private Wallet wallet;

    User(int userId, String name) {
        this.userId = userId;
        this.name = name;
        this.wallet = new Wallet(this);
    }

    Wallet getWallet() {
        return wallet;
    }

    String getName() {
        return name;
    }
}
