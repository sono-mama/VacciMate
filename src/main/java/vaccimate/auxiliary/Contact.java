package vaccimate.auxiliary;

public class Contact {

    private String telephoneNo;
    private String mobileNo;
    private String email;

    public Contact(String telephoneNo, String mobileNo, String email) {
        this.telephoneNo = telephoneNo;
        this.mobileNo = mobileNo;
        this.email = email;
    }

    public String getTelephoneNo() {
        return telephoneNo;
    }

    public void setTelephoneNo(String telephoneNo) {
        this.telephoneNo = telephoneNo;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
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
                "telephoneNo='" + telephoneNo + '\'' +
                ", mobileNo='" + mobileNo + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
