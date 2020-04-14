package info.vladyslav.EPAM_HW_11_0113.model;

import java.util.Objects;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Developer developer = (Developer) o;
        return id == developer.id &&
                Objects.equals(account, developer.account) &&
                Objects.equals(skills, developer.skills);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, account, skills);
    }
}
