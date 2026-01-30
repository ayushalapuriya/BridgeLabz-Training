package com.example.junit_practice;

public class BankAccount {

    private double balance;

    public BankAccount(double initialBalance) {
        if (initialBalance < 0) throw new IllegalArgumentException("Initial balance cannot be negative");
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        if (amount < 0) throw new IllegalArgumentException("Deposit cannot be negative");
        balance += amount;
    }

    public void withdraw(double amount) {
        if (amount < 0) throw new IllegalArgumentException("Withdrawal cannot be negative");
        if (amount > balance) throw new IllegalArgumentException("Insufficient funds");
        balance -= amount;
    }

    public double getBalance() {
        return balance;
    }
}
