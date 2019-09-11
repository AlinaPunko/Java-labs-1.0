package by.belstu.it.punko.validationSAX;

import by.belstu.it.punko.student.Student;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class DOM {
    public List<Student> students;

    public DOM() {
    }

    public void startParser(String filePath) throws Exception {
        File xmlFile = new File(filePath);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        try {

            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(xmlFile);
            document.getDocumentElement().normalize();
            NodeList nodeList = document.getElementsByTagName("student");
            this.students = new ArrayList();

            for(int i = 0; i < nodeList.getLength(); ++i) {
                this.students.add(getLanguage(nodeList.item(i)));
            }
        } catch (Exception var8) {
            var8.printStackTrace();
        }

    }


    public static Student getLanguage(Node node) {
        Student stud = new Student();
        if (node.getNodeType() == 1) {
            Element element = (Element)node;
            stud.setName(getTagValue("name", element));
            stud.setSurname(getTagValue("surname", element));
            stud.setCourse(Integer.parseInt(getTagValue("course", element)));
            stud.setNumOfZach(Integer.parseInt(getTagValue("numOfZach", element)));
        }

        return stud;
    }

    public static String getTagValue(String tag, Element element) {
        NodeList nodeList = element.getElementsByTagName(tag).item(0).getChildNodes();
        Node node = nodeList.item(0);
        return node.getNodeValue();
    }
}
