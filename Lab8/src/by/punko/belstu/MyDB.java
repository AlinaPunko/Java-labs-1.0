package by.punko.belstu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyDB implements IDB {
    private static final String url = "jdbc:jtds:sqlserver://localhost:1433;databaseName=Lab8;integratedSecurity=true\";";


    public MyDB() throws SQLException {
        try {
            DriverManager.registerDriver(new net.sourceforge.jtds.jdbc.Driver());//drivermanager длярегистрации драйверов чтоб знать как работать с бд
        }
        catch (SQLException ex){
            ex.printStackTrace();
        }
    }

    @Override
    public Connection getConnection() throws SQLException{
        return DriverManager.getConnection(url);
    }


    @Override
    public IGenDB <Man, Integer> getManDB(Connection connection) {
        return new MyDB_Man(connection);
    }

    @Override
    public IGenDB<Letter, Integer> getLetterDb(Connection connection) {
        return new MyDB_Letter(connection);
    }


}
