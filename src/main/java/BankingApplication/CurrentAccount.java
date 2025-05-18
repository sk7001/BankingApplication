package BankingApplication;

public class CurrentAccount extends Account {
    public CurrentAccount(String accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }
    @Override
    public void showAccountType() {
        System.out.println("Account Type: Current Account");
    }
    @Override
    public void deposit(double amount) { balance += amount; }
    @Override
    public void withdraw(double amount) { balance -= amount; }
}
