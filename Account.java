/*
 * Account
 */

import java.text.DecimalFormat;
import java.util.Scanner;

public class Account {
    private int accountNumber, pinNumber;
    private double currentAccountBalance = 0, savingAccountBalance = 0;
    Scanner sc = new Scanner(System.in);
    DecimalFormat moneyFormat = new DecimalFormat("'$'0.00");

    /* Set Account Number */
    public int setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
        return accountNumber;
    }

    /* Get Account NUmber */
    public int getAccountNumber() {
        return accountNumber;
    }

    /* Set Pin Number */
    public int setPinNumber(int pinNumber) {
        this.pinNumber = pinNumber;
        return pinNumber;
    }

    /* Get Pin Number */
    public int getPinNumber() {
        return pinNumber;
    }

    /* Current Account Balance */
    public double getCurrentAccountBalance() {
        return currentAccountBalance;
    }

    /* Saving Account Balance */
    public double getSavingAccountBalance() {
        return savingAccountBalance;
    }

    /* Calculate Current Account Withdraw */
    public double calcCurrentAccountWithdraw(double amount) {
        currentAccountBalance -= amount;
        return currentAccountBalance;
    }

    /* Calculate Saving Account Withdraw */
    public double calcSavingAccountWithdraw(double amount) {
        savingAccountBalance -= amount;
        return savingAccountBalance;
    }

    /* Calculate Current Account Deposit */
    public double calcCurrentAccountDeposit(double amount) {
        currentAccountBalance += amount;
        return currentAccountBalance;
    }

    /* Calculate Saving Account Deposit */
    public double calcSavingAccountDeposit(double amount) {
        savingAccountBalance += amount;
        return savingAccountBalance;
    }

    /* Current Account Withdraw Input */
    public void getCurrentWithdrawInput() {
        System.out.println("Current Account Balance : " + moneyFormat.format(currentAccountBalance));
        System.out.print("Enter Amount you want to withdraw from Current Account : ");
        double amount = sc.nextDouble();

        if ((currentAccountBalance - amount) >= 0) {
            calcCurrentAccountWithdraw(amount);
            System.out.println("New Current Account Balance :" + moneyFormat.format(currentAccountBalance));
        } else {
            System.out.println("\nInsufficient Balance\n");
        }
    }

    /* Saving Account Withdraw Input */
    public void getSavingWithdrawInput() {
        System.out.println("Saving Account Balance : " + moneyFormat.format(savingAccountBalance));
        System.out.print("Enter Amount you want to withdraw from Saving Account : ");
        double amount = sc.nextDouble();

        if ((savingAccountBalance - amount) >= 0) {
            calcSavingAccountWithdraw(amount);
            System.out.println("New Saving Account Balance : " + moneyFormat.format(savingAccountBalance));
        } else {
            System.out.println("\nInsufficient Balance.\n");
        }
    }

    /* Current Account Deposit Input */
    public void getCurrentDepositInput() {
        System.out.println("Current Account Balance : " + moneyFormat.format(currentAccountBalance));
        System.out.print("Enter Amount You want to deposit from current Account : ");
        double amount = sc.nextDouble();

        if ((currentAccountBalance + amount) >= 0) {
            calcCurrentAccountDeposit(amount);
            System.out.println("New Current Account Balance : " + moneyFormat.format(currentAccountBalance));
        } else {
            System.out.println("\nBalance can't be negative.\n");
        }
    }

    /* Saving Account Deposit Input */
    public void getSavingDepositInput() {
        System.out.println("Saving Account Balance : " + moneyFormat.format(savingAccountBalance));
        System.out.print("Enter Amount you want to deposit from Saving Account : ");
        double amount = sc.nextDouble();

        if ((savingAccountBalance + amount) >= 0) {
            calcSavingAccountDeposit(amount);
            System.out.println("New Saving Account Balance : " + moneyFormat.format(savingAccountBalance));
        } else {
            System.out.println("\nBalance cant't be negative.\n");
        }
    }
}