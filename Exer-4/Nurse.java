public class Nurse extends MedicalStaff {
    private String shift;
    private boolean isRegistered;
    
    public Nurse(String name, String email, String phone, String address, 
                String dateOfBirth, String gender, String staffId, 
                String department, String hireDate, String shift, boolean isRegistered) {
        super(name, email, phone, address, dateOfBirth, gender, staffId, department, hireDate);
        this.shift = shift;
        this.isRegistered = isRegistered;
    }
    
    // Overridden polymorphic method
    @Override
    public String getRole() {
        return (isRegistered ? "Registered Nurse" : "Nurse") + " working " + shift + " shift";
    }
    
    // Overridden method demonstrating runtime polymorphism
    @Override
    public String performDuty() {
        return "Nurse " + name + " is providing patient care during the " + shift + " shift.";
    }
    
    // Method overloading for medication administration
    public String administerMedication(String medication) {
        return name + " is administering " + medication;
    }
    
    public String administerMedication(String medication, String patientName) {
        return name + " is administering " + medication + " to " + patientName;
    }
    
    public String administerMedication(String medication, String patientName, String dosage) {
        return name + " is administering " + dosage + " of " + medication + " to " + patientName;
    }
    
    public String assistDoctor(Doctor doctor) {
        return name + " is assisting Dr. " + doctor.name;
    }
    
    @Override
    public String displayInfo() {
        return super.displayInfo() + String.format(", Shift: %s, Registered: %s", 
                            shift, isRegistered);
    }
}
