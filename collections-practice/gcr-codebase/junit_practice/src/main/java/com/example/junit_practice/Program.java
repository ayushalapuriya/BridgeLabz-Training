package com.example.junit_practice;

public class Program {
    private double balance;

    public Program(double initialBalance) {
        balance=initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if(amount<0) {
            throw new RuntimeException("Deposit amount cannot be negative");
        }
        balance+=amount;
    }

    public void withdraw(double amount) {
        if(amount>balance) {
            throw new RuntimeException("Insufficient funds.");
        }
        balance-=amount;
    }
}