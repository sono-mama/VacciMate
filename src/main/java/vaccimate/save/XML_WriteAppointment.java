package vaccimate.save;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JOptionPane;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

public class XML_WriteAppointment {

	private final static String DATNAM = "XML_Appointment.xml";

	private final static File FILE = new File(DATNAM);

	 Document createDocAppointment(String rootElementAppointment) {
		Document docAppointment = new Document();
		Element rootAppointment = new Element(rootElementAppointment);
		docAppointment.setRootElement(rootAppointment);
		return docAppointment;
	}
	
	void writeDocAppointment(Document docAppointment, String c, String d, String p, String s, String v, String isB, String vGiven, String pDC, String sT) {
		
		Element Appointment = new Element ("Appointment");
		
		Element code = new Element("code");
		code.setText(c);
		Appointment.addContent(code);
        
        Element date = new Element("date");
        date.setText(d);
        Appointment.addContent(date);
        
        Element patient = new Element("patient");
        patient.setText(p);
        Appointment.addContent(patient);
        
        Element site = new Element("site");
        site.setText(s);
        Appointment.addContent(site);
        
        Element vaccine = new Element("vaccine");
        vaccine.setText(v);
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
	void writeXMLAppointment(Document doc) {
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
