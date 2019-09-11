package by.belstu.it.punko.validationSAX;
import java.io.*;
import by.belstu.it.punko.inter.Specialization;
import by.belstu.it.punko.student.Student;
import by.belstu.it.punko.dean.Dean;
import by.belstu.it.punko.course.Course;
import org.apache.log4j.Logger;
import org.apache.log4j.LogManager;
import org.apache.log4j.xml.DOMConfigurator;
import org.xml.sax.SAXException;
import java.io.File;
import java.io.IOException;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import javax.xml.XMLConstants;


public class ValidatorSAX {
    private static final Logger LOG = Logger.getLogger(ValidatorSAX.class);
    public void valid() {
        String filename = "files/XML.xml";
        String schemaname = "files/XML.xsd";
        String logname = "log/log4j.xml";
        Schema schems = null;
        String language = "http://www.w3.org/2001/XMLSchema";
        SchemaFactory factory = SchemaFactory.newInstance(language);
        try {
            schems = factory.newSchema(new File(schemaname));
            Validator validator = schems.newValidator();
            Source source = new StreamSource(filename);
            Student s = new Student(logname);
            validator.setErrorHandler(s);
            validator.validate(source);
            LOG.info(filename + " is valid");
        } catch (SAXException var10) {
            LOG.error(filename + " SAX error " + var10.getMessage());
        } catch (IOException var11) {
            LOG.error(" io error " + var11.getMessage());
        }
    }

}
