package info.vladyslav.EPAM_HW_11_0113.model;

public class Skill {
    private Long id;
    private String skill;

    public Skill() {
    }

    public Skill(Long id, String skill) {
        this.id = id;
        this.skill = skill;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    @Override
    public String toString() {
        return skill;
    }
}
