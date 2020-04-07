package info.vladyslav.EPAM_HW_11_0113.controller;

import info.vladyslav.EPAM_HW_11_0113.model.Skill;
import info.vladyslav.EPAM_HW_11_0113.repository.SkillRepository;
import info.vladyslav.EPAM_HW_11_0113.repository.io.JavaIOSkillRepositoryImpl;

import java.io.IOException;
import java.util.List;

public class SkillController {
    private SkillRepository repo = new JavaIOSkillRepositoryImpl();
    private static final String SUCCESSFULLY_CREATED = "Creation completed successfully\n";
    private static final String SUCCESSFULLY_UPDATED = "Skill successfully updated\n";
    private static final String SUCCESSFULLY_DELETED = "Skill successfully deleted\n";
    private static final String REPOSITORY_EMPTY = "Repository is empty. Select «create skill», #1 on the list below\n";

    public String addNewSkill(String information) throws IOException {
        long id = repo.getLastId() + 1;
        Skill skill = new Skill(id, information);
        repo.create(skill);
        return SUCCESSFULLY_CREATED;
    }

    public void getAllFromRepo() throws IOException {
        if (repo.getAll().size() == 0L) {
            System.out.print(REPOSITORY_EMPTY);
        }
        for (Skill skill : repo.getAll()) {
            System.out.println("id: " + skill.getId() + " → " + skill.getSkill());
        }
        System.out.println();
    }

    public Skill getSkillById(long id) throws IOException {
        if (repo.getAll().size() == 0L) {
            System.out.print(REPOSITORY_EMPTY);
        }
        for (Skill skill : repo.getAll()) {
            if (skill.getId() == id) {
                return skill;
            }
        }
        System.out.println();
        return null;
    }

    public void setSkillUpdate(long idForUpdate, String infoForUpdate) throws IOException {
        List<Skill> collectionForUpdate = repo.getAll();
        Skill skill = new Skill();

        for (Skill skills : collectionForUpdate) {
            if (skills.getId() == idForUpdate) {
                skill.setId(skills.getId());
                skill.setSkill(infoForUpdate);
            }
        }

        repo.update(idForUpdate, skill);
        System.out.println(SUCCESSFULLY_UPDATED);
    }

    public void deleteSkill(Long idForDelete) throws IOException {
        repo.delete(fetchingTargetClassById(idForDelete));
        System.out.println(SUCCESSFULLY_DELETED);
    }

    private Skill fetchingTargetClassById(Long id) throws IOException {
        List<Skill> collectionForUpdate = repo.getAll();
        Skill skill = new Skill();

        for (Skill skills : collectionForUpdate) {
            if (skills.getId().equals(id)) {
                skill.setId(skills.getId());
                skill.setSkill(skills.getSkill());
            }
        }
        return skill;
    }

}

