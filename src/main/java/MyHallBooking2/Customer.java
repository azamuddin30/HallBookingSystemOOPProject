package MyHallBooking2;

public class Customer {
    private String name;
    private String email;
    private String phoneNumber;

    public Customer() {

    }

    public Customer(String Name, String Email, String PhoneNumber) {
        name = Name;
        email = Email;
        phoneNumber = PhoneNumber;
    }

    // getter

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    // Setter

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
