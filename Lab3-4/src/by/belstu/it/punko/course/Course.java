package by.belstu.it.punko.course;
import by.belstu.it.punko.student.Student;

import java.io.Serializable;
import java.util.ArrayList;

public class Course implements Serializable {
    ArrayList<Student> myCourse = new ArrayList<>();

    public void setMyCourse(ArrayList<Student> pMyCourse) {
        if (pMyCourse == null)
            throw new NullPointerException("Null pointer");
        this.myCourse = pMyCourse;
    }

    public ArrayList<Student> getMyCourse() {
        return myCourse;
    }

    public void AddStudent(Student pStud) {
        if (pStud == null)
            throw new NullPointerException("Null pointer");
        this.myCourse.add(pStud);
    }

    public Student GetStudByID(int id) {
        if(id>myCourse.size())
            throw new ArrayIndexOutOfBoundsException("Error in ID");
        return this.myCourse.get(id);
    }

    String name;

    public Course(String val) {
        this.name = val;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Student> GetMyCourse() {
        return this.myCourse;
    }

}
