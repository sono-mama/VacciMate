package vaccimate.presentationLayer;

import vaccimate.auxiliary.Address;
import vaccimate.auxiliary.Contact;
import vaccimate.process.Timeslot;
import vaccimate.process.VaccinationSite;
import vaccimate.process.Vaccine;

public class Main {

    public static void main(String[] args) {
	// write your code here



        Vaccine bioNTech = new Vaccine("Comirnaty", "Pfizer-BioNTech", 6, 2);
        Vaccine moderna = new Vaccine("Moderna Covid-19", "Moderna", 6, 2);
        Vaccine astraZeneca = new Vaccine("Covishield", "AstraZeneca", 12, 2);
        Vaccine johnsonJohnson = new Vaccine("Janssen COVID-19 Vaccine", "Janssen Pharmaceutica", 0, 1);

        Address arenaAdd = new Address("Eichenstr.", "4", "12435", "Berlin");
        Address erikaHessAdd = new Address("Müllerstr.", "185", "13353", "Berlin");
        Address tegelAdd = new Address("Saatwinklerdamm, Terminal C", "", "13405", "Berlin");
        Address tempelhofAdd = new Address(" Tempelhoferdamm", "57", "12101", "Berlin");
        Address messeAdd = new Address("Hammarskjöldplatz", "5", "14055", "Berlin");
        Address velodromAdd = new Address("Paul-Heyse-Str.", "26", "10407", "Berlin");

        Contact vaccSiteContact = new Contact("(030)9028-2200", "", "");

        VaccinationSite arenaBerlin = new VaccinationSite("Arena Berlin", bioNTech, null, arenaAdd, vaccSiteContact);
        VaccinationSite erikaHess = new VaccinationSite("Erika-Hess-Eisstadion", moderna, null, erikaHessAdd, vaccSiteContact);
        VaccinationSite tegel = new VaccinationSite("Flughafen Tegel", bioNTech, moderna, tegelAdd, vaccSiteContact);
        VaccinationSite tempelhof = new VaccinationSite("Flughafen Tempelhof", moderna, astraZeneca, tempelhofAdd, vaccSiteContact);
        VaccinationSite messeBerlin = new VaccinationSite("Messe Berlin", bioNTech, null, messeAdd, vaccSiteContact);
        VaccinationSite velodrom = new VaccinationSite("Velodrom", bioNTech, null, velodromAdd, vaccSiteContact);

        Timeslot[] berlinVaccCenters = new Timeslot[6];
        berlinVaccCenters[0] = new Timeslot(arenaBerlin, 30);
        berlinVaccCenters[1] = new Timeslot(erikaHess, 30);
        berlinVaccCenters[2] = new Timeslot(tegel, 30);
        berlinVaccCenters[3] = new Timeslot(tempelhof, 30);
        berlinVaccCenters[4] = new Timeslot(messeBerlin, 30);
        berlinVaccCenters[5] = new Timeslot(velodrom, 30);


    }
}
