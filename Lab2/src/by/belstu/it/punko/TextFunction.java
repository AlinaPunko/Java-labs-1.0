package by.belstu.it.punko;

public class TextFunction {
    private int test;
    public void onCreate()
    {
        for (int i = 0; i <10 ; i++) {
            System.out.println("cycle" + i);
        }
            }
    public void setTest(int test) {
        this.test = test;
    }

    public int getTest() {
        return test;
    }

    public String getValue()
    {
        PrintingMethod();
        return "hello from the first project";

    }

    private void PrintingMethod() {
        System.out.println("Some information");
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    public TextFunction() {
    }

}
