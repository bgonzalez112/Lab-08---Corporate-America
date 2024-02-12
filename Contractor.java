
public class Contractor extends Employee implements Freelancer {
    // Contractor attributes and methods

    @Override
    public void completeJobs() {
        // Contractor-specific jobs
        System.out.println("Job: Completeing maintenance work.");
    }

    @Override
    public void completeTask() {
        // Contractor-specific task from Freelancer interface
        System.out.println("Project: Scream Extractor");
    }
}