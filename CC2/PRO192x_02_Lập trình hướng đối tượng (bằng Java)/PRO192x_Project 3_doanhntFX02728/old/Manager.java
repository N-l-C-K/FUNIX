public class Manager extends Staff {
    private String jobTitle;    //chức danh

    //Constructor
    public Manager(int staffId, String staffName, int staffAge, double coefficientsSalary, int workStartDate, String department, int annualLeave, String jobTitle) {
        super(staffId, staffName, staffAge, coefficientsSalary, workStartDate, department, annualLeave);
        this.jobTitle = jobTitle;
    }

    //Getter + Setter
    public void setJobTitle(String jobTitle) { this.jobTitle = jobTitle; }
    public String getJobTitle() { return jobTitle; }

    @Override
    public void displayInformation() {
        
    }
}
