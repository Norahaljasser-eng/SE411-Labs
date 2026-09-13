package edu.psu.se411.wallet;

import edu.psu.se411.exception.InsufficientFundsException;

public class WalletAccount {

    private double balance;

    public WalletAccount(double balance) {
        if (!Double.isFinite(balance) || balance < 0) {
            throw new IllegalArgumentException("Invalid starting balance.");
        }
        this.balance = balance;
    }

    public void withdraw(double amount) throws InsufficientFundsException {
        if (!Double.isFinite(amount) || amount <= 0) {
            throw new IllegalArgumentException(
                "Withdrawal amount must be a positive, finite number.");
        }

        if (amount > balance) {
            throw new InsufficientFundsException(
                "Insufficient funds. Available balance: " + balance);
        }

        balance -= amount;
        System.out.println("Transferred to bank account: " + amount);
    }

    public double getBalance() {
        return balance;
    }
}