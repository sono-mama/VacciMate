package auxiliary;

import com.itextpdf.kernel.pdf.*;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Text;

import process.Appointment;

import java.io.*;
import java.time.LocalDate;


public class PdfCreator {

    // see iText7 documentation for further information.

    public PdfCreator() {
    }

    public void createConfirmationPdf(Appointment appointment) {

        try {

            File file = new File("Terminbestätigung_" + appointment.getCode() + ".pdf");
            PdfWriter pdfWriter = new PdfWriter(file);
            PdfDocument pdfDocument = new PdfDocument(pdfWriter);
            Document document = new Document(pdfDocument);

            Paragraph paragraph1 = new Paragraph();
            Text line1 = new Text("Terminbestätigung");
            line1.setBold();
            line1.setUnderline();
            paragraph1.add(line1);
            document.add(paragraph1);

            Paragraph paragraph2 = new Paragraph();
            Text line2 = new Text(appointment.getPatient().getFirstName() + " " + appointment.getPatient().getLastName());
            Text line3 = new Text(appointment.getPatient().getAddress().getStreetName() + " " + appointment.getPatient().getAddress().getStreetNo());
            Text line4 = new Text(appointment.getPatient().getAddress().getPostalCode() + " " + appointment.getPatient().getAddress().getCity());
            Text line5 = new Text(appointment.getPatient().getContact().getEmail());
            Text line6 = new Text(appointment.getPatient().getContact().getMobileNo());
            paragraph2.add("Patient: ");
            paragraph2.add("\n");
            paragraph2.add(line2);
            paragraph2.add("\n");
            paragraph2.add(line3);
            paragraph2.add("\n");
            paragraph2.add(line4);
            paragraph2.add("\n");
            paragraph2.add(line5);
            paragraph2.add("\n");
            paragraph2.add(line6);
            document.add(paragraph2);

            Paragraph paragraph3 = new Paragraph();
            Text line7 = new Text("Datum: " + appointment.getDate().toString());
            Text line8 = new Text("Uhrzeit: " + appointment.getStartTime()[0] + appointment.getStartTime()[1]);
            Text line9 = new Text("Impfzentrum: " + appointment.getSite().getName());
            Text line10 = new Text("Adresse: " + appointment.getSite().getAddress().getStreetName() + " " + appointment.getSite().getAddress().getStreetNo() +
                    " " + appointment.getSite().getAddress().getPostalCode() + " " + appointment.getSite().getAddress().getCity());
            Text line11 = new Text("Termincode: " + appointment.getCode());
            line11.setBold();

            paragraph3.add("Impftermin: ");
            paragraph3.add("\n");
            paragraph3.add(line7);
            paragraph3.add("\n");
            paragraph3.add(line8);
            paragraph3.add("\n");
            paragraph3.add(line9);
            paragraph3.add("\n");
            paragraph3.add(line10);
            paragraph3.add("\n");
            paragraph3.add(line11);
            document.add(paragraph3);

            Paragraph paragraph4 = new Paragraph();
            Text line12 = new Text("Weitere Informationen über den Ablauf der Impfung und die benötigten Dokumente finden sie unter: " +
                    "\n https://www.berlin.de/corona/impfen/");
            Text line13 = new Text("Den Anamnesebogen sowie das Aufklärungsmerkblatt finden Sie unter: \n" +
                    "https://www.rki.de/DE/Content/Infekt/Impfen/Materialien/COVID-19-Aufklaerungsbogen-Tab.html");

            paragraph4.add("Information: ");
            paragraph4.add("\n");
            paragraph4.add(line12);
            paragraph4.add("\n");
            paragraph4.add(line13);
            document.add(paragraph4);

            document.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void createAppointmentList(Appointment[] appointments){

        try {
            File file = new File("Terminübersicht.pdf");
            PdfWriter pdfWriter = new PdfWriter(file);
            PdfDocument pdfDocument = new PdfDocument(pdfWriter);
            Document document = new Document(pdfDocument);

            Paragraph paragraph1 = new Paragraph();
            Text line1 = new Text("Terminübersicht");
            line1.setBold();
            line1.setUnderline();
            paragraph1.add(line1);
            document.add(paragraph1);

            Paragraph paragraph2 = new Paragraph();
            Text line2 = new Text("Impfzentrum: " + appointments[0].getSite().getName());
            Text line3 = new Text("Datum: " + LocalDate.now());
            paragraph2.add(line2);
            paragraph2.add("\n");
            paragraph2.add(line3);
            document.add(paragraph2);

            Paragraph paragraph3 = new Paragraph();

            paragraph3.add("Uhrzeit / Patient / Code / Impfstoff");
            paragraph3.add("\n");
            for (Appointment appointment : appointments) {
                if (appointment.getPatient() == null) {
                    paragraph3.add(appointment.getStartTime()[0] + appointment.getStartTime()[1] + " Freier Termin");
                    paragraph3.add("\n");
                } else {
                    Text line = new Text(appointment.getStartTime()[0] + appointment.getStartTime()[1] + " " +
                            appointment.getPatient().getFirstName() + " " + appointment.getPatient().getLastName() +
                            " " + appointment.getCode() + " " + " " + appointment.getVaccine().getName());
                    paragraph3.add(line);
                    paragraph3.add("\n");
                }
            }
            document.add(paragraph3);

            document.close();

        } catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }
}
