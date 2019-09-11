package by.belstu.it.punko.validationSAX;

import by.belstu.it.punko.student.Student;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SAX extends DefaultHandler {
    Student stud = new Student();
    String thisElement = "";

    public SAX() {
    }

    public void startDocument() throws SAXException {
        System.out.println("Start parsing");
    }

    public void startElement(String namespaceURI, String localName, String qName, Attributes atts) throws SAXException {
        this.thisElement = qName;
    }

    public void endElement(String namespaceURI, String localName, String qName) throws SAXException {
        this.thisElement = "";
    }

    public void endDocument() {
        System.out.println("end parsing");
    }

    public Student getResult() {
        return this.stud;
    }

    public void characters(char[] ch, int start, int length) throws SAXException {
        if (this.thisElement.equals("name")) {
            this.stud.setName(new String(ch, start, length));
        }

        if (this.thisElement.equals("surname")) {
            this.stud.setSurname(new String(ch, start, length));
        }

        if (this.thisElement.equals("course")) {
            this.stud.setCourse(new Integer(new String(ch, start, length)));
        }

        if (this.thisElement.equals("numOfZach")) {
            this.stud.setNumOfZach(new Integer(new String(ch, start, length)));
        }

    }
}
