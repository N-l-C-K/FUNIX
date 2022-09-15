public abstract class Staff {
    private int staffId;                //mã nhân viên
    private String staffName;           //tên nhân viên
    private int staffAge;               //tuổi nhân viên
    private double coefficientsSalary;  //hệ số lương
    private int workStartDate;          //Ngày vào làm
    private String department;          //bộ phận làm việc
    private int annualLeave;            //số ngày nghỉ phép

    //Constructor
    public Staff(int staffId, String staffName, int staffAge, double coefficientsSalary, int workStartDate, String department, int annualLeave) {
        this.staffId = staffId;
        this.staffName = staffName;
        this.staffAge = staffAge;
        this.coefficientsSalary = coefficientsSalary;
        this.workStartDate = workStartDate;
        this.department = department;
        this.annualLeave = annualLeave;
    } 

    //Getter + Setter
    public void setStaffId(int staffId) { this.staffId = staffId; }
    public int getStaffId() { return staffId; }

    public void setStaffName(String staffName) { this.staffName = staffName; }
    public String setStaffName() { return staffName; }

    public void setStaffAge(int staffAge) { this.staffAge = staffAge; }
    public int getStaffAge() { return staffAge; }

    public void setCoefficientSalary(double coefficientsSalary) { this.coefficientsSalary = coefficientsSalary; }
    public double getCoefficientSalary() { return coefficientsSalary; }

    public void setWorkStartDate(int workStartDate) { this.workStartDate = workStartDate; }
    public int getWorkStartDate() { return workStartDate; }

    public void setDepartment(String department) { this.department = department; }
    public String getDepartment() { return department }

    public void setAnnualLeave(int annualLeave) { this.annualLeave = annualLeave; }
    public int getAnnualLeave() { return annualLeave; }

    public abstract void displayInformation() {}
}
