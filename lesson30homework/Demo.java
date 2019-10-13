package lesson30homework;

import jdk.swing.interop.SwingInterOpUtils;

import java.util.ArrayList;
import java.util.Date;

public class Demo {
    private static Customer customer1 = new Customer("BMW", "Germany", 1000);
    private static Customer customer2 = new Customer("Honda", "Japan", 900);
    private static Customer customer3 = new Customer("Fender Squier", "USA", 800);
    private static Customer customer4 = new Customer("NVIDIA", "USA", 1200);

    private static Project project1 = new Project("Project1", customer1, null);
    private static Project project2 = new Project("Project2", customer1, null);
    private static Project project3 = new Project("Project3", customer2, null);
    private static Project project4 = new Project("Project4", customer2, null);
    private static Project project5 = new Project("Project5", customer2, null);
    private static Project project6 = new Project("Project1", customer3, null);
    private static Project project7 = new Project("Project1", customer3, null);
    private static Project project8 = new Project("Project1", customer3, null);
    private static Project project9 = new Project("Project1", customer3, null);
    private static Project project10 = new Project("Project1", customer4, null);

    private static Department department1 = new Department(DepartmentType.HR, null);
    private static Department department2 = new Department(DepartmentType.MARKETING, null);
    private static Department department3 = new Department(DepartmentType.CUSTOMER_SERVICE, null);
    private static Department department4 = new Department(DepartmentType.INFORMATION_TECHNOLOGY, null);

    private static Employee employee1 = new Employee("Yana", "Belinska", new Date(), Position.TEAM_LEAD, department1, null);
    private static Employee employee2 = new Employee("Anton", "Portyankin", new Date(), Position.DEVELOPER, department4,null);
    private static Employee employee3 = new Employee("Vladislav", "Bondar", new Date(), Position.DEVELOPER, department4, null);
    private static Employee employee4 = new Employee("Sergey", "Yatsuk", new Date(), Position.TEAM_LEAD, department1, null);
    private static Employee employee5 = new Employee("Yasos", "Biba", new Date(), Position.DEVELOPER, department4, null);
    private static Employee employee6 = new Employee("Olexandr", "Linnik", new Date(), Position.DEVELOPER, department4, null);
    private static Employee employee7 = new Employee("Albina", "Pakulova", new Date(), Position.MANAGER, department2, null);
    private static Employee employee8 = new Employee("Viktoria", "Maslo", new Date(), Position.DESIGNER, department3, null);
    private static Employee employee9 = new Employee("Katerina", "Muzika", new Date(), Position.LEAD_DESIGNER, department3, null);
    private static Employee employee10 = new Employee("Tatyana", "Scherbakova", new Date(), Position.TEAM_LEAD, department1, null);
    private static Employee employee11 = new Employee("Natalya", "Kondrashina", new Date(), Position.DEVELOPER, department4, null);
    private static Employee employee12 = new Employee("Bogdan", "Nadgob", new Date(), Position.DEVELOPER, department4, null);
    private static Employee employee13 = new Employee("Olexandra", "Nazarenko", new Date(), Position.DEVELOPER, department4, null);
    private static Employee employee14 = new Employee("Roman", "Namor", new Date(), Position.MANAGER, department3, null);
    private static Employee employee15 = new Employee("Taras", "Shevchenko", new Date(), Position.FINANCE, department2, null);
    private static Employee employee16 = new Employee("Ivan", "Franko", new Date(), Position.ANALYST, department2, null);
    private static Employee employee17 = new Employee("Grigoriy", "Skovoroda", new Date(), Position.LEAD_DESIGNER,department4, null);
    private static Employee employee18 = new Employee("Vasiliy", "Stus", new Date(), Position.DEVELOPER, department4, new ArrayList<>());
    private static Employee employee19 = new Employee("Alexei", "Pimenov", new Date(), Position.DESIGNER, department3, new ArrayList<>());
    private static Employee employee20 = new Employee("Olga", "Antonova", new Date(), Position.DEVELOPER, department4, new ArrayList<>());


