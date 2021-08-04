package src.save;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import src.process.Vaccine;

public class XML_WriteAppointment {

	private final static String DATNAM = "XML_Appointment.xml";

	private final static File FILE = new File(DATNAM);

	 public Document createDocAppointment(String rootElementAppointment) {
		Document docAppointment = new Document();
		Element rootAppointment = new Element(rootElementAppointment);
		docAppointment.setRootElement(rootAppointment);
		return docAppointment;
	}
	
	public void writeDocAppointment(Document docAppointment, String c, String d, String p, String vCN, Vaccine v, String isB, String vGiven, String pDC, String sT) {
		
		Element Appointment = new Element ("Appointment");
		
		Element code = new Element("code");
		code.setText(c);
		Appointment.addContent(code);
        
        Element date = new Element("date");
        date.setText(d);
        Appointment.addContent(date);
        
        Element patientID = new Element("patientID");
        patientID.setText(p);
        Appointment.addContent(patientID);
        
        Element vaccineCenterNumber = new Element("vaccineCenterNumber");
        vaccineCenterNumber.setText(vCN);
        Appointment.addContent(vaccineCenterNumber);
        
        //Verschachtelung (Kindelement)
        Element vaccine = new Element("vaccine");           
        Element name = new Element("Name");
        name.setText(v.getName());
        Element brand = new Element("Brand");
        brand.setText(v.getBrand());
        Element waitingPeriod = new Element("waitingPeriod");
        waitingPeriod.setText(String.valueOf(v.getWaitingPeriod()));
        vaccine.addContent(name);
        vaccine.addContent(brand);
        vaccine.addContent(waitingPeriod);
        Appointment.addContent(vaccine);

        Element isBooked = new Element("isBooked");
        isBooked.setText(isB);
        Appointment.addContent(isBooked);
        
        Element vaccineGiven = new Element("vaccineGiven");
        vaccineGiven.setText(vGiven);
        Appointment.addContent(vaccineGiven);
        
        Element patientDataChecked = new Element("patientDataChecked");
        patientDataChecked.setText(pDC);
        Appointment.addContent(patientDataChecked);
        
        Element startTime = new Element("startTime");
        startTime.setText(sT);
        Appointment.addContent(startTime);
        
        docAppointment.getRootElement().addContent(Appointment);
    }
	
	//Methode zum Schreiben der Datei
	public void writeXMLAppointment(Document doc) {
        Format format = Format.getPrettyFormat();
        format.setIndent("    ");
        try (FileOutputStream fos = new FileOutputStream(FILE)) {
            XMLOutputter op = new XMLOutputter(format);
            op.output(doc, fos);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
}
