package BankingApplication;

public class SavingsAccount extends Account {
    public SavingsAccount(String accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }
    @Override
    public void showAccountType() {
        System.out.println("Account Type: Savings Account");
    }
    @Override
    public void deposit(double amount) { balance += amount; }
    @Override
    public void withdraw(double amount) { balance -= amount; }
}
