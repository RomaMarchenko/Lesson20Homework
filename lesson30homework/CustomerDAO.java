package lesson30homework;

import java.util.ArrayList;

public class CustomerDAO {

    private static ArrayList<Customer> customers = new ArrayList<>();

    public static ArrayList<Customer> getCustomers() {
        return customers;
    }

    public static void save(Customer customer) {
        customers.add(customer);
    }
}
