package vaccimate.save;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.XMLOutputter;

public class XML_ReadAppointment {

	Document doc = null;
	String code = "";
	String date = "";
	String patient = "";
	String site = "";
	String vaccine = "";
	String isBooked = "";
	String vaccineGiven = "";
	String patientDataChecked = "";
	String startTime = "";

	String[] readOneAppointment(String filename, int id) {
		try {
			File appointmentFile = new File(filename);
			SAXBuilder builder = new SAXBuilder();
			doc = builder.build(appointmentFile);
			XMLOutputter fmt = new XMLOutputter();
	
			Element element = doc.getRootElement();
			
			List allAppointments = (List) element.getChildren();

			List oneAppointment = (List) ((Element) allAppointments.get(id)).getChildren();
			
			int j = 0;
			while (j < oneAppointment.size()) {
				System.out.print(((Element) oneAppointment.get(j)).getName() + ": ");
				System.out.println(((Element) oneAppointment.get(j)).getValue());
				j++;
			}
			
			code = ((Element) oneAppointment.get(0)).getValue();
			date = ((Element) oneAppointment.get(1)).getValue();
			patient = ((Element) oneAppointment.get(2)).getValue();
			site = ((Element) oneAppointment.get(3)).getValue();
			vaccine = ((Element) oneAppointment.get(4)).getValue();
			isBooked = ((Element) oneAppointment.get(5)).getValue();
			vaccineGiven = ((Element) oneAppointment.get(6)).getValue();
			patientDataChecked = ((Element) oneAppointment.get(7)).getValue();
			startTime = ((Element) oneAppointment.get(8)).getValue();

		} catch (JDOMException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		String[] arr = { code, date, patient, site, vaccine, isBooked, vaccineGiven, patientDataChecked, startTime }; 
		return arr;

	}

		void readAllAppointments(String filename) {
			try {
				File AppointmentFile = new File(filename);
				SAXBuilder builder = new SAXBuilder();
				doc = builder.build(AppointmentFile);
				XMLOutputter fmt = new XMLOutputter();

				Element element = doc.getRootElement();
	
				List allAppointments = (List) element.getChildren();

				int i = 0;
				while (i < allAppointments.size()) {
			
					List oneAppointment = (List) ((Element) allAppointments.get(i)).getChildren();
			
					int j = 0;
					while (j < oneAppointment.size()) {
						System.out.print(((Element) oneAppointment.get(j)).getName() + ": ");
						System.out.println(((Element) oneAppointment.get(j)).getValue());
						j++;
					}
					
					i++;
				}
				
			} catch (JDOMException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	
	public Document readAppointmentDocument(String filename) {
		try {
			File AppointmentFile = new File(filename);
			SAXBuilder builder = new SAXBuilder();
			doc = builder.build(AppointmentFile);
			XMLOutputter fmt = new XMLOutputter();

		} catch (JDOMException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return doc;

	}
	
}