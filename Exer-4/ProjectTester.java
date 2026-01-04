public class ProjectTester {
    public static void main(String[] args) {
        System.out.println("=== HUMAN CLINIC SYSTEM - POLYMORPHISM DEMONSTRATION ===");
        
        // Create medical staff
        Doctor doctor = new Doctor("Ronie Manaongsong", "ronie@humanclinic.com", 
                                  "555-1234", "Martinez phase 11", "2005-05-15", "Memale", 
                                  "DOC001", "Cardiology", "2010-03-20", 
                                  "Cardiologist", "MD12345", 15);
        
        Nurse nurse = new Nurse("Dec Butong", "dec@humanclinic.com", 
                               "555-5678", "Martinez phase 4", "1985-08-22", "Male", 
                               "NUR001", "Cardiology", "2015-06-10", 
                               "Day", true);
        
        // Create patients
        String[] johnAllergies = {"Penicillin", "Shellfish"};
        Patient patient1 = new Patient("John Doe", "john@email.com", "555-9012", 
                                      "789 Elm St", "1975-12-10", "Male", 
                                      "PAT001", "O+", johnAllergies, 
                                      "Jane Doe (555-0000)", "Blue Cross");
        
        String[] maryAllergies = {};
        Patient patient2 = new Patient("Mary Smith", "mary@email.com", "555-3456", 
                                      "321 Maple St", "1988-07-03", "Female", 
                                      "PAT002", "A-", maryAllergies, 
                                      "John Smith (555-1111)", "Aetna");
        
        // Create medical records
        String[] johnSymptoms = {"Chest pain", "Shortness of breath"};
        Diagnosis diagnosis = new Diagnosis("REC001", patient1, doctor, 
                                           "2023-10-15", "Angina", johnSymptoms, "Moderate");
        
        String[] medications = {"Aspirin", "Nitroglycerin"};
        String[] procedures = {"Stress test", "Echocardiogram"};
        TreatmentPlan treatment = new TreatmentPlan("REC002", patient1, doctor, 
                                                   "2023-10-15", medications, procedures, 
                                                   "2023-11-15");
        
        // Create appointments
        Consultation consultation = new Consultation("APT001", patient1, doctor, 
                                                    "2023-10-20", "10:00 AM", 
                                                    "Follow-up for angina", 30);
        
        Procedure procedure = new Procedure("APT002", patient2, doctor, 
                                           "2023-10-25", "2:00 PM", 
                                           "Cardiac catheterization", true, 120);
        
        // ===== POLYMORPHISM DEMONSTRATIONS =====
        
        System.out.println("\n=== 1. METHOD OVERRIDING (RUNTIME POLYMORPHISM) ===");
        
        // Using base class references to demonstrate runtime polymorphism
        Person[] people = {doctor, nurse, patient1, patient2};
        for (Person person : people) {
            System.out.println(person.getRole() + " - " + person.performDuty());
        }
        
        System.out.println("\n=== 2. METHOD OVERLOADING (COMPILE-TIME POLYMORPHISM) ===");
        
        // Demonstrating method overloading
        System.out.println(doctor.prescribeMedication("Aspirin"));
        System.out.println(doctor.prescribeMedication("Aspirin", "100mg"));
        System.out.println(doctor.prescribeMedication("Aspirin", "100mg", 30));
        
        System.out.println(nurse.administerMedication("Insulin"));
        System.out.println(nurse.administerMedication("Insulin", "Mary Smith"));
        System.out.println(nurse.administerMedication("Insulin", "Mary Smith", "10 units"));
        
        System.out.println("\n=== 3. DYNAMIC METHOD DISPATCH ===");
        
        // MedicalRecord polymorphism
        MedicalRecord[] records = {diagnosis, treatment};
        for (MedicalRecord record : records) {
            System.out.println(record.getRecordType() + ": " + record.generateReport());
        }
        
        // Appointment polymorphism
        Appointment[] appointments = {consultation, procedure};
        for (Appointment appointment : appointments) {
            System.out.println(appointment.getAppointmentType() + ": " + appointment.conductAppointment());
        }
        
        System.out.println("\n=== 4. CONSTRUCTOR OVERLOADING ===");
        
        // Using overloaded constructor
        Person simplePerson = new Person("Test Person", "555-9999", "1990-01-01");
        System.out.println("Simple person created: " + simplePerson.displayInfo());
        
        System.out.println("\n=== 5. CONTACT METHOD OVERLOADING ===");
        
        // Testing overloaded contact methods
        System.out.println(doctor.contact());
        System.out.println(doctor.contact("email"));
        System.out.println(doctor.contact("phone"));
        
        System.out.println("\n=== 6. SCHEDULING OVERLOADING ===");
        
        // Testing overloaded scheduling methods
        System.out.println(nurse.scheduleAppointment("John Doe"));
        System.out.println(nurse.scheduleAppointment("John Doe", "2023-11-01"));
        System.out.println(nurse.scheduleAppointment("John Doe", "2023-11-01", "2:00 PM"));
        
        System.out.println("\n=== 7. RESCHEDULE OVERLOADING ===");
        
        // Testing overloaded reschedule methods
        System.out.println(consultation.reschedule("2023-10-21"));
        System.out.println(procedure.reschedule("2023-10-26", "3:00 PM"));
        
        System.out.println("\n=== 8. UPDATE INFO OVERLOADING ===");
        
        // Testing overloaded update methods
        System.out.println(patient1.updateInfo("555-9999"));
        System.out.println(patient2.updateInfo("555-8888", "New Address"));
        
        System.out.println("\n=== 9. DETAILED INFORMATION ===");
        
        // Display detailed information
        System.out.println("\n=== MEDICAL STAFF ===");
        System.out.println(doctor.displayInfo());
        System.out.println(nurse.displayInfo());
        
        System.out.println("\n=== PATIENTS ===");
        System.out.println(patient1.displayInfo());
        System.out.println(patient1.listAllergies());
        System.out.println(patient2.displayInfo());
        System.out.println(patient2.listAllergies());
        
        System.out.println("\n=== MEDICAL RECORDS ===");
        System.out.println(diagnosis.displayRecord());
        System.out.println("\n" + treatment.displayRecord());
        
        System.out.println("\n=== APPOINTMENTS ===");
        System.out.println(consultation.displayAppointment());
        System.out.println("\n" + procedure.displayAppointment());
        
        System.out.println("\n=== POLYMORPHISM DEMONSTRATION COMPLETED SUCCESSFULLY ===");
    }
    
    // Utility method to demonstrate polymorphism with parameters
    public static void processPerson(Person person) {
        System.out.println("Processing: " + person.getRole());
    }
    
    public static void processRecord(MedicalRecord record) {
        System.out.println("Record Type: " + record.getRecordType());
    }
    
    public static void processAppointment(Appointment appointment) {
        System.out.println("Appointment Type: " + appointment.getAppointmentType());
    }
}
