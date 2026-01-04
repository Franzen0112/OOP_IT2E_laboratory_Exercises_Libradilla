public class MedicalStaff extends Person {
    protected String staffId;
    protected String department;
    protected String hireDate;
    
    public MedicalStaff(String name, String email, String phone, String address, 
                       String dateOfBirth, String gender, String staffId, 
                       String department, String hireDate) {
        super(name, email, phone, address, dateOfBirth, gender);
        this.staffId = staffId;
        this.department = department;
        this.hireDate = hireDate;
    }
    
    // Overridden polymorphic method
    @Override
    public String getRole() {
        return "Medical Staff";
    }
    
    // Method overloading
    public String scheduleAppointment(String patientName) {
        return "Scheduling appointment for " + patientName;
    }
    
    public String scheduleAppointment(String patientName, String date) {
        return "Scheduling appointment for " + patientName + " on " + date;
    }
    
    public String scheduleAppointment(String patientName, String date, String time) {
        return "Scheduling appointment for " + patientName + " on " + date + " at " + time;
    }
    
    @Override
    public String displayInfo() {
        return super.displayInfo() + String.format(", Staff ID: %s, Department: %s, Hire Date: %s", 
                            staffId, department, hireDate);
    }
}
