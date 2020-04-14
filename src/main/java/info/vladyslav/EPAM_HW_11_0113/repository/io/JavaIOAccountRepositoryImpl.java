package info.vladyslav.EPAM_HW_11_0113.repository.io;

import info.vladyslav.EPAM_HW_11_0113.model.AccountStatus;
import info.vladyslav.EPAM_HW_11_0113.model.Account;
import info.vladyslav.EPAM_HW_11_0113.repository.AccountRepository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class JavaIOAccountRepositoryImpl implements AccountRepository {

    private String fileName = "./src/main/resources/accounts.txt";

    private static final String CAN_NOT_WRITE = "can`t write file ";

    @Override
    public void create(Account account) throws IOException {
        List<Account> accounts = getAll();
        accounts.add(account);

        List<String> serializedForSaveToFile = new ArrayList<>();
        for (Account accountForSaveToFile : accounts) {
            String stringForSaveToFile = "id = " + accountForSaveToFile.getId() +
                    " | accountName = " + accountForSaveToFile.getAccountName() +
                    " | status = " + accountForSaveToFile.getStatus();
            serializedForSaveToFile.add(stringForSaveToFile);
        }
        try (PrintWriter writer = new PrintWriter(fileName)) {
            for (String s : serializedForSaveToFile) {
                writer.println(s);
            }
        } catch (IOException e) {
            System.out.println(CAN_NOT_WRITE + fileName);
        }
    }

    @Override
    public Account getById(Long aLong) {
        return null;
    }

    @Override
    public Long getLastId() throws IOException {
        List<Account> accounts = getAll();
        return (long) accounts.size();
    }

    @Override
    public List<Account> getAll() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        List<Account> accounts = new ArrayList<>();
        String supportForAccountsArrayList;

        Long id = null;
        String accountName = null;
        AccountStatus status = null;

        while ((supportForAccountsArrayList = reader.readLine()) != null) {

            String[] tokens = supportForAccountsArrayList.split(" \\| ");
            for (String token : tokens) {
                if (token.startsWith("id = ")) {
                    id = Long.parseLong(token.substring(5));
                }
                if (token.startsWith("accountName = ")) {
                    accountName = token.substring(14);
                }
                if (token.startsWith("status = ")) {
                    status = AccountStatus.valueOf(token.substring(9));
                }
            }
            accounts.add(new Account(id, accountName, status));
        }
        return accounts;
    }

    @Override
    public void update(Long idForUpdate, Account accountForUpdate) throws IOException {
        List<Account> collectionForUpdate = getAll();

        List<String> serializedForSaveToFile = new ArrayList<>();

        for (Account accountForUpdateAndSave : collectionForUpdate) {
            if (accountForUpdateAndSave.getId().equals(idForUpdate)) {
                accountForUpdateAndSave = accountForUpdate;
            }
            String stringForSaveToFile = "id = " + accountForUpdateAndSave.getId() +
                    " | accountName = " + accountForUpdateAndSave.getAccountName() +
                    " | status = " + accountForUpdateAndSave.getStatus();
            serializedForSaveToFile.add(stringForSaveToFile);
        }
        try (PrintWriter writer = new PrintWriter(fileName)) {
            for (String s : serializedForSaveToFile) {
                writer.println(s);
            }
        } catch (IOException e) {
            System.out.println(CAN_NOT_WRITE + fileName);
        }
    }

    @Override
    // the method is not used, because the lines are not completely deleted,
    // and the status "deleted" is assigned for deletion
    public void delete(Account account) {
    }

}
