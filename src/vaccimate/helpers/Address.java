package vaccimate.helpers;

public class Address {

    private String streetName;
    private int streetNo;
    private int postalCode;
    private String city;
    private String state;

    public Address(String streetName, int streetNo, int postalCode, String city, String state) {
        this.streetName = streetName;
        this.streetNo = streetNo;
        this.postalCode = postalCode;
        this.city = city;
        this.state = state;
    }

    @Override
    public String toString() {
        return "Address{" +
                "streetName='" + streetName + '\'' +
                ", streetNo=" + streetNo +
                ", postalCode=" + postalCode +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                '}';
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public int getStreetNo() {
        return streetNo;
    }

    public void setStreetNo(int streetNo) {
        this.streetNo = streetNo;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
