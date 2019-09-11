package main.java.by.punko.builder;

import main.java.by.punko.exception.RepositoryException;
import main.java.by.punko.model.Person;
import main.java.by.punko.repository.dbconstants.PersonTableConstants;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonBuilder implements Builder <Person>{
    @Override
    public Person build(ResultSet resultSet) throws RepositoryException {
        try {
            int id = resultSet.getInt(PersonTableConstants.ID.getFieldName());
            String name =
                    resultSet.getString(PersonTableConstants.NAME.getFieldName());
            String phone =
                    resultSet.getString(PersonTableConstants.PHONE.getFieldName());
            String email =
                    resultSet.getString(PersonTableConstants.EMAIL.getFieldName());
            return new Person(id, name, phone, email);
        } catch (SQLException exception) {
            throw new RepositoryException(exception.getMessage(), exception);
        }
    }
}

