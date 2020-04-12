package info.vladyslav.EPAM_HW_11_0113.repository.io;

import info.vladyslav.EPAM_HW_11_0113.model.Skill;
import info.vladyslav.EPAM_HW_11_0113.repository.SkillRepository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class JavaIOSkillRepositoryImpl implements SkillRepository {

    private String fileName = "./src/main/resources/skills.txt";

    private static final String CAN_NOT_WRITE = "can`t write file ";

    @Override
    public void create(Skill skill) throws IOException {
        List<Skill> skills = getAll();
        skills.add(skill);

        List<String> serializedForSaveToFile = new ArrayList<>();
        for (Skill skillForSaveToFile : skills) {
            String stringForSaveToFile = "id = " + skillForSaveToFile.getId() +
                    " | skillName = " + skillForSaveToFile.getSkill();
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
    public Skill getById(Long aLong) {
        return null;
    }

    @Override
    public Long getLastId() throws IOException {
        List<Skill> skills = getAll();
        return (long) skills.size();
    }

    @Override
    public List<Skill> getAll() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        List<Skill> skills = new ArrayList<>();
        String supportForSkillsArrayList;

        Long id = null;
        String skillName = null;

        while ((supportForSkillsArrayList = reader.readLine()) != null) {

            String[] tokens = supportForSkillsArrayList.split(" \\| ");
            for (String token : tokens) {
                if (token.startsWith("id = ")) {
                    id = Long.parseLong(token.substring(5));
                }
                if (token.startsWith("skillName = ")) {
                    skillName = token.substring(12);
                }
            }
            skills.add(new Skill(id, skillName));
        }
        return skills;
    }

    @Override
    public void update(Long idForUpdate, Skill skillForUpdate) throws IOException {
        List<Skill> collectionForUpdate = getAll();

        List<String> serializedForSaveToFile = new ArrayList<>();

        for (Skill skillForUpdateAndSave : collectionForUpdate) {
            if (skillForUpdateAndSave.getId().equals(idForUpdate)) {
                skillForUpdateAndSave = skillForUpdate;
            }
            String stringForSaveToFile = "id = " + skillForUpdateAndSave.getId() +
                    " | skillName = " + skillForUpdateAndSave.getSkill();
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
    public void delete(Skill skill) throws IOException {
        List<Skill> collectionForUpdate = getAll();

        List<String> serializedForSaveToFile = new ArrayList<>();

        for (Skill skillForDelete : collectionForUpdate) {
            if (skillForDelete.getId().equals(skill.getId())) {
                continue;
            }
            String stringForSaveToFile = "id = " + skillForDelete.getId() +
                    " | skillName = " + skillForDelete.getSkill();
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
}
