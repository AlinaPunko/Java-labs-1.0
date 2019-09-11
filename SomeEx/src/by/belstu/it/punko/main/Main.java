package by.belstu.it.punko.main;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws SQLException {
        ResultSet rs = null;
        String url = "jdbc:jtds:sqlserver://ALINA-ПК/Lab10J;instance=SQLEXPRESS";
        String driver = "net.sourceforge.jtds.jdbc.Driver";
        try (Connection conn = DriverManager.getConnection(url)) {
            System.out.println("Connection to Store DB succesfull!!");
//            MyDB dao = new MyDB();
//            String SQLQuery1 = "select * from Man where FIO in (select Getter from Letter where Topic = 's');";
//            //Вывести информацию о пользователях, которые не получали сообщения с заданной темой.
//            String SQLQuery2 = "select * from Man where FIO not in (select Getter from Letter where Topic = 's');";
//            String SQLQUERY3 = "select * ,(select Count(*) from Letter where sender = a.Fio)[Количество отправленных],(select Count(*) from Letter where getter = a.Fio)[Количество принятых] from Man as a;";
//            System.out.println("Список всех людей");
//            IGenDB<Man, Integer> manDB = dao.getManDB(conn);
//            List<Man> authorList = manDB.getAll();
//            System.out.println(authorList);
//            System.out.println("Список всех писем");
//            IGenDB<Letter, Integer> letterDB = dao.getLetterDb(conn);
//            List<Letter> LetterList = letterDB.getAll();
//            System.out.println(LetterList);
//            System.out.println("____________________________________________________________________________________________");
//            System.out.println("Вывести информацию о пользователях, которые получили хотя бы одно сообщение с заданной темой.");
//            System.out.println("‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾");
//            Statement statement1 = conn.createStatement();
//            ResultSet res1 = statement1.executeQuery(SQLQuery1);
//            List<Man> list = new ArrayList<Man>();
//            while (res1.next()) {
//                System.out.println("| FIO: " + res1.getString(1) + " |\t\t" + "DATE OF BIRTH: " + res1.getString(2) + " |");
//            }
//            System.out.println(list);
//                System.out.println("____________________________________________________________________________________________");
//                System.out.println("Вывести информацию о пользователях, которые не получали сообщения с заданной темой.");
//                System.out.println("‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾");
//                Statement statement2 = conn.createStatement();
//                ResultSet res2 = statement2.executeQuery(SQLQuery2);
//                while (res2.next()) {
//                    System.out.println("| FIO: " + res2.getString(1) + " |\t\t" + "DATE OD BIRTH: " + res2.getString(2) + " |");
//                }
//                System.out.println("____________________________________________________________________________________________");
//            System.out.println("____________________________________________________________________________________________");
//            System.out.println("Вывести информацию о пользователях и письмах.");
//            System.out.println("‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾");
//            Statement statement3 = conn.createStatement();
//            ResultSet res3 = statement3.executeQuery(SQLQUERY3);
//            while (res3.next()) {
//                System.out.println("| FIO: " + res3.getString(1) + " |\t\t" + "DATE OD BIRTH: " + res3.getString(2) + " |" + " |\t\t"
//                        + "SEND: " + res3.getString(3) + " |" + " |\t\t" + "GOT: " + res3.getString(4) + " |" );
//            }
//            System.out.println("____________________________________________________________________________________________");
//            conn.setAutoCommit(false);
//            System.out.println("Transaction");
//            System.out.println("before");
//            conn.commit();
//            String sql = "SELECT * FROM Letter WHERE sender = ?";
//            PreparedStatement stm = conn.prepareStatement(sql);
//            stm.setString(1, "Петух Никита");
//            ResultSet rset = stm.executeQuery();
//            while (rset.next()) {
//                System.out.println("| ID: " + rset.getString(1) + " |\t\t" + "GETTER: " + rset.getString(2) + " |" + " |\t\t" +
//                        "SETTER: " + rset.getString(3) + " |" + " |\t\t" + "TOPIC: " + rset.getString(4) + " |" + " |\t\t" +
//                        "TEXT: " + rset.getString(5) + " |" + " |\t\t" + "DATE: " + rset.getString(6) + " |");
//            }
//            String sql5 = "UPDATE Letter SET topic ='7' Where sender = 'Петух Никита'";
//            PreparedStatement stm6 = conn.prepareStatement(sql5);
//            stm6.executeUpdate();
//            System.out.println("After");
//            String sql7 = "SELECT * FROM Letter WHERE sender = ?";
//            PreparedStatement stm7 = conn.prepareStatement(sql);
//            stm.setString(1, "Петух Никита");
//            ResultSet rset7 = stm.executeQuery();
//            while (rset7.next()) {
//                System.out.println("| ID: " + rset7.getString(1) + " |\t\t" + "GETTER: " + rset7.getString(2) + " |" + " |\t\t" +
//                        "SETTER: " + rset7.getString(3) + " |" + " |\t\t" + "TOPIC: " +rset7.getString(4) + " |" + " |\t\t" +
//                        "TEXT: " + rset7.getString(5) + " |" + " |\t\t" + "DATE: " + rset7.getString(6) + " |");
//            }
//            conn.rollback();
//            }
//        }
            String SQLQuery1 = "select * from Users;";
            Statement statement1 = conn.createStatement();
            ResultSet res1 = statement1.executeQuery(SQLQuery1);
            List<User> list = new ArrayList<User>();
            while (res1.next()) {
                System.out.println("| login: " + res1.getString(1) + " |\t\t" + "password: " + res1.getString(2) + " |" + " |\t\t" + "role " + res1.getString(3));
            }
        }}
    }

