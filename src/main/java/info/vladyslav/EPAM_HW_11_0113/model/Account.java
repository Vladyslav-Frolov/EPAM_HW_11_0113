package info.vladyslav.EPAM_HW_11_0113.model;

import java.util.Objects;

public class Account {
    private Long id;
    private String accountName;
    private AccountStatus status;

    public Account() {
    }

    public Account(Long id, String accountName, AccountStatus status) {
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

    public AccountStatus getStatus() {
        return status;
    }

    public void setStatus(AccountStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "AccountName='" + accountName + '\'' +
                ", status=" + status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(id, account.id) &&
                Objects.equals(accountName, account.accountName) &&
                status == account.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, accountName, status);
    }
}
