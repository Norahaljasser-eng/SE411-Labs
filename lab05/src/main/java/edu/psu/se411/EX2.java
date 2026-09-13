package edu.psu.se411;

import edu.psu.se411.wallet.WalletAccount;
import edu.psu.se411.exception.InsufficientFundsException;

public class EX2 {

    public static void main(String[] args) {
        WalletAccount wallet = new WalletAccount(500);

        try {
            wallet.withdraw(200);
            System.out.println("Remaining balance: " + wallet.getBalance());

            wallet.withdraw(400);
        } catch (InsufficientFundsException e) {
            System.out.println(e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Final balance: " + wallet.getBalance());
    }
}