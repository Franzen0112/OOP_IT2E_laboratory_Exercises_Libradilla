public class Doctor extends MedicalStaff {
    private String specialization;
    private String licenseNumber;
    private int yearsExperience;
    
    public Doctor(String name, String email, String phone, String address, 
                 String dateOfBirth, String gender, String staffId, 
                 String department, String hireDate, String specialization, 
                 String licenseNumber, int yearsExperience) {
        super(name, email, phone, address, dateOfBirth, gender, staffId, department, hireDate);
        this.specialization = specialization;
        this.licenseNumber = licenseNumber;
        this.yearsExperience = yearsExperience;
    }
    
    // Overridden polymorphic method
    @Override
    public String getRole() {
        return "Doctor specializing in " + specialization;
    }
    
    // Overridden method demonstrating runtime polymorphism
    @Override
    public String performDuty() {
        return "Dr. " + name + " is diagnosing patients in the " + department + " department.";
    }
    
    // Method overloading for prescribing medication
    public String prescribeMedication(String medication) {
        return "Dr. " + name + " is prescribing " + medication;
    }
    
    public String prescribeMedication(String medication, String dosage) {
        return "Dr. " + name + " is prescribing " + medication + " at dosage " + dosage;
    }
    
    public String prescribeMedication(String medication, String dosage, int duration) {
        return "Dr. " + name + " is prescribing " + medication + " at dosage " + dosage + " for " + duration + " days";
    }
    
    public String examinePatient(Patient patient) {
        return "Dr. " + name + " is examining " + patient.name;
    }
    
    @Override
    public String displayInfo() {
        return super.displayInfo() + String.format(", Specialization: %s, License: %s, Experience: %d years", 
                            specialization, licenseNumber, yearsExperience);
    }
}
