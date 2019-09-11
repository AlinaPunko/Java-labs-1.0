package by.belstu.it.punko.dean;
import by.belstu.it.punko.abs.Create;
import by.belstu.it.punko.course.Course;
import by.belstu.it.punko.student.Student;


import java.io.Serializable;
import java.util.Collections;
import java.util.Comparator;

public class Dean extends Create implements Serializable
{
    private static Dean ourInstance;

    public static Dean getInstance() {
        if (ourInstance == null)
            ourInstance = new Dean();
        return ourInstance;
    }

    private Dean() {
    }

    @Override
    public Course SomeMethod(String val) {
        return new Course(val);
    }

    public void CountCourses(Course val) {
        int firstCourse = 0;
        int secondCourse = 0;
        int thirdCourse = 0;
        int fourthCourse = 0;
        for (int i = 0; i < val.GetMyCourse().size(); i++) {
            if (val.GetStudByID(i).getCourse() == 1)
                firstCourse++;
            if (val.GetStudByID(i).getCourse() == 2)
                secondCourse++;
            if (val.GetStudByID(i).getCourse() == 3)
                thirdCourse++;
            if (val.GetStudByID(i).getCourse() == 4)
                fourthCourse++;
        }
        System.out.println("Stud on first course: " + firstCourse);
        System.out.println("Stud on second course: " + secondCourse);
        System.out.println("Stud on third course: " + thirdCourse);
        System.out.println("Stud on fourth course: " + fourthCourse);
    }

    public void CreateCourseByNumberOfCourse(Course pCourse, Course newCourse, int course) {
        if (pCourse == null || newCourse == null)
            throw new NullPointerException("Null pointer");
        for (int i = 0; i < pCourse.GetMyCourse().size(); i++) {
            if (pCourse.GetStudByID(i).getCourse() == course)
                newCourse.GetMyCourse().add(pCourse.GetStudByID(i));
        }
    }

    public void SortByName(Course val) {
        if (val == null)
            throw new NullPointerException("Null pointer");
        val.GetMyCourse().sort(new Comparator<Student>() {
            @Override
            public int compare(Student a, Student b) {
                return a.getName().compareTo(b.getName());
            }
        });
    }


}