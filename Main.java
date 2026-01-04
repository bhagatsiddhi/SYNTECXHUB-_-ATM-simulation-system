import java.util.Scanner;
import java.util.ArrayList;

public class ATM {

    static double balance = 5000;
    static int pin = 1234;
    static ArrayList<String> history = new ArrayList<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int attempts = 3;

        while (attempts > 0) {
            System.out.print("Enter PIN: ");
            int enteredPin = sc.nextInt();

            if (enteredPin == pin) {
                break;
            } else {
                attempts--;
                System.out.println("Wrong PIN! Attempts left: " + attempts);
            }
        }

        if (attempts == 0) {
            System.out.println("Card Blocked!");
            return;
        }

        int choice;
        do {
            System.out.println("\n===== ATM MENU =====");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Transaction History");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Balance: ₹" + balance);
                    break;

                case 2:
                    System.out.print("Enter amount: ");
                    double dep = sc.nextDouble();
                    if (dep > 0) {
                        balance += dep;
                        history.add("Deposited ₹" + dep);
                        System.out.println("Deposit Successful");
                    } else {
                        System.out.println("Invalid amount");
                    }
                    break;

                case 3:
                    System.out.print("Enter amount: ");
                    double wit = sc.nextDouble();
                    if (wit > 0 && wit <= balance) {
                        balance -= wit;
                        history.add("Withdrawn ₹" + wit);
                        System.out.println("Withdrawal Successful");
                    } else {
                        System.out.println("Insufficient balance");
                    }
                    break;

                case 4:
                    if (history.isEmpty()) {
                        System.out.println("No transactions yet");
                    } else {
                        System.out.println("Transaction History:");
                        for (String h : history) {
                            System.out.println(h);
                        }
                    }
                    break;

                case 5:
                    System.out.println("Thank you for using ATM");
                    break;

                default:
                    System.out.println("Invalid choice");
            }

        } while (choice != 5);

        sc.close();
    }
}
