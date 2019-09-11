package by.punko.belstu;

import java.util.Date;

public class Letter
{
    int ID;
    String Getter;
    String Sender;
    String Topic;
    String Text_of_letter;
    Date Date_of_sending;

    @Override
    public String toString() {
        return "\nLetter{" +
                "ID=" + ID +
                ", Getter='" + Getter + '\'' +
                ", Sender='" + Sender + '\'' +
                ", Topic='" + Topic + '\'' +
                ", Text_of_letter='" + Text_of_letter + '\'' +
                ", Date_of_sending=" + Date_of_sending +
                '}';
    }
}
