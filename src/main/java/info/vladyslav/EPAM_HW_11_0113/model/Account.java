package info.vladyslav.EPAM_HW_11_0113.model;

import info.vladyslav.EPAM_HW_11_0113.controller.AccountController;

public class Account {
    private Long id;
    private String accountName;
    private AccountController.AccountStatus status;

    public Account() {
    }

    public Account(Long id, String accountName, AccountController.AccountStatus status) {
        this.id = id;
        this.accountName = accountName;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public AccountController.AccountStatus getStatus() {
        return status;
    }

    public void setStatus(AccountController.AccountStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "AccountName='" + accountName + '\'' +
                ", status=" + status;
    }

}
