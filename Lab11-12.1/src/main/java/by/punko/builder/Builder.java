package main.java.by.punko.builder;
import main.java.by.punko.exception.RepositoryException;

import java.sql.ResultSet;
public interface Builder <T> {
    T build(ResultSet resultSet) throws RepositoryException,
            RepositoryException;
}
