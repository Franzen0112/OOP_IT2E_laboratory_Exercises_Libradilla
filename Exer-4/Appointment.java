public class Appointment {
    protected String appointmentId;
    protected Patient patient;
    protected Doctor doctor;
    protected String date;
    protected String time;
    
    public Appointment(String appointmentId, Patient patient, Doctor doctor, 
                      String date, String time) {
        this.appointmentId = appointmentId;
        this.patient = patient;
        this.doctor = doctor;
        this.date = date;
        this.time = time;
    }
    
    // Polymorphic method to be overridden
    public String getAppointmentType() {
        return "General Appointment";
    }
    
    // Method demonstrating runtime polymorphism
    public String conductAppointment() {
        return "Conducting general appointment " + appointmentId;
    }
    
    // Method overloading
    public String reschedule(String newDate) {
        this.date = newDate;
        return "Appointment rescheduled to " + newDate;
    }
    
    public String reschedule(String newDate, String newTime) {
        this.date = newDate;
        this.time = newTime;
        return "Appointment rescheduled to " + newDate + " at " + newTime;
    }
    
    public String displayAppointment() {
        return String.format("Appointment %s: %s with Dr. %s on %s at %s", 
                            appointmentId, patient.name, doctor.name, date, time);
    }
}
