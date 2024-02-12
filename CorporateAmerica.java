import java.util.Scanner;

public class CorporateAmerica {
   // CorporateAmerica attributes and methods
   private String companyName;
   private Employer employer;
   
   // Getters
   public String getCompanyName() {
      return this.companyName;
   }
   public Employer getEmployer() {
      return this.employer;
   }

   // Setters
   public void setCompanyName(String companyName) {
      this.companyName = companyName;
   }
   public void setEmployer(Employer employer) {
      this.employer = employer;
   }

   // Method to create an employee based on the type
   private static Employee createEmployee(String type, String name, String id, String jobTitle, String department, String position, Employer employer) {
      Employee employee;
      switch (type) {
          case "Manager":
              employee = new Manager();
              break;
          case "Staff":
              Staff staff = new Staff();
              staff.setJobTitle(jobTitle);
              staff.setDepartment(department);
              staff.setPosition(position);
              employee = staff;
              break;
          case "Contractor":
              employee = new Contractor();
              break;
          default:
              throw new IllegalArgumentException("Invalid employee type: " + type);
      }
      employee.setName(name);
      employee.setId(id);
      employee.setEmployer(employer);
      return employee;
  }

  // Method to display the details of an employee
  private static void displayEmployeeDetails(Employee employee) {
   System.out.println("\nEmployer: " + employee.getEmployer().getName());
   System.out.println("Name: " + employee.getName());
   System.out.println("ID: " + employee.getId());

   // Checking the type of employee and displaying the additional details
   if (employee instanceof Manager) {
       System.out.println("Type: Manager");
   } else if (employee instanceof Staff) {
       System.out.println("Type: Staff");
       Staff staff = (Staff) employee;
       System.out.println("Job Title: " + staff.getJobTitle());
       System.out.println("Department: " + staff.getDepartment());
       System.out.println("Position: " + staff.getPosition());
   } else if (employee instanceof Contractor) {
       System.out.println("Type: Contractor");
       Contractor contractor = (Contractor) employee;
       contractor.completeTask();
   } else {
       System.out.println("Type: Unknown");
   }
   employee.completeJobs();
}

  public static void main(String [] args) {
      // Setting up a Scanner for user input
      Scanner scanner = new Scanner(System.in);
      
      // Welcome message
      System.out.println("\nWelcome to Corporate America!");

      // Creating the company
      CorporateAmerica company = new CorporateAmerica();
      company.setCompanyName("Monsters Inc.");
      System.out.println("Company: " + company.getCompanyName());

      // Creating an employer
      Employer employer = new Employer();
      employer.setName("Henry J. Waternoose");

      // Loading data into the objects 
      // Creating the manager, staff, and contractor objects
      Employee manager = createEmployee("Manager", "Roz Peterson", "001", "", "", "", employer);
      Employee staff1 = createEmployee("Staff", "James P. Sullivan", "0001", "Scarer", "Scare Floor", "Top Scarer", employer);
      Employee staff2 = createEmployee("Staff", "Mike Wazowski", "0002", "Scarer", "Scare Floor", "Scarer", employer);
      Employee contractor = createEmployee("Contractor", "Randall Boggs", "0013", "", "", "", employer);

      // Adding the employees to the employer's list
      employer.getEmployees().add(manager);
      employer.getEmployees().add(staff1);
      employer.getEmployees().add(staff2);
      employer.getEmployees().add(contractor);
      
      // Menu loop
      while (true) {
         // Displaying the menu
         System.out.println("\nAvailable Actions: ");
         System.out.println("1. Check an employee");
         System.out.println("2. Exit");
         System.out.print("\nEnter your choice: ");

         // Reading the user's choice
         int choice = scanner.nextInt();

         // If-statement to handle the user's choice
         if (choice == 1) {
            // Displaying the employees
            System.out.println("\nEmployees:");
            for (int i = 0; i < employer.getEmployees().size(); i++) {
               System.out.println((i + 1) + ". " + employer.getEmployees().get(i).getName());
            }

            // Reading the user's choice of employee
            System.out.print("\nEnter the number of the employee to check: ");
            int employeeNumber = scanner.nextInt();

            // Displaying the employee's details
            Employee employee = employer.getEmployees().get(employeeNumber - 1);
            displayEmployeeDetails(employee);
         // If the user enters 2, exit the program
         } else if (choice == 2) {
            // Goodbye message
            System.out.println("\nHave a nice day!");
            break;
         // Exception handling
         } else {
            System.out.println("Invalid choice. Please try again.");
         }
      }
      // Closing the scanner
      scanner.close();
   }
}
