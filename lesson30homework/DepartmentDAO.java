package lesson30homework;

import java.util.ArrayList;

public class DepartmentDAO {

    private static ArrayList<Department> departments = new ArrayList<>();

    public static ArrayList<Department> getDepartments() {
        return departments;
    }

    public static void save(Department department) {
        departments.add(department);
    }
}
