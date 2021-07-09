package vaccimate.users;

import vaccimate.auxiliary.Address;
import vaccimate.auxiliary.Contact;
import vaccimate.presentationLayer.Main;
import vaccimate.process.*;

import java.util.Calendar;


public class Patient extends User {

    private Address address;
    private int age;
    private Contact contact;
    private boolean allergies;


    public Patient(String firstName, String lastName, Address address, int age, Contact contact, boolean allergies) {
        super(firstName, lastName);
        this.address = address;
        this.age = age;
        this.contact = contact;
        this.allergies = allergies;
    }

    public void setAppointment(int vaccCenter, CalendarManager calendar, Patient patient, int vaccine){

        for (int i = 0; i < calendar.numberOfDays; i++){
            for (int j = 0; j < calendar.days.get(i)[vaccCenter].length; j++){
                if (calendar.days.get(i)[vaccCenter][j].isBooked() == false){
                    calendar.days.get(i)[vaccCenter][j].setPatient(patient);
                    calendar.days.get(i)[vaccCenter][j].setVaccine(Init.vaccineArray[vaccine]);
                    calendar.days.get(i)[vaccCenter][j].setCode(new CodeManager().generateCode(patient.getId(), vaccCenter, i, j));
                    calendar.days.get(i)[vaccCenter][j].setBooked(true);
                    calendar.days.get(i)[vaccCenter][j].setSite(Init.vaccinationSites[vaccCenter]);
                }
            }
        }
    }

    public void cancelAppointment(String code, CalendarManager calendar){

        int day = Character.getNumericValue(code.charAt(code.length()-1));
        int slot = Character.getNumericValue(code.charAt(code.length()-2));
        int vaccCenter = Character.getNumericValue(code.charAt(0));

        calendar.days.get(day)[vaccCenter][slot].setBooked(false);
    }

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
                ", allergies=" + allergies +
                '}';
    }
}


