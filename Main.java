import java.util.Scanner;

class ATM {

    int balance = 10000;   // default balance
    int pin = 1234;        // default ATM pin

    void checkBalance() {
        System.out.println("Current Balance: " + balance);
    }

    void deposit(int amount) {
        balance = balance + amount;
        System.out.println("Amount Deposited Successfully");
    }

    void withdraw(int amount) {
        if (amount > balance) {
            System.out.println("Insufficient Balance");
        } else {
            balance = balance - amount;
            System.out.println("Please collect cash");
        }
    }
}

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ATM user = new ATM();

        int attempts = 3;
        boolean login = false;

        while (attempts > 0) {
            System.out.print("Enter ATM PIN: ");
            int enteredPin = sc.nextInt();

            if (enteredPin == user.pin) {
                login = true;
                break;
            } else {
                attempts--;
                System.out.println("Wrong PIN. Attempts left: " + attempts);
            }
        }

        if (!login) {
            System.out.println("ATM Card Blocked");
            return;
        }

        int choice;

        do {
            System.out.println("\n1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    user.checkBalance();
                    break;

                case 2:
                    System.out.print("Enter amount to deposit: ");
                    int dep = sc.nextInt();
                    user.deposit(dep);
                    break;

                case 3:
                    System.out.print("Enter amount to withdraw: ");
                    int wd = sc.nextInt();
                    user.withdraw(wd);
                    break;

                case 4:
                    System.out.println("Thank you for using ATM");
                    break;

                default:
                    System.out.println("Invalid Choice");
            }

        } while (choice != 4);

        sc.close();
    }
}
