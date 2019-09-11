package main.java.by.punko.command.grouppersons;

import main.java.by.punko.command.Command;
import main.java.by.punko.command.CommandResult;
import main.java.by.punko.exception.IncorrectDataException;
import main.java.by.punko.exception.ServiceException;
import main.java.by.punko.model.Person;
import main.java.by.punko.service.PersonService;
import main.java.by.punko.util.Page;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

import static main.java.by.punko.command.grouppersons.constant.GroupConstant.LISTGROUP;

public class WelcomeCommand implements Command {
    @Override
    public CommandResult execute(HttpServletRequest request,
                                 HttpServletResponse response)
            throws ServiceException, IncorrectDataException {
        PersonService personService = new PersonService();
        List<Person> clients = personService.findAll();
        if (!clients.isEmpty()) {
            request.setAttribute(LISTGROUP, clients);
        }
        return new CommandResult(Page.WELCOME_PAGE.getPage(), false);
    }
}