    public static void main(String[] args) {
        CustomerDAO.save(customer1);
        CustomerDAO.save(customer2);
        CustomerDAO.save(customer3);
        CustomerDAO.save(customer4);

        project1.setTeamLead(employee1);
        project2.setTeamLead(employee1);
        project3.setTeamLead(employee4);
        project4.setTeamLead(employee4);
        project5.setTeamLead(employee4);
        project6.setTeamLead(employee4);
        project7.setTeamLead(employee10);
        project8.setTeamLead(employee10);
        project9.setTeamLead(employee10);
        project10.setTeamLead(employee10);

        ProjectDAO.save(project1);
        ProjectDAO.save(project2);
        ProjectDAO.save(project3);
        ProjectDAO.save(project4);
        ProjectDAO.save(project5);
        ProjectDAO.save(project6);
        ProjectDAO.save(project7);
        ProjectDAO.save(project8);
        ProjectDAO.save(project9);
        ProjectDAO.save(project10);

        ArrayList<Project> projectsSet1 = new ArrayList<>();
        ArrayList<Project> projectsSet2 = new ArrayList<>();
        ArrayList<Project> projectsSet3 = new ArrayList<>();

        projectsSet1.add(project1);
        projectsSet1.add(project2);
        projectsSet2.add(project3);
        projectsSet2.add(project4);
        projectsSet2.add(project5);
        projectsSet2.add(project6);
        projectsSet3.add(project7);
        projectsSet3.add(project8);
        projectsSet3.add(project9);
        projectsSet3.add(project10);

        employee1.setProjects(projectsSet1);
        employee2.setProjects(projectsSet1);
        employee3.setProjects(projectsSet1);
        employee4.setProjects(projectsSet2);
        employee5.setProjects(projectsSet2);
        employee6.setProjects(projectsSet2);
        employee7.setProjects(projectsSet2);
        employee8.setProjects(projectsSet2);
        employee9.setProjects(projectsSet2);
        employee10.setProjects(projectsSet2);
        employee11.setProjects(projectsSet3);
        employee12.setProjects(projectsSet3);
        employee13.setProjects(projectsSet3);
        employee14.setProjects(projectsSet3);
        employee15.setProjects(projectsSet3);
        employee16.setProjects(projectsSet3);
        employee17.setProjects(projectsSet3);

        EmployeeDAO.save(employee1);
        EmployeeDAO.save(employee2);
        EmployeeDAO.save(employee3);
        EmployeeDAO.save(employee4);
        EmployeeDAO.save(employee5);
        EmployeeDAO.save(employee6);
        EmployeeDAO.save(employee7);
        EmployeeDAO.save(employee8);
        EmployeeDAO.save(employee9);
        EmployeeDAO.save(employee10);
        EmployeeDAO.save(employee11);
        EmployeeDAO.save(employee12);
        EmployeeDAO.save(employee13);
        EmployeeDAO.save(employee14);
        EmployeeDAO.save(employee15);
        EmployeeDAO.save(employee16);
        EmployeeDAO.save(employee17);
        EmployeeDAO.save(employee18);
        EmployeeDAO.save(employee19);
        EmployeeDAO.save(employee20);

        ArrayList<Employee> firstDepartmentEmployees = new ArrayList<>();
        ArrayList<Employee> secondDepartmentEmployees = new ArrayList<>();
        ArrayList<Employee> thirdDepartmentEmployees = new ArrayList<>();
        ArrayList<Employee> fourthDepartmentEmployees = new ArrayList<>();

        firstDepartmentEmployees.add(employee1);
        firstDepartmentEmployees.add(employee4);
        firstDepartmentEmployees.add(employee10);
        secondDepartmentEmployees.add(employee7);
        secondDepartmentEmployees.add(employee15);
        secondDepartmentEmployees.add(employee16);
        thirdDepartmentEmployees.add(employee8);
        thirdDepartmentEmployees.add(employee9);
        thirdDepartmentEmployees.add(employee14);
        thirdDepartmentEmployees.add(employee19);
        fourthDepartmentEmployees.add(employee3);
        fourthDepartmentEmployees.add(employee5);
        fourthDepartmentEmployees.add(employee6);
        fourthDepartmentEmployees.add(employee11);
        fourthDepartmentEmployees.add(employee12);
        fourthDepartmentEmployees.add(employee13);
        fourthDepartmentEmployees.add(employee2);
        fourthDepartmentEmployees.add(employee17);
        fourthDepartmentEmployees.add(employee18);
        fourthDepartmentEmployees.add(employee20);

        department1.setEmployees(firstDepartmentEmployees);
        department2.setEmployees(secondDepartmentEmployees);
        department3.setEmployees(thirdDepartmentEmployees);
        department4.setEmployees(fourthDepartmentEmployees);

        DepartmentDAO.save(department1);
        DepartmentDAO.save(department2);
        DepartmentDAO.save(department3);
        DepartmentDAO.save(department4);

        Controller.employeesByProject("Project1");
        Controller.projectsByCustomer(customer1);
        Controller.employeesByCustomerProjects(customer2);
        Controller.employeesByDepartmentWithoutProject(department4.getType());
        Controller.employeesByProjectEmployee(employee14);
        Controller.employeesByTeamLead(employee10);
        Controller.employeesWithoutProject();
        Controller.projectsByEmployee(employee6);
        Controller.teamLeadsByEmployee(employee12);
    }
}
