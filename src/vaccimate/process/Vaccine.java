package vaccimate.process;

public class Vaccine {

    private String name;
    private String brand;
    private int waitingPeriod;
    private int noOfShots;

    public Vaccine(String name, String brand, int waitingPeriod, int noOfShots) {
        this.name = name;
        this.brand = brand;
        this.waitingPeriod = waitingPeriod;
        this.noOfShots = noOfShots;
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

    public int getNoOfShots() {
        return noOfShots;
    }

    public void setNoOfShots(int noOfShots) {
        this.noOfShots = noOfShots;
    }

    @Override
    public String toString() {
        return "Vaccine{" +
                "name='" + name + '\'' +
                ", brand='" + brand + '\'' +
                ", waitingPeriod=" + waitingPeriod +
                ", noOfShots=" + noOfShots +
                '}';
    }
}
