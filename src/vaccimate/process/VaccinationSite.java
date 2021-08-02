package vaccimate.process;

import vaccimate.auxiliary.Address;
import vaccimate.auxiliary.Contact;

public class VaccinationSite {

    private String name;
    private Vaccine firstVaccine;
    private Vaccine secondVaccine;
    private Vaccine[] availVaccine;
    private Address address;
    private Contact contact;

    public VaccinationSite(String name, Vaccine firstVaccine, Vaccine secondVaccine, Address address, Contact contact) {
        this.name = name;
        this.availVaccine = new Vaccine[]{firstVaccine, secondVaccine};
        this.address = address;
        this.contact = contact;
        this.firstVaccine = firstVaccine;
        this.secondVaccine = secondVaccine;
    }

    public Vaccine getFirstVaccine() {
        return firstVaccine;
    }

    public void setFirstVaccine(Vaccine firstVaccine) {
        this.firstVaccine = firstVaccine;
    }

    public Vaccine getSecondVaccine() {
        return secondVaccine;
    }

    public void setSecondVaccine(Vaccine secondVaccine) {
        this.secondVaccine = secondVaccine;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Vaccine[] getAvailVaccine() {
        return availVaccine;
    }

    public void setAvailVaccine(Vaccine[] availVaccine) {
        this.availVaccine = availVaccine;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }


}
