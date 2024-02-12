import java.util.List;
import java.util.ArrayList;

public class Employer extends Person {
    // Employer attributes
    private List<Employee> employees;

    // Constructor
    public Employer() {
        this.employees = new ArrayList<>();
    }

    // Add employee to list of employees
    public List<Employee> getEmployees() {
        return this.employees;
    }
}