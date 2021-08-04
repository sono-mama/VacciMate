package src.process;

import src.users.Patient;

public class Vaccine {

    private String name;
    private String brand;
    private int waitingPeriod;

    public Vaccine(String name, String brand, int waitingPeriod) {
        this.name = name;
        this.brand = brand;
        this.waitingPeriod = waitingPeriod;
    }

    public boolean eligiblityCheck(Patient patient){

        /* function to check if the patient is eligible for receiving the selected vaccine.
        Representing the current guidelines by RKI and STIKO. This function is subject to change
        should the underlying guidelines change. (See RKI and STIKO websites)
        */

        boolean eligibility;

        if (patient.getAge() < 12){
            System.out.println("Für Kinder unter 12 Jahren gibt es aktuell keine Impfempehlung des RKI. " +
                    "Eine Terminvergabe ist leider nicht möglich.");
            eligibility = false;
        } else if (patient.getAge() < 18){
            System.out.println(
                    "Für Kinder und Jugendliche unter 18 Jahren gibt es aktuell keine allgemeine Impfempfehlung " +
                    "des RKI. Unter bestimmten Bedingungen kann eine Impfung aber trotzdem erfolgen. Bitte informieren " +
                    "sie sich auf der Website des RKI: " +
                    "https://www.rki.de/DE/Content/Infekt/Impfen/ImpfungenAZ/COVID-19/Infoblatt_Impfung_Kinder_und_Jugendliche.pdf?__blob=publicationFile \n" +
                    "Bei vorliegen einer Impfberechtigung legen sie diese bitte bei ihrem Termin vor."
            );
            eligibility = true;
        } else if (patient.getAge() < 60 && this.name.equals("Vaxzevria")){
            System.out.println(
                    "Die ständige Impfkomission (STIKO) empfiehlt die gabe von AstraZeneca Vaxzevria an über 60 Jährige " +
                    "eine Impfung von Personen unter 60 kann trotzdem erfolgen, wenn es vorher zu einer Risikoanalyse " +
                    "durch den Patienten und den betreuenden Arzt kommt. Sie werden durch den Arzt im Impfzentrum beraten. " +
                    "Unter Umständen kann es nötig sein, die zweite Impfung mit einem anderen Impfstoff durchzuführen."
            );
            eligibility = true;
        } else {
            eligibility = true;
        }
        return eligibility;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getWaitingPeriod() {
        return waitingPeriod;
    }

    public void setWaitingPeriod(int waitingPeriod) {
        this.waitingPeriod = waitingPeriod;
    }


    @Override
    public String toString() {
        return "Vaccine{" +
                "name='" + name + '\'' +
                ", brand='" + brand + '\'' +
                ", waitingPeriod=" + waitingPeriod +
                ", noOfShots=" +
                '}';
    }
}
