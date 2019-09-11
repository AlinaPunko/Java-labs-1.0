package main.java.by.punko.repository.specification;

import main.java.by.punko.exception.RepositoryException;

import java.util.List;
import java.util.Optional;

public interface Repository <T> {
    List<T> query(String sqlString, Parameter parameter) throws
            RepositoryException;
    Optional<T> queryForSingleResult(String sqlString, Parameter parameter)
            throws RepositoryException;
    List<T> findAll() throws RepositoryException;
    Integer save(T object) throws RepositoryException;
}
