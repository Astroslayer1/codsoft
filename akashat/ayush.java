import java.util.Scanner;

public class ATMApp {
f
    // Bank account class
    static class BankAccount {
        private double balance;

        public BankAccount(double initialBalance) {
            this.balance = initialBalance;
        }

        public void deposit(double amount) {
            if (amount > 0) {
                balance += amount;
                System.out.println("✅ Deposited: $" + amount);
            } else {
                System.out.println("❌ Deposit amount must be positive.");
            }
        }

        public void withdraw(double amount) {
            if (amount <= 0) {
                System.out.println("❌ Withdrawal amount must be positive.");
            } else if (amount > balance) {
                System.out.println("❌ Insufficient balance.");
            } else {
                balance -= amount;
                System.out.println("✅ Withdrew: $" + amount);
            }
        }

        public void checkBalance() {
            System.out.println("💰 Current Balance: $" + balance);
        }
    }

    // ATM interface class
    static class ATM {
        private BankAccount account;
        private Scanner scanner;

        public ATM(BankAccount account) {
            this.account = account;
            this.scanner = new Scanner(System.in);
        }

        public void showMenu() {
            while (true) {
                System.out.println("\n=== ATM Menu ===");
                System.out.println("1. Check Balance");
                System.out.println("2. Deposit");
                System.out.println("3. Withdraw");
                System.out.println("4. Exit");
                System.out.print("Choose an option: ");

                if (!scanner.hasNextInt()) {
                    System.out.println("⚠ Invalid input. Please enter a number.");
                    scanner.next(); // clear invalid input
                    continue;
                }

                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        account.checkBalance();
                        break;
                    case 2:
                        System.out.print("Enter deposit amount: ");
                        double depositAmount = scanner.nextDouble();
                        account.deposit(depositAmount);
                        break;
                    case 3:
                        System.out.print("Enter withdrawal amount: ");
                        double withdrawAmount = scanner.nextDouble();
                        account.withdraw(withdrawAmount);
                        break;
                    case 4:
                        System.out.println("👋 Thank you for using the ATM. Goodbye!");
                        return;
                    default:
                        System.out.println("⚠ Invalid option. Please try again.");
                }
            }
        }
    }

    // Main method to run the program
    public static void main(String[] args) {
        BankAccount userAccount = new BankAccount(500.0); // starting balance
        ATM atm = new ATM(userAccount);
        atm.showMenu();
    }
}