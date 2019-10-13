package lesson30homework;

import java.util.ArrayList;
import java.util.Date;


public class EmployeeDAO {
    private static ArrayList<Employee> employees = new ArrayList<>();

    public static ArrayList<Employee> getEmployees() {
        return employees;
    }

    public static void save(Employee employee) {
        employees.add(employee);
    }
}

