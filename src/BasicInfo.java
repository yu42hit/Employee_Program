public class BasicInfo {

    private String firstName = null;
    private String lastName = null;
    private String department = null;
    private String phone = null;
    private String address = null;
    private String email = null;
    private String position = null;

    public void setFirstName(String f) {

        firstName = f;

    }

    public void setLastName(String l) {

        lastName = l;

    }

    public void setDepartment(String d) {

        department = d;

    }

    public void setPhone(String p) {

        phone = p;

    }

    public void setAddress(String a) {

        address = a;

    }

    public void setEmail(String e) {

        email = e;

    }

    public void setPosition(String p) {

        position = p;

    }

    public String getFirstName() {

        return firstName;

    }

    public String getLastName() {

        return lastName;

    }

    public String getDepartment() {

        return department;

    }

    public String getPhone() {

        return phone;

    }

    public String getAddress() {

        return address;

    }

    public String getEmail() {

        return email;

    }

    public String getPosition() {

        return position;

    }

    public String toString() {

        return ("Name: " + lastName + ", " + firstName + "\nDepartment: " + department + "\nPhone: " + phone + "\nAddress: " + address + "\nEmail: " + email + "\nPosition: " + position);

    }

}
