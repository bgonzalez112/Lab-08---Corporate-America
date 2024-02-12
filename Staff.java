
public class Staff extends Employee {
    // Staff attributes and methods
    private String jobTitle;
    private String department;
    private String position;

    // Getters
    public String getJobTitle() {
        return this.jobTitle;
    }
    public String getDepartment() {
        return this.department;
    }
    public String getPosition() {
        return this.position;
    }

    // Setters
    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }
    public void setDepartment(String department) {
        this.department = department;
    }
    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public void completeJobs() {
        // Staff-specific jobs
        System.out.println("Job: Filling scream capsules on the scare floor.");
    }
}