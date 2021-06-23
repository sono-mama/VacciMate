package vaccimate.process;

public class Vaccine {

    private String name;
    private String brand;
    private int waitingPeriod;

    public Vaccine(String name, String brand, int waitingPeriod) {
        this.name = name;
        this.brand = brand;
        this.waitingPeriod = waitingPeriod;
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
