package info.vladyslav.EPAM_HW_11_0113.model;

import java.util.Set;

public class Developer {
    private long id;
    private Account account;
    private Set<Skill> skills;

    public Developer() {
    }

    public Developer(long id, Account account, Set<Skill> skills) {
        this.id = id;
        this.account = account;
        this.skills = skills;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Set<Skill> getSkills() {
        return skills;
    }

    public void setSkills(Set<Skill> skills) {
        this.skills = skills;
    }


    @Override
    public String toString() {
        return "Developer" +
                " id=" + id +
                " {" + account +
                ", skills=" + skills +
                '}';
    }
}
