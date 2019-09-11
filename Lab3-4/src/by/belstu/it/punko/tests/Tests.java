package by.belstu.it.punko.tests;

import by.belstu.it.punko.inter.Specialization;
import by.belstu.it.punko.student.Form;
import by.belstu.it.punko.student.Student;
import junit.framework.TestSuite;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import java.util.HashMap;
import java.util.Map;

@Suite.SuiteClasses( { Sometests.class })
@RunWith(Suite.class)
public class Tests
{


    private Student student = new Student(new String("Alina"),
            2, Form.DAY, Specialization.ITS, 8.0);
    /*@Before//указывает, что данный метод, будет запускаться перед любым методом тестового класса.
    public void testBeforeSuite() {
        System.out.println("@BeforeSuite");
    }*/

    @BeforeClass
// указывает, что метод будет выполнен после запуска тестового класса, но перед всеми тестовыми методами.
    public static void testBeforeClass() {
        System.out.println("@BeforeClass");
    }
    @Before//аннотированный метод будет выполняться перед каждым тестовым методом.
    public void testBeforeMethod() {
        System.out.println("@BeforeMethod");
    }


    /*@After
    public void testASuite() {
        System.out.println("@AfterSuite");
    }*/

    @AfterClass
    public static void testAClass() {
        System.out.println("@AfterClass");
    }
    @After
    public void testAMethod() {
        System.out.println("@AfterMethod");
    }
    /*@After
    public void testATest() {
        System.out.println("@AfterTest");
    }*/


    @Test
    public void testObject(){
        try{
            if(student == null)
                throw new NullPointerException();
            Assert.assertEquals(student.getName(), "Alina");
            Assert.assertEquals(student.getCourse() , 2);
            System.out.println("@Test");
        }
        catch(NullPointerException e){
            System.out.println(e.getMessage());
        }
    }

    //assert
    @Ignore
    @Test
    public void ExTst(){
        System.out.println("miss");
        //Assert.fail();
    }
    //timeout
    @Test(timeout = 1000)
    public void waitLongTime() throws Exception {
        Thread.sleep(10);
        System.out.println("Ignored");
    }/*
    //groups
    @Test(groups = {"Group"})
    public void test1Group(){
        System.out.println("method 1 test in group");
    }
    @Test(groups = {"Group"})
    public void test2Group(){
        System.out.println("method 2 test in group");
    }
    @Test(dependsOnGroups = "Group")//определеяет группы которые должны быть запущены перед запускаемой данной службы
    public void testGroup(){
        System.out.println("Group test");
    }*/
}
