package by.belstu.it.punko.student;
import java.io.*;
import by.belstu.it.punko.inter.Actions;
import by.belstu.it.punko.inter.Specialization;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

public class Student implements Actions, ErrorHandler {
    int numOfZach;
    String surname;
    String name;
    int course;
    Form form;
    Specialization specialization;

    public Specialization getSpecialization() {
        return specialization;
    }

    public void setSpecialization(Specialization specialization) {
        this.specialization = specialization;
    }

    public Student(String pName, int pCourse, Form pForm, Specialization pSpecialization, double pMark) {
        this.name = pName;
        this.course = pCourse;
        this.form = pForm;
        this.specialization = pSpecialization;
    }

    public Student(int pnumzach, String psname, String pname, int pcourse) {
        this.numOfZach = pnumzach;
        this.surname = psname;
        this.name = pname;
        this.course = pcourse;
    }

    public void setNumOfZach(int val) {
        this.numOfZach = val;
    }

    public int getNumOfZach() {
        return this.numOfZach;
    }

    public void setSurname(String val) {
        this.surname = val;
    }

    public String getSurname() {
        return this.surname;
    }

    public Student() {
    }

    public Student(String logname) {
    }

    public String toString() {
        return this.name + " " + this.surname + " " + this.course + " " + this.numOfZach;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCourse() {
        return this.course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public Form getForm() {
        return this.form;
    }

    public void setForm(Form form) {
        this.form = form;
    }

    public Specialization getSpec() {
        return this.specialization;
    }

    public void setSpec(Specialization spec) {
        this.specialization = spec;
    }

    public void GoWalk() {
        System.out.println("Go walk");
    }

    public void MissLesson() {
        System.out.println("Miss");
    }

    public void PlayGames() {
        System.out.println("Play");
    }

    public void warning(SAXParseException exception) throws SAXException {
    }

    public void error(SAXParseException exception) throws SAXException {
    }

    public void fatalError(SAXParseException exception) throws SAXException {
    }
}
