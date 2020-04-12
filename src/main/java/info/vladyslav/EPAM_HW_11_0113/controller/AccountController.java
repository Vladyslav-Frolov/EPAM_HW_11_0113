package info.vladyslav.EPAM_HW_11_0113.controller;

import info.vladyslav.EPAM_HW_11_0113.model.Account;
import info.vladyslav.EPAM_HW_11_0113.model.AccountStatus;
import info.vladyslav.EPAM_HW_11_0113.repository.AccountRepository;
import info.vladyslav.EPAM_HW_11_0113.repository.io.JavaIOAccountRepositoryImpl;

import java.io.IOException;
import java.util.List;

public class AccountController {
    private AccountRepository repo = new JavaIOAccountRepositoryImpl();
    private static final String SUCCESSFULLY_CREATED = "Creation completed successfully\n";
    private static final String SUCCESSFULLY_BANNED = "Account successfully banned\n";
    private static final String SUCCESSFULLY_UPDATED = "Account successfully updated\n";
    private static final String SUCCESSFULLY_DELETED = "Account successfully deleted\n";
    private static final String SUCCESSFULLY_RECOVER = "Account successfully recover\n";
    private static final String REPOSITORY_EMPTY = "Repository is empty. " +
            "Select «create account», #1 on the list below\n";

    public Account addNewAccount(String information) throws IOException {
        long id = repo.getLastId() + 1;
        Account account = new Account(id, information, AccountStatus.ACTIVE);
        repo.create(account);
        System.out.println(SUCCESSFULLY_CREATED);
        return account;
    }

    public void getAllFromRepo() throws IOException {
        if (repo.getAll().size() == 0L) {
            System.out.print(REPOSITORY_EMPTY);
        }
        for (Account account : repo.getAll()) {
            System.out.println(account);
        }
        System.out.println();
    }

    public Account getAccountById(long id) throws IOException {
        if (repo.getAll().size() == 0L) {
            System.out.print(REPOSITORY_EMPTY);
        }
        for (Account account : repo.getAll()) {
            if (account.getId() == id) {
                return account;
            }
        }
        System.out.println();
        return null;
    }

    public void setAccountUpdate(long idForUpdate, String infoForUpdate) throws IOException {
        List<Account> collectionForUpdate = repo.getAll();
        Account account = new Account();

        for (Account accounts : collectionForUpdate) {
            if (accounts.getId() == idForUpdate) {
                account.setId(accounts.getId());
                account.setAccountName(infoForUpdate);
                account.setStatus(accounts.getStatus());
            }
        }

        repo.update(idForUpdate, account);
        System.out.println(SUCCESSFULLY_UPDATED);
    }

    public void setAccountBan(Long idForBan) throws IOException {
        List<Account> collectionForUpdate = repo.getAll();
        Account account = new Account();

        for (Account accounts : collectionForUpdate) {
            if (accounts.getId().equals(idForBan)) {
                account.setId(accounts.getId());
                account.setAccountName(accounts.getAccountName());
                account.setStatus(AccountStatus.BANNED);
            }
        }

        repo.update(idForBan, account);
        System.out.println(SUCCESSFULLY_BANNED);
    }

    public void setAccountDeleteStatus(Long idForDelete) throws IOException {
        List<Account> collectionForUpdate = repo.getAll();
        Account account = new Account();

        for (Account accounts : collectionForUpdate) {
            if (accounts.getId().equals(idForDelete)) {
                account.setId(accounts.getId());
                account.setAccountName(accounts.getAccountName());
                account.setStatus(AccountStatus.DELETED);
            }
        }

        repo.update(idForDelete, account);
        System.out.println(SUCCESSFULLY_DELETED);
    }

    public void setAccountRecover(long idForRecover) throws IOException {
        List<Account> collectionForUpdate = repo.getAll();
        Account account = new Account();

        for (Account accounts : collectionForUpdate) {
            if (accounts.getId().equals(idForRecover)) {
                account.setId(accounts.getId());
                account.setAccountName(accounts.getAccountName());
                account.setStatus(AccountStatus.ACTIVE);
            }
        }

        repo.update(idForRecover, account);
        System.out.println(SUCCESSFULLY_RECOVER);
    }
}

