public class Diagnosis extends MedicalRecord {
    private String condition;
    private String[] symptoms;
    private String severity;
    
    public Diagnosis(String recordId, Patient patient, Doctor doctor, 
                    String date, String condition, String[] symptoms, String severity) {
        super(recordId, patient, doctor, date);
        this.condition = condition;
        this.symptoms = symptoms;
        this.severity = severity;
    }
    
    // Overridden polymorphic method
    @Override
    public String getRecordType() {
        return "Diagnosis Record";
    }
    
    // Overridden method demonstrating runtime polymorphism
    @Override
    public String generateReport() {
        return "Generating diagnosis report for " + condition + " (Severity: " + severity + ")";
    }
    
    @Override
    public String displayRecord() {
        return super.displayRecord() + String.format("\nDiagnosis: %s (%s)\nSymptoms: %s", 
                            condition, severity, String.join(", ", symptoms));
    }
}
