package src.users;

import src.process.VaccinationSite;

public class Employee extends User {

    private VaccinationSite vaccinationSite;

    public Employee(String firstName, String lastName, VaccinationSite vaccinationSite) {
        super(firstName, lastName);
        this.vaccinationSite = vaccinationSite;

    }

}
