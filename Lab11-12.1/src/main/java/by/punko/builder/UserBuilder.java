package main.java.by.punko.builder;

import main.java.by.punko.exception.RepositoryException;
import main.java.by.punko.model.User;
import main.java.by.punko.repository.dbconstants.UserTableConstants;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserBuilder implements Builder<User> {
    @Override
    public User build(ResultSet resultSet) throws RepositoryException {
        try {
            int id = resultSet.getInt(UserTableConstants.ID.getFieldName());
            String login =
                    resultSet.getString(UserTableConstants.LOGIN.getFieldName());
            byte[] password =
                    resultSet.getBytes(UserTableConstants.PASSWORD.getFieldName());
            return new User(id, login, password);
        } catch (SQLException exception) {
            throw new RepositoryException(exception.getMessage(), exception);
        }
    }
}
