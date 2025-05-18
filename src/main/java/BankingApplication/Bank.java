package BankingApplication;

import java.util.*;

public abstract class Bank {
    protected String bankName;
    protected String branchName;
    protected static int bankCounter = 1;
    protected static final String BANK_CODE_PREFIX = "BANK-";
    protected List<Account> accounts = new ArrayList<>();

    public Bank(String bankName, String branchName) {
        this.bankName = bankName;
        this.branchName = branchName;
    }

    public abstract void openAccount(Account account);

    public void displayBankInfo() {
        System.out.println("--- Bank Details ---");
        System.out.println("Bank Name: " + bankName);
        System.out.println("Branch: " + branchName);
        System.out.println("Bank Code: " + generateBankCode());
    }

    public String generateBankCode() {
        return BANK_CODE_PREFIX + String.format("%03d", bankCounter++);
    }
    
    public Account findAccountByNumber(String accountNumber) {
        for (Account acc : accounts) {
            if (acc.getAccountNumber().equals(accountNumber)) {
                return acc;
            }
        }
        return null;
    }
}
