package BankingApplication;

public class CooperativeBank extends Bank {
    public CooperativeBank(String bankName, String branchName) {
        super(bankName, branchName);
    }
    @Override
    public void openAccount(Account account) {
        accounts.add(account);
        System.out.println("Account opened in Cooperative Bank!");
    }
}
