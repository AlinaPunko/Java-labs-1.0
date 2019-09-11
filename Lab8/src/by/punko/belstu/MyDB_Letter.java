package by.punko.belstu;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MyDB_Letter implements IGenDB<Letter, Integer> {
public final Connection connection;
public  MyDB_Letter(Connection connection){
        this.connection = connection;
        }



        public void ResultSetListLetter(ResultSet rs, List<Letter> list) throws SQLException {
                while (rs.next()) {
                        Letter letter = new Letter();
                        letter.Sender = rs.getString("Sender");
                        letter.Getter = rs.getString("Getter");
                        letter.ID = rs.getInt("ID");
                        letter.Text_of_letter = rs.getString("Text_of_letter");
                        letter.Topic = rs.getString("Topic");
                        letter.Date_of_sending=rs.getDate("Date_of_sending");
                        list.add(letter);
                }
        }
@Override
public List<Letter> getAll() throws SQLException{
        String sql = "SELECT * FROM Letter;";
        PreparedStatement stm = connection.prepareStatement(sql);
        ResultSet rs = stm.executeQuery();
        List<Letter> list = new ArrayList<Letter>();
        ResultSetListLetter(rs, list);
        return list;
        }




public List<Letter> deleteLetter() throws SQLException {

        Statement st = connection.createStatement();
        Scanner in = new Scanner(System.in);
        System.out.print("Введите имя: ");
        String sender = in.toString();
        String sql = "delete from Letter where Sender =" + sender +
        "; SELECT  * from books;" ;
        PreparedStatement stm = connection.prepareStatement(sql);
        ResultSet rs = stm.executeQuery();
        List<Letter> list = new ArrayList<Letter>();

        ResultSetListLetter(rs, list);
        return list;
        }
}
