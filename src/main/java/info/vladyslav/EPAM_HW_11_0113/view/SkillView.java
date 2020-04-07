package info.vladyslav.EPAM_HW_11_0113.view;

import info.vladyslav.EPAM_HW_11_0113.controller.SkillController;

import java.io.IOException;
import java.util.Scanner;

public class SkillView {
    private Scanner scannerForStrings = new Scanner(System.in);
    private Scanner scannerForLongs = new Scanner(System.in);
    private SkillController skillController = new SkillController();

    private static final String SKILL_VIEW_MENU = "Make your choice\n" +
            "1. create skill\n" +
            "2. show all skills (read all)\n" +
            "3. show skill by id (read)\n" +
            "4. update skill\n" +
            "5. delete skill\n" +
            "6. quit";
    private static final String ENTER_SKILL = "Enter the skill you want to create: ";
    private static final String ENTER_ID = "Enter id: ";
    private static final String ENTER_ID_UPDATE = "Enter id for update: ";
    private static final String ENTER_SKILL_UPDATE = "Enter new skill name for update: ";
    private static final String ENTER_ID_DELETE = "Enter id for delete: ";

    public void viewSkillMenu() throws IOException {

        int numberOfChoce = 0;
        Scanner getConsoleNuber = new Scanner(System.in);
        while (numberOfChoce != 6) {
            System.out.println(SKILL_VIEW_MENU);
            numberOfChoce = getConsoleNuber.nextInt();

            switch (numberOfChoce) {
                case 1:
                    System.out.println(ENTER_SKILL);
                    String information = scannerForStrings.nextLine();
                    System.out.println(skillController.addNewSkill(information));
                    break;

                case 2:
                    skillController.getAllFromRepo();
                    break;

                case 3:
                    System.out.println(ENTER_ID);
                    long imputIdForShow = scannerForLongs.nextLong();
                    System.out.println(skillController.getSkillById(imputIdForShow));
                    break;

                case 4:
                    System.out.println(ENTER_ID_UPDATE);
                    long idForUpdate = scannerForLongs.nextLong();
                    System.out.println(ENTER_SKILL_UPDATE);
                    String informationForUpdate = scannerForStrings.nextLine();
                    skillController.setSkillUpdate(idForUpdate, informationForUpdate);
                    break;

                case 5:
                    System.out.println(ENTER_ID_DELETE);
                    long idForDelete = scannerForLongs.nextLong();
                    skillController.deleteSkill(idForDelete);
                    break;
            }
        }
    }
}
