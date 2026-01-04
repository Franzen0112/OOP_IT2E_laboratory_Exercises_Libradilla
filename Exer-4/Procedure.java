public class Procedure extends Appointment {
    private String procedureType;
    private boolean anesthesiaRequired;
    private int recoveryTime;
    
    public Procedure(String appointmentId, Patient patient, Doctor doctor, 
                    String date, String time, String procedureType, 
                    boolean anesthesiaRequired, int recoveryTime) {
        super(appointmentId, patient, doctor, date, time);
        this.procedureType = procedureType;
        this.anesthesiaRequired = anesthesiaRequired;
        this.recoveryTime = recoveryTime;
    }
    
    // Overridden polymorphic method
    @Override
    public String getAppointmentType() {
        return "Procedure Appointment";
    }
    
    // Overridden method demonstrating runtime polymorphism
    @Override
    public String conductAppointment() {
        return "Performing procedure: " + procedureType + " (Anesthesia: " + anesthesiaRequired + ", Recovery: " + recoveryTime + " mins)";
    }
    
    @Override
    public String displayAppointment() {
        return super.displayAppointment() + String.format("\nProcedure: %s, Anesthesia: %s, Recovery: %d minutes", 
                            procedureType, anesthesiaRequired, recoveryTime);
    }
}
