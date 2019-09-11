package by.punko.belstu;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

public interface IGenDB<T, PK extends Serializable>  {

        List<T> getAll() throws SQLException;
}
