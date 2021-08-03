package vaccimate.save;

import vaccimate.process.Appointment;

public class XML_Return {

	    public Appointment returnAppointment;
	    public Appointment returnAppointment2;

	    public XML_Return(Appointment first, Appointment second) {
	        this.returnAppointment = first;
	        this.returnAppointment2 = second;
	    }

	    public Appointment getFirst() {
	        return returnAppointment;
	    }

	    public Appointment getSecond() {
	        return returnAppointment2;
	    }
	}
