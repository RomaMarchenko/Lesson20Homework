package lesson30homework;

import java.util.ArrayList;
import java.util.HashSet;

public class Controller {
    public static ArrayList<Employee> employeesByProject(String projectName) {
        ArrayList<Employee> wantedEmployees = new ArrayList<>();
        ArrayList<Employee> employees = EmployeeDAO.getEmployees();

        for (Employee employee : employees) {
            if (employee != null) {
                ArrayList<Project> employeeProjects = employee.getProjects();

                for (Project pr : employeeProjects) {
                    if (pr.getName().equals(projectName))
                        wantedEmployees.add(employee);
                }
            }
        }
        return wantedEmployees;
    }

    public static ArrayList<Project>  projectsByEmployee(Employee employee) {
        return new ArrayList<>(employee.getProjects());
    }

    public static ArrayList<Employee> employeesByDepartmentWithoutProject(DepartmentType departmentType) {
        ArrayList<Employee> wantedEmployees = new ArrayList<>();
        ArrayList<Employee> employees = EmployeeDAO.getEmployees();
        ArrayList<Department> departments = DepartmentDAO.getDepartments();

        for (Department department : departments) {
            if (department != null && department.getType() != null) {
                if (department.getType().equals(departmentType)) {
                    for (Employee em : employees) {
                        if (em.getProjects().isEmpty())
                            wantedEmployees.add(em);
                    }
                }
            }
        }
        return wantedEmployees;
    }

    public static ArrayList<Employee> employeesWithoutProject() {
        ArrayList<Employee> wantedEmployees = new ArrayList<>();
        ArrayList<Employee> employees = EmployeeDAO.getEmployees();

        for (Employee em : employees) {
            if (em != null && em.getProjects() != null) {
                if (em.getProjects().isEmpty())
                    wantedEmployees.add(em);
            }
        }
        return wantedEmployees;
    }

    public static HashSet<Employee> employeesByTeamLead(Employee lead) {
        HashSet<Employee> wantedEmployees = new HashSet<>();
        ArrayList<Project> projects = lead.getProjects();

        for (Project pr : projects) {
             ArrayList<Employee> employees = employeesByProject(pr.getName());
             employees.remove(lead);
             wantedEmployees.addAll(employees);
            }
        return wantedEmployees;
    }

    public static HashSet<Employee> teamLeadsByEmployee(Employee employee) {
        HashSet<Employee> teamLeads = new HashSet<>();

        ArrayList<Project> employeeProjects = employee.getProjects();
        for (Project project : employeeProjects) {
            teamLeads.add(project.getTeamLead());
        }
        return teamLeads;
    }

    public static HashSet<Employee> employeesByProjectEmployee(Employee employee) {
        HashSet<Employee> wantedEmployees = new HashSet<>();
        ArrayList<Project> projects =  employee.getProjects();

        for (Project project : projects) {
            ArrayList<Employee> employees = employeesByProject(project.getName());
            employees.remove(employee);
            wantedEmployees.addAll(employees);
        }
        return wantedEmployees;
    }

    public static ArrayList<Project> projectsByCustomer(Customer customer) {
        ArrayList<Project> wantedProjects = new ArrayList<>();
        ArrayList<Project> projects = ProjectDAO.getProjects();

        for (Project project : projects) {
            if (project != null && project.getCustomer() != null) {
                if (project.getCustomer().equals(customer))
                    wantedProjects.add(project);
            }
        }
        return wantedProjects;
    }

    public static HashSet<Employee> employeesByCustomerProjects(Customer customer) {
        HashSet<Employee> wantedEmployees = new HashSet<>();
        ArrayList<Project> projects = projectsByCustomer(customer);

        for (Project project : projects) {
            wantedEmployees.addAll(employeesByProject(project.getName()));
        }
        return wantedEmployees;
    }
}
