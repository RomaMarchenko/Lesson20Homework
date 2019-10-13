package lesson30homework;

import java.util.Objects;

public class Project {
    private String name;
    private Customer customer;
    private Employee teamLead;

    public Project(String name, Customer customer, Employee teamLead) {
        this.name = name;
        this.customer = customer;
        this.teamLead = teamLead;
    }

    public String getName() {
        return name;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Employee getTeamLead() {
        return teamLead;
    }

    public void setTeamLead(Employee teamLead) {
        this.teamLead = teamLead;
    }

    @Override
    public String toString() {
        return "Project{" +
                "name='" + name + '\'' +
                ", customer=" + customer +
                ", projectManager=" + teamLead +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Project project = (Project) o;
        return name.equals(project.name) &&
                customer.equals(project.customer) &&
                teamLead.equals(project.teamLead);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, customer, teamLead);
    }
}
