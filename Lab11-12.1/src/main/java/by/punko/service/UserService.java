package main.java.by.punko.service;

import main.java.by.punko.exception.RepositoryException;
import main.java.by.punko.exception.ServiceException;
import main.java.by.punko.model.User;
import main.java.by.punko.repository.specification.*;

import java.util.Optional;

public class UserService {
    public Optional<User> login(String login, byte[] password) throws
            ServiceException {
        try (RepositoryCreator repositoryCreator = new RepositoryCreator()) {
            UserRepository userRepository =
                    repositoryCreator.getUserRepository();
            UserByLoginPassword params = new UserByLoginPassword(login,
                    password);
            return userRepository.queryForSingleResult(SQLHelper.SQL_GET_USER,
                    params);
        } catch (RepositoryException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }
    public Integer save(User user) throws ServiceException {
        try (RepositoryCreator repositoryCreator = new RepositoryCreator()) {
            UserRepository userRepository =
                    repositoryCreator.getUserRepository();
            UserByLogin param = new UserByLogin(user.getLogin());
            if (!userRepository.queryForSingleResult(SQLHelper.SQL_CHECK_LOGIN,
                    param).isPresent()) {
                return userRepository.save(user);
            } else {
                return 0;
            }
        } catch (RepositoryException exception) {
            throw new ServiceException(exception.getMessage(), exception);
        }
    }
}
