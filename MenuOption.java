import java.util.HashMap;
import java.util.Scanner;
import java.util.Map.Entry;

/*
 * MenuOption
 */

public class MenuOption extends Account {
    Scanner sc = new Scanner(System.in);

    HashMap<Integer, Integer> details = new HashMap<Integer, Integer>();

    /* Check Login Information Account Number and Pin Number */

    public void login() {
        boolean checkLogin = true;

        do {
            try {
                details.put(123456789, 12345);
                details.put(987654321, 98765);

                System.out.println("Welcome to the ATM Machine!");

                System.out.println("Enter Your Account Number : ");
                setAccountNumber(sc.nextInt());

                System.out.println("Enter Your Pin Number : ");
                setPinNumber(sc.nextInt());
            } catch (Exception e) {
                // TODO: handle exception
                System.out.println("\nPLease enter only numbers\n");
                checkLogin = false;
            }
            for (Entry<Integer, Integer> entry : details.entrySet()) {
                if (entry.getKey() == getAccountNumber() && entry.getValue() == getPinNumber()) {
                    getAccountType();
                    checkLogin = true;
                } else {
                    checkLogin = false;
                }
            }
            if (!checkLogin) {
                System.out.println("\nWrong Account Number or Pin Number.\n");
            }
        } while (checkLogin);
    }

    /* Account Type Menu */

    public void getAccountType() {
        System.out.println("Select Account you want to access : ");
        System.out.println("Type - 1 : Current Account");
        System.out.println("Type - 2 : Saving Account");
        System.out.println("Type - 3 : Exit");
        System.out.println("Enter Your Choice : ");
        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                getAccountType();
                break;
            case 2:
                getSavingAccount();
                break;
            case 3:
                System.out.println("Thank you for using this ATM!");
                break;

            default:
                System.out.println("\nInvalid Choice\n");
                break;
        }
    }

    /* Current Account Menu */
    public void getCurrentAccount() {
        System.out.println("Current Account : ");
        System.out.println("Type - 1 : Check Balance");
        System.out.println("Type - 2 : Withdraw Amount");
        System.out.println("Type - 3 : Deposit Amount");
        System.out.println("Type - 4 : Exit");
        System.out.println("Enter your choice : ");
        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                System.out.println("Current Account Balance : " + moneyFormat.format(getCurrentAccountBalance()));
                getAccountType();
                break;
            case 2:
                getCurrentWithdrawInput();
                getAccountType();
                break;
            case 3:
                getCurrentDepositInput();
                getAccountType();
                break;
            case 4:
                System.out.println("Thank you for using this ATM!");
                break;

            default:
                System.out.println("\nInvalid Choice\n");
                break;
        }
    }

    /* Saving Account Menu */
    public void getSavingAccount() {
        System.out.println("Saving Account : ");
        System.out.println("Type - 1 : Check Balance");
        System.out.println("Type - 2 : Withdraw Amount");
        System.out.println("Type - 3 : Deposit Amount");
        System.out.println("Type - 4 : Exit");
        System.out.println("Enter Your Choice : ");
        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                System.out.println("Saving Account Balance : " + moneyFormat.format(getSavingAccountBalance()));
                getAccountType();
                break;
            case 2:
                getSavingWithdrawInput();
                getAccountType();
                break;
            case 3:
                getSavingDepositInput();
                getAccountType();
                break;
            case 4:
                System.out.println("Thank you for using this ATM!");
                break;
            default:
                System.out.println("\nInvalid Choice\n");
                getCurrentAccount();
                break;
        }
    }
}
