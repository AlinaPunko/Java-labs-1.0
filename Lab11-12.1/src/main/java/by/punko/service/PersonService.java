package main.java.by.punko.service;

import main.java.by.punko.exception.RepositoryException;
import main.java.by.punko.exception.ServiceException;
import main.java.by.punko.model.Person;
import main.java.by.punko.repository.specification.PersonRepository;
import main.java.by.punko.repository.specification.RepositoryCreator;

import java.util.List;

public class PersonService {
    public List<Person> findAll() throws ServiceException {
        try (RepositoryCreator repositoryCreator = new RepositoryCreator()) {
            PersonRepository personRepository =
                    repositoryCreator.getPersonRepository();
            return personRepository.findAll();
        } catch (RepositoryException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }
    public void save(Person person) throws ServiceException {
        try (RepositoryCreator repositoryCreator = new RepositoryCreator()) {
            PersonRepository personRepository =
                    repositoryCreator.getPersonRepository();
            personRepository.save(person);
        } catch (RepositoryException exception) {
            throw new ServiceException(exception.getMessage(), exception);
        }
    }
}

