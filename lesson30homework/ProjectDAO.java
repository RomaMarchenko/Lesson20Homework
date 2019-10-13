package lesson30homework;

import java.util.ArrayList;

public class ProjectDAO {
    private static ArrayList<Project> projects = new ArrayList<>();

    public static ArrayList<Project> getProjects() {
        return projects;
    }

    public static void save(Project project) {
        projects.add(project);
    }
}
