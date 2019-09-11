package by.punko.belstu;

import java.sql.Connection;
import java.sql.SQLException;

public interface IDB {

        public Connection getConnection() throws SQLException;
        public IGenDB <Man, Integer> getManDB(Connection connection);
        public  IGenDB <Letter, Integer> getLetterDb(Connection connection);

}
