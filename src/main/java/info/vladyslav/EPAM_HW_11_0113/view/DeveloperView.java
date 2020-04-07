package info.vladyslav.EPAM_HW_11_0113.view;

import info.vladyslav.EPAM_HW_11_0113.controller.DeveloperController;
import info.vladyslav.EPAM_HW_11_0113.model.Skill;

import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class DeveloperView {
    private Scanner scannerForStrings = new Scanner(System.in);
    private Scanner scannerForLongs = new Scanner(System.in);
    private Scanner scannerForStringSubmenu = new Scanner(System.in);
    private Scanner scannerForLongSubmenu = new Scanner(System.in);

    private DeveloperController developerController = new DeveloperController();
    private SkillView skillView = new SkillView();

    private static final String DEVELOPER_VIEW_MENU = "Make your choice\n" +
            "1. Create developer using the create wizard (with submenu)\n" +
            "2. Show all developers (read all)\n" +
            "3. Show developers by id (read)\n" +
            "4. update developer Account name\n" +
            "5. update developer Skill set (from skill submenu)\n" +
            "6. ban developer account\n" +
            "7. delete developer account\n" +
            "8. recover developer account\n" +
            "9. exit";
    private static final String DEVELOPER_VIEW_SUBMENU = "Select from the submenu of the Create Developer Wizard:\n" +
            "a. Add skill for current developer (multiple times)\n" +
            "b. Show added skills for current developer\n" +
            "c. Show all skills from skill repository\n" +
            "d. Add new skill to skill repository\n" +
            "q. Save new developer and quit to main menu";
    private static final String ENTER_NAME = "Enter new developer account name:";
    private static final String ALL_DEVELOPERS = "List with all developers below:";
    private static final String ENTER_DEVELOPER_ID = "Enter developer id below:";
    private static final String ENTER_NEW_ACCOUNT_NAME = "Enter new account name for update:";
    private static final String ENTER_ID_BAN = "Enter id for ban:";
    private static final String ENTER_ID_DELETE = "Enter id for delete account:";
    private static final String ENTER_ID_RECOVER = "Enter id for recover account:";
    private static final String ADD_SKILL_IN_DEVELOPER_SKILL_SET = "Add skill in developer skill set " +
            "by id from list below:";
    private static final String ADDED_SKILL = "Added skill: ";
    private static final String ENTER_ZERO_TO_RETURN = "Enter «0» to return to the previous menu " +
            "or enter new skill for add skill from the list above";
    private static final String CURRENT_SKILLS = "Skills for current developer:";
    private static final String ALL_SKILLS = "List with all skills: ";
    private static final String NEW_SKILL_TO_REPOSITORY = "Enter new skill to skill repository: ";

    public void viewDeveloperMenu() throws IOException {

        int numberOfChoce = 0;
        Scanner getConsoleNuber = new Scanner(System.in);
        while (numberOfChoce != 9) {
            System.out.println(DEVELOPER_VIEW_MENU);
            numberOfChoce = getConsoleNuber.nextInt();

            switch (numberOfChoce) {
                case 1:
                    System.out.println(ENTER_NAME);
                    String information = scannerForStrings.nextLine();
                    addNewDeveloperCreationWizardSubmenu(information);
                    break;

                case 2:
                    System.out.println(ALL_DEVELOPERS);
                    developerController.getAllFromRepo();
                    break;

                case 3:
                    System.out.println(ENTER_DEVELOPER_ID);
                    long idForShowDeveloper = scannerForLongs.nextLong();
                    developerController.getDeveloperById(idForShowDeveloper);
                    break;

                case 4:
                    System.out.println(ENTER_DEVELOPER_ID);
                    long idForUpdateAccount = scannerForLongs.nextLong();
                    System.out.println(ENTER_NEW_ACCOUNT_NAME);
                    String informationForUpdate = scannerForStrings.nextLine();
                    developerController.setAccountUpdateToAccountRepo(idForUpdateAccount, informationForUpdate);
                    break;

                case 5:
                    skillView.viewSkillMenu();
                    break;

                case 6:
                    System.out.println(ENTER_ID_BAN);
                    long idForBan = scannerForLongs.nextLong();
                    developerController.setAccountBanToAccountRepo(idForBan);
                    break;

                case 7:
                    System.out.println(ENTER_ID_DELETE);
                    long idForDelete = scannerForLongs.nextLong();
                    developerController.setAccountDeleteStatusToAccountRepo(idForDelete);
                    break;

                case 8:
                    System.out.println(ENTER_ID_RECOVER);
                    long idForRecover = scannerForLongs.nextLong();
                    developerController.setAccountRecoverToAccountRepo(idForRecover);
                    break;
            }
        }
    }

    public void addNewDeveloperCreationWizardSubmenu(String information) throws IOException {

        Set<Skill> skillSet = new HashSet<>();

        char takeCharPick = (char) -1;
        long takeLongPick = -1;

        while (takeCharPick != 'q') {
            System.out.println(DEVELOPER_VIEW_SUBMENU);
            takeCharPick = scannerForStringSubmenu.nextLine().charAt(0);

            switch (takeCharPick) {
                case 'a':
                    System.out.println(ADD_SKILL_IN_DEVELOPER_SKILL_SET);
                    developerController.getAllFromSkillRepo();
                    while (takeLongPick != 0) {
                        takeLongPick = scannerForLongSubmenu.nextLong();
                        System.out.print(ADDED_SKILL);
                        skillSet.add(developerController.getSkillFromSkillRepoById(takeLongPick));
                        System.out.println(ENTER_ZERO_TO_RETURN);
                    }
                    skillSet.remove(null);
                    System.out.println();
                    break;

                case 'b':
                    System.out.println(CURRENT_SKILLS);
                    for (Skill skill : skillSet) {
                        System.out.println("id: " + skill.getId() + " → " + skill.getSkill());
                    }
                    System.out.println();
                    break;

                case 'c':
                    System.out.println(ALL_SKILLS);
                    developerController.getAllFromSkillRepo();
                    break;

                case 'd':
                    System.out.println(NEW_SKILL_TO_REPOSITORY);
                    String newSkill = scannerForStringSubmenu.nextLine();
                    developerController.addNewSkillToSkillRepo(newSkill);
                    break;
            }
        }
        developerController.addNewDeveloperFromWizard(information, skillSet);
    }
}
