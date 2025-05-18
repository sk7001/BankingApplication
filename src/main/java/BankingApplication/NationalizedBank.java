package BankingApplication;

public class NationalizedBank extends Bank {
    public NationalizedBank(String bankName, String branchName) {
        super(bankName, branchName);
    }
    @Override
    public void openAccount(Account account) {
        accounts.add(account);
        System.out.println("Account opened in Nationalized Bank!");
    }
}
