package core;

public class UserDetails {

    String firstName;
    String lastName;
    String zipCode;

    public UserDetails(String firstName, String lastName, String zipCode) {
        setFirstName(firstName);
        setLastName(lastName);
        setZipCode(zipCode);
    }

    public String getFirstName() {
        return firstName;
    }

    private void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    private void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getZipCode() {
        return zipCode;
    }

    private void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
}
