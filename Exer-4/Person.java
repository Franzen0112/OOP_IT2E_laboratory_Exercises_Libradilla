public class Person {
    protected String name;
    protected String email;
    protected String phone;
    protected String address;
    protected String dateOfBirth;
    protected String gender;
    
    public Person(String name, String email, String phone, String address, 
                 String dateOfBirth, String gender) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
    }
    
    // Polymorphic method - will be overridden in subclasses
    public String getRole() {
        return "Person";
    }
    
    // Overloaded constructor
    public Person(String name, String phone, String dateOfBirth) {
        this(name, "Not provided", phone, "Not provided", dateOfBirth, "Not specified");
    }
    
    // Method to be overridden for polymorphism
    public String performDuty() {
        return name + " is performing general duties.";
    }
    
    // Static polymorphism (method overloading)
    public String contact() {
        return "Contacting " + name + " at " + email + " or " + phone;
    }
    
    public String contact(String preferredMethod) {
        if (preferredMethod.equalsIgnoreCase("email")) {
            return "Emailing " + name + " at " + email;
        } else if (preferredMethod.equalsIgnoreCase("phone")) {
            return "Calling " + name + " at " + phone;
        } else {
            return contact();
        }
    }
    
    public String displayInfo() {
        return String.format("%s: %s, %s, %s, DOB: %s, Gender: %s", 
                            name, email, phone, address, dateOfBirth, gender);
    }
}
