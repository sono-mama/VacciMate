package vaccimate.users;

import vaccimate.helpers.Address;
import vaccimate.helpers.Contact;

public class Patient extends User {

    private Address address;
    private int age;
    private Contact contact;
    private String insuranceType;
    private String insuranceName;
    private boolean allergies;

    public Patient(String firstName, String lastName, long id, Address address, int age, Contact contact, String insuranceType, String insuranceName, boolean allergies) {
        super(firstName, lastName, id);
        this.address = address;
        this.age = age;
        this.contact = contact;
        this.insuranceType = insuranceType;
        this.insuranceName = insuranceName;
        this.allergies = allergies;
    }

    public void setAppointment(){}

    public void cancelAppointment(){}

    public void createPDF(){}

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public String getInsuranceType() {
        return insuranceType;
    }

    public void setInsuranceType(String insuranceType) {
        this.insuranceType = insuranceType;
    }

    public String getInsuranceName() {
        return insuranceName;
    }

    public void setInsuranceName(String insuranceName) {
        this.insuranceName = insuranceName;
    }

    public boolean isAllergies() {
        return allergies;
    }

    public void setAllergies(boolean allergies) {
        this.allergies = allergies;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "address=" + address +
                ", age=" + age +
                ", contact=" + contact +
                ", insuranceType='" + insuranceType + '\'' +
                ", insuranceName='" + insuranceName + '\'' +
                ", allergies=" + allergies +
                '}';
    }
}


