package by.belstu.it.punko.main;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import by.belstu.it.punko.tests.*;
import by.belstu.it.punko.inter.Specialization;
import by.belstu.it.punko.student.Student;
import by.belstu.it.punko.dean.Dean;
import by.belstu.it.punko.course.Course;
import by.belstu.it.punko.validationSAX.DOM;
import by.belstu.it.punko.validationSAX.SAX;
import by.belstu.it.punko.validationSAX.ValidatorSAX;
import org.apache.log4j.Logger;
import org.apache.log4j.LogManager;
import org.apache.log4j.xml.DOMConfigurator;
import org.xml.sax.SAXException;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class Main
{
    /*static {
        new DOMConfigurator().doConfigure("log/log4j.xml",
                LogManager.getLoggerRepository());
    }

        private static final Logger LOG = Logger.getLogger(Main.class);*/

        public static void main(String[] args) {

            /*ValidatorSAX val = new ValidatorSAX();
            val.valid();

            try {
                System.out.println("SAX");
                SAXParserFactory factory = SAXParserFactory.newInstance();
                SAXParser parser = factory.newSAXParser();
                SAX sax = new SAX();
                parser.parse(new File("files/XML.xml"), sax);
                Student Alina = sax.getResult();
                System.out.println(Alina.toString());


                System.out.println("DOM");
                DOM dom = new DOM();
                dom.startParser("files/XML.xml");
                System.out.println(((Student)dom.students.get(0)).getName());


                TransformerFactory xstf = TransformerFactory.newInstance();
                Transformer transformer = null;
                transformer = xstf.newTransformer(new StreamSource("files/XSL.xsl"));
                transformer.transform(new StreamSource("files/XMLtoHTML.xml"), new StreamResult("files/info.html"));


                FileOutputStream out = new FileOutputStream("files/serialize.xml");
                XMLEncoder xmlEncoder = new XMLEncoder(out);
                xmlEncoder.writeObject(Alina);
                xmlEncoder.close();
                System.out.println("Deserialize");
                FileInputStream in = new FileInputStream("files/serialize.xml");
                XMLDecoder xmlDecoder = new XMLDecoder(in);
                Student Alina1 = (Student)xmlDecoder.readObject();
                xmlDecoder.close();
                System.out.println(Alina1.toString());


                FileWriter out_JSON = new FileWriter("files/toJSON.json");
                Collection collection = new ArrayList();
                collection.add(Alina1);
                collection.add(Alina1);
                Gson gson = new Gson();
                gson.toJson(collection, out_JSON);
                out_JSON.close();
                FileReader in_JSON = new FileReader("files/toJSON.json");
                ArrayList<Student> list = (ArrayList)(new Gson()).fromJson(in_JSON, (new TypeToken<ArrayList<Student>>() {
                }).getType());
                System.out.println(list.toString());
                in_JSON.close();
            } catch (ParserConfigurationException var19) {
                var19.printStackTrace();
            } catch (SAXException var20) {
                var20.printStackTrace();
            } catch (IOException var21) {
                var21.printStackTrace();
            } catch (Exception var22) {
                var22.printStackTrace();
            }

        }*/
        }
}


