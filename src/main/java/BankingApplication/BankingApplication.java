package BankingApplication;

import java.util.Scanner;

public class BankingApplication {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Select Bank: 1. Nationalized 2. Cooperative");
        int bankChoice = sc.nextInt();
        sc.nextLine();
        Bank bank = (bankChoice == 1)
            ? new NationalizedBank("SBI", "CG")
            : new CooperativeBank("CoopBank", "CG");

        System.out.println("Select Account Type: 1. Savings 2. Current 3. Loan");
        int accType = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Holder Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Initial Deposit: ");
        double deposit = sc.nextDouble();

        String accNum = "ACC" + ((int)(Math.random()*900) + 100);
        Account account = null;
        switch (accType) {
            case 1: account = new SavingsAccount(accNum, name, deposit); break;
            case 2: account = new CurrentAccount(accNum, name, deposit); break;
            case 3: account = new LoanAccount(accNum, name, deposit); break;
        }

        bank.openAccount(account);
        bank.displayBankInfo();
        account.showAccountType();
        System.out.println("Holder: " + account.getHolderName());
        System.out.println("Account Number: " + account.getAccountNumber());
        System.out.println("Balance: ₹" + account.getBalance());

        System.out.println("\n--- Deposit Operation ---");
        sc.nextLine(); 
        System.out.print("Enter Account Number to deposit: ");
        String searchAccNum = sc.nextLine();
        Account found = bank.findAccountByNumber(searchAccNum);
        if (found != null) {
            System.out.print("Enter amount to deposit: ");
            double amount = sc.nextDouble();
            found.deposit(amount);
            System.out.println("Deposit successful. New Balance: ₹" + found.getBalance());
        } else {
            System.out.println("Account not found!");
        }

        sc.nextLine();
        System.out.println("\n--- Withdraw Operation ---");
        System.out.print("Enter Account Number to withdraw: ");
        String withdrawAccNum = sc.nextLine();
        Account withdrawAcc = bank.findAccountByNumber(withdrawAccNum);
        if (withdrawAcc != null) {
            System.out.print("Enter amount to withdraw: ");
            double withdrawAmt = sc.nextDouble();
            if (withdrawAcc.getBalance() >= withdrawAmt) {
                withdrawAcc.withdraw(withdrawAmt);
                System.out.println("Withdrawal successful. New Balance: ₹" + withdrawAcc.getBalance());
            } else {
                System.out.println("Insufficient balance!");
            }
        } else {
            System.out.println("Account not found!");
        }
    }
}
