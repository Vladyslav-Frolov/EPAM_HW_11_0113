package info.vladyslav.EPAM_HW_11_0113.view;

import info.vladyslav.EPAM_HW_11_0113.controller.AccountController;

import java.io.IOException;
import java.util.Scanner;

public class AccountView {
    private Scanner scannerForStrings = new Scanner(System.in);
    private Scanner scannerForLongs = new Scanner(System.in);
    private AccountController accountController = new AccountController();

    private static final String ACCOUNT_VIEW_MENU = "Make your choice\n" +
            "1. create account\n" +
            "2. show all accounts (read all)\n" +
            "3. show account by id (read)\n" +
            "4. update account name\n" +
            "5. ban account\n" +
            "6. delete account\n" +
            "7. recover account\n" +
            "8. exit";
    private static final String ENTER_NAME = "Enter your account name: ";
    private static final String ENTER_ID = "Enter id: ";
    private static final String ENTER_ID_UPDATE = "Enter id for update: ";
    private static final String ENTER_NAME_NEW = "Enter new account name for update: ";
    private static final String ENTER_ID_BAN = "Enter id for ban: ";
    private static final String ENTER_ID_DELETE = "Enter id for delete account: ";
    private static final String ENTER_ID_RECOVER = "Enter id for recover account: ";

    public void viewAccountMenu() throws IOException {

        int numberOfChoce = 0;
        Scanner getConsoleNuber = new Scanner(System.in);
        while (numberOfChoce != 8) {
            System.out.println(ACCOUNT_VIEW_MENU);
            numberOfChoce = getConsoleNuber.nextInt();

            switch (numberOfChoce) {
                case 1:
                    System.out.println(ENTER_NAME);
                    String information = scannerForStrings.nextLine();
                    accountController.addNewAccount(information);
                    break;

                case 2:
                    accountController.getAllFromRepo();
                    break;

                case 3:
                    System.out.println(ENTER_ID);
                    long imputIdForShow = scannerForLongs.nextLong();
                    System.out.println(accountController.getAccountById(imputIdForShow));
                    break;

                case 4:
                    System.out.println(ENTER_ID_UPDATE);
                    long idForUpdate = scannerForLongs.nextLong();
                    System.out.println(ENTER_NAME_NEW);
                    String informationForUpdate = scannerForStrings.nextLine();
                    accountController.setAccountUpdate(idForUpdate, informationForUpdate);
                    break;

                case 5:
                    System.out.println(ENTER_ID_BAN);
                    long idForBan = scannerForLongs.nextLong();
                    accountController.setAccountBan(idForBan);
                    break;

                case 6:
                    System.out.println(ENTER_ID_DELETE);
                    long idForDelete = scannerForLongs.nextLong();
                    accountController.setAccountDeleteStatus(idForDelete);
                    break;

                case 7:
                    System.out.println(ENTER_ID_RECOVER);
                    long idForRecover = scannerForLongs.nextLong();
                    accountController.setAccountRecover(idForRecover);
            }
        }
    }
}
