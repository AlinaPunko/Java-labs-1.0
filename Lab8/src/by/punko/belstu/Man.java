package by.punko.belstu;

import java.util.Date;

public class Man
{ public String FIO;
    public Date DateOfBirth;

    @Override
    public String toString() {
        return "\nAuthor{" +
                "FIO ='" + FIO + '\'' +
                ", Date of birth ='" + DateOfBirth.toString() + '\'' +
                '}';
    }
}
