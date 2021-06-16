package vaccimate.auxiliary;

public class Contact {

    private int telephoneNo;
    private int mobileNo;
    private String email;

    public Contact(int telephoneNo, int mobileNo, String email) {
        this.telephoneNo = telephoneNo;
        this.mobileNo = mobileNo;
        this.email = email;
    }

    public int getTelephoneNo() {
        return telephoneNo;
    }

    public void setTelephoneNo(int telephoneNo) {
        this.telephoneNo = telephoneNo;
    }

    public int getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(int mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "telephoneNo=" + telephoneNo +
                ", mobileNo=" + mobileNo +
                ", email='" + email + '\'' +
                '}';
    }
}
