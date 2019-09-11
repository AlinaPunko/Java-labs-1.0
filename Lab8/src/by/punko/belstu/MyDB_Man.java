package by.punko.belstu;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MyDB_Man implements IGenDB <Man, Integer> {
private final Connection connection;

public MyDB_Man(Connection connection){
        this.connection = connection;
        }

@Override
public List<Man> getAll() throws SQLException {
        String sql = "SELECT * FROM Man;";
        PreparedStatement stm = connection.prepareStatement(sql);
        ResultSet rs = stm.executeQuery();
        List<Man> list = new ArrayList<Man>();
        ResultSetListMan(rs, list);
        return list;
        }

public void ResultSetListMan(ResultSet rs, List<Man> list) throws SQLException {//для вывода
        while (rs.next()){
        Man author = new Man();
        author.FIO = rs.getString("FIO");
        author.DateOfBirth = rs.getDate("Date_of_birth");
        list.add(author);
        }
        }
}
