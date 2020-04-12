package info.vladyslav.EPAM_HW_11_0113.repository.io;

import info.vladyslav.EPAM_HW_11_0113.controller.AccountController;
import info.vladyslav.EPAM_HW_11_0113.controller.SkillController;
import info.vladyslav.EPAM_HW_11_0113.model.Account;
import info.vladyslav.EPAM_HW_11_0113.model.Developer;
import info.vladyslav.EPAM_HW_11_0113.model.Skill;
import info.vladyslav.EPAM_HW_11_0113.repository.DeveloperRepository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class JavaIODeveloperRepositoryImpl implements DeveloperRepository {

    private String fileName = "./src/main/resources/developers.txt";
    private AccountController accountController = new AccountController();
    private SkillController skillController = new SkillController();

    private static final String CAN_NOT_WRITE = "can`t write file ";

    @Override
    public void create(Developer developer) throws IOException {
        List<Developer> developers = getAll();
        developers.add(developer);

        List<String> serializedForSaveToFile = new ArrayList<>();

        for (Developer accountForSaveToFile : developers) {
            StringBuilder forBuildSkills = new StringBuilder();
            for (Skill skill : accountForSaveToFile.getSkills()) {
                forBuildSkills.append(skill.getId()).append(", ");
            }
            String stringForSaveToFile = "developer_id = " + accountForSaveToFile.getId() +
                    " | account_id = " + accountForSaveToFile.getAccount().getId() +
                    " | Skills_id = " + forBuildSkills.substring(0, forBuildSkills.length() - 2);
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
    public Developer getById(Long aLong) {
        return null;
    }

    @Override
    public Long getLastId() throws IOException {
        List<Developer> accounts = getAll();
        return (long) accounts.size();
    }

    @Override
    public List<Developer> getAll() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        List<Developer> developers = new ArrayList<>();
        String supportForDevelopersArrayList;

        Long id = null;
        Account account = null;

        while ((supportForDevelopersArrayList = reader.readLine()) != null) {
            Set<Skill> skills = new HashSet<>();

            String[] tokens = supportForDevelopersArrayList.split(" \\| ");
            for (String token : tokens) {
                if (token.startsWith("developer_id = ")) {
                    id = Long.parseLong(token.substring(15));
                }
                if (token.startsWith("account_id = ")) {
                    account = accountController.getAccountById(Long.valueOf(token.substring(13)));
                }
                if (token.startsWith("Skills_id = ")) {
                    String supportForSkillSet = token.substring(12);
                    String[] tokensForSkill = supportForSkillSet.split(", ");
                    for (String tokenSkill : tokensForSkill) {
                        skills.add(skillController.getSkillById(Long.valueOf(tokenSkill)));
                    }
                }
            }
            developers.add(new Developer(id, account, skills));
        }
        return developers;
    }

    @Override
    public void update(Long idForUpdate, Developer accountForUpdate) {
    }

    @Override
    public void delete(Developer developer) {
    }

}
