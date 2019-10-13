package lesson30homework;

import java.util.ArrayList;
import java.util.Date;

public class Firm {
    private Date dateFounded;
    private ArrayList<Department> departments;
    private ArrayList<Customer> customers;

    public Firm(Date dateFounded, ArrayList<Department> departments, ArrayList<Customer> customers) {
        this.dateFounded = dateFounded;
        this.departments = departments;
        this.customers = customers;
    }

    public Date getDateFounded() {
        return dateFounded;
    }

    public ArrayList<Department> getDepartments() {
        return departments;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }
}
