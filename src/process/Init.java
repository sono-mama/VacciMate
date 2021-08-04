package src.process;

import src.auxiliary.Address;
import src.auxiliary.Contact;
import src.users.Doctor;
import src.users.Reception;

public class Init {

    /*
    The non-existence of a database makes it necessary to include certain data (e.g. vaccine centers,
    addresses, doctors or reception staff directly into the code. To keep the Main class more clean, this
    data has been included in this class which gets initialized upon program start. In a real world scenario
    this would be handled in a different way.
    */

    public static Vaccine[] vaccineArray = new Vaccine[3];
    public static Address[] addressArray = new Address[6];
    public static VaccinationSite[] vaccinationSites = new VaccinationSite[6];
    public static Doctor[] doctors = new Doctor[6];
    public static Reception[] receptionStaff = new Reception[6];

    public Init() {
        init(vaccineArray, addressArray, vaccinationSites, doctors, receptionStaff);
    }

    public void init(Vaccine[] vaccineArray, Address[] addressArray, VaccinationSite[] vaccinationSites, Doctor[] doctors, Reception[] receptionStaff){
        initVaccines(vaccineArray);
        initAddress(addressArray);
        initVaccCenters(vaccinationSites, vaccineArray, addressArray);
        initDoctors(doctors, vaccinationSites);
        initReceptionStaff(receptionStaff, vaccinationSites);
    }

    public void initVaccines(Vaccine[] vaccineArray){
        // currently used vaccines in the vaccination centers
        String[] vaccineName = {"Comirnaty", "Spikevax", "Vaxzevria"};
        String[] vaccineBrand = {"Pfizer-BioNTech", "Moderna", "AstraZeneca"};
        int[] vaccineWaitingPeriod = {42, 42 , 84};

        for(int i = 0; i < 3; i++) {
            vaccineArray[i] = new Vaccine(vaccineName[i], vaccineBrand[i], vaccineWaitingPeriod[i]);
        }
    }

    public void initAddress(Address[] addressArray){
        // currently operating vaccination centers in Berlin. See: https://service.berlin.de/standorte/impfzentren/
        String[] streetName = {"Eichenstr.", "Müllerstr.", "Saatwinklerdamm", "Terminal C", "Tempelhoferdamm", "Hammarskjöldplatz", "Paul-Heyse-Str."};
        String[] streetNo = {"4", "185", "", "57", "5", "26"};
        String[] postalCode = {"12435", "13353", "13405", "12101", "14055", "10407"};
        String[] city = {"Berlin"};

        for (int i = 0; i < 6; i++){
            addressArray[i] = new Address(streetName[i], streetNo[i],postalCode[i], city[0]);
        }

    }

    public void initVaccCenters(VaccinationSite[] vaccinationSites, Vaccine[] vaccineArray, Address[] addressArray){
    	/*
         vaccinationSites[0]: Arena Berlin
         vaccinationSites[1]: Erika Hess Eisstadion
         vaccinationSites[2]: Flughafen Tegel
         vaccinationSites[3]: Flughafen Tempelhof
         vaccinationSites[4]: Messe Berlin
         vaccinationSites[5]: Velodrom
        */

        Contact vaccSiteContact = new Contact("(030)9028-2200", "", "");
        String[] vaccinationCenterNames = {"Arena Berlin", "Erika-Hess-Eisstadion", "Flughafen Tegel", "Flughafen Tempelhof", "Messe Berlin", "Velodrom"};

        vaccinationSites[0] = new VaccinationSite(vaccinationCenterNames[0], vaccineArray[0], null, addressArray[0], vaccSiteContact);
        vaccinationSites[1] = new VaccinationSite(vaccinationCenterNames[1], vaccineArray[1], null, addressArray[1], vaccSiteContact);
        vaccinationSites[2] = new VaccinationSite(vaccinationCenterNames[2], vaccineArray[1], vaccineArray[0], addressArray[2], vaccSiteContact);
        vaccinationSites[3] = new VaccinationSite(vaccinationCenterNames[3], vaccineArray[1], vaccineArray[2], addressArray[3], vaccSiteContact);
        vaccinationSites[4] = new VaccinationSite(vaccinationCenterNames[4], vaccineArray[0], null, addressArray[4], vaccSiteContact);
        vaccinationSites[5] = new VaccinationSite(vaccinationCenterNames[5], vaccineArray[0], null, addressArray[5], vaccSiteContact);
    }

    public void initDoctors(Doctor[] doctors, VaccinationSite[] vaccinationSites){

        String[] firstNames = {"Max", "Mohammed", "Charly", "Richard", "Franziska", "Kerstin"};
        String[] lastNames = {"Müller", "Mayer", "Jackson", "Rickson", "Franziskus", "Schneider"};

        for(int i = 0; i < 6; i++){
            doctors[i] = new Doctor(firstNames[i], lastNames[i], vaccinationSites[i]);
        }
    }

    public void initReceptionStaff(Reception[] receptionStaff, VaccinationSite[] vaccinationSites){

        String[] firstNames = {"Sandra", "Phuong", "Mike", "Marta", "Sarah", "Chris"};
        String[] lastNames = {"Müller", "Tran", "Jackson", "Martason", "Meyer", "Schneider"};

        for(int i = 0; i < 6; i++){
            receptionStaff[i] = new Reception(firstNames[i], lastNames[i], vaccinationSites[i]);
        }

    }

    public VaccinationSite[] getVaccinationSites() {
        return vaccinationSites;
    }
    
    public Doctor[] getDoctors() {
        return doctors;
    }
    
    public Reception[] getReceptionStaff() {
        return receptionStaff;
    }

}


