package info.vladyslav.EPAM_HW_11_0113.controller;

import info.vladyslav.EPAM_HW_11_0113.model.Developer;
import info.vladyslav.EPAM_HW_11_0113.model.Skill;
import info.vladyslav.EPAM_HW_11_0113.repository.DeveloperRepository;
import info.vladyslav.EPAM_HW_11_0113.repository.io.JavaIODeveloperRepositoryImpl;

import java.io.IOException;
import java.util.Set;

public class DeveloperController {
    private DeveloperRepository repo = new JavaIODeveloperRepositoryImpl();
    private AccountController accountController = new AccountController();
    private SkillController skillController = new SkillController();


    private static final String SUCCESSFULLY_CREATED = "Creation of developer completed successfully\n";
    private static final String REPOSITORY_EMPTY = "Repository is empty. " +
            "Select «create developer», #1 on the list below\n";

    public void addNewDeveloperFromWizard(String information, Set<Skill> skillSet) throws IOException {
        long id = repo.getLastId() + 1;
        Developer developer = new Developer(id, accountController.addNewAccount(information), skillSet);
        repo.create(developer);
        System.out.println(SUCCESSFULLY_CREATED);
    }

    // Skills methods from Developer Controller:
    public void getAllFromSkillRepo() throws IOException {
        skillController.getAllFromRepo();
    }

    public Skill getSkillFromSkillRepoById(long id) throws IOException {
        return skillController.getSkillById(id);
    }

    public String addNewSkillToSkillRepo(String newSkill) throws IOException {
        return skillController.addNewSkill(newSkill);
    }
// end Skills methods from Developer Controller

    // Account methods from Developer Controller:
    public void setAccountUpdateToAccountRepo(long idForUpdate, String infoForUpdate) throws IOException {
        accountController.setAccountUpdate(idForUpdate, infoForUpdate);
    }

    public void setAccountBanToAccountRepo(long idForBan) throws IOException {
        accountController.setAccountBan(idForBan);
    }

    public void setAccountDeleteStatusToAccountRepo(long idForDelete) throws IOException {
        accountController.setAccountDeleteStatus(idForDelete);
    }

    public void setAccountRecoverToAccountRepo(long idForRecover) throws IOException {
        accountController.setAccountRecover(idForRecover);
    }
// end Account methods from Developer Controller

    public void getAllFromRepo() throws IOException {
        if (repo.getAll().size() == 0L) {
            System.out.print(REPOSITORY_EMPTY);
        }
        for (Developer developer : repo.getAll()) {
            System.out.println(developer);
        }
        System.out.println();
    }

    public void getDeveloperById(long id) throws IOException {
        if (repo.getAll().size() == 0L) {
            System.out.print(REPOSITORY_EMPTY);
        }
        for (Developer developer : repo.getAll()) {
            if (developer.getId() == id) {
                System.out.println(developer);
            }
        }
        System.out.println();
    }
}

