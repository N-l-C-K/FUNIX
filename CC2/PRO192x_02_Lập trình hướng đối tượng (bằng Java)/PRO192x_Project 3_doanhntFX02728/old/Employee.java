public class Employee extends Staff {
    private int overtimeHours;

    //Constructor
    public Employee(int staffId, String staffName, int staffAge, double coefficientsSalary, int workStartDate, String department, int annualLeave) {
        super(staffId, staffName, staffAge, coefficientsSalary, workStartDate, department, annualLeave);
    }

    public void setOvertimesHours(int overtimeHours) {
        this.overtimeHours = overtimeHours;
    } 

    public int getOvertimesHours() {
        return overtimeHours;
    }

    public int calculateSalary() {
        return super.getCoefficientSalary() * 3000000 + overtimeHours * 200000;
    }

    @Override
    public void displayInformation() {

    }
}
