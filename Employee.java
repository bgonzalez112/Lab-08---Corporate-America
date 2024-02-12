
public abstract class Employee extends Person {
    // Employee attributes and methods
    private Employer employer;
    private String id;

    // Getters
    public String getId() {
        return this.id;
    }
    public Employer getEmployer() {
        return this.employer;
    }

    // Setters
    public void setEmployer(Employer employer) {
        this.employer = employer;
    }
    public void setId(String id) {
        this.id = id;
    }

    // Abstract method
    public abstract void completeJobs();
}