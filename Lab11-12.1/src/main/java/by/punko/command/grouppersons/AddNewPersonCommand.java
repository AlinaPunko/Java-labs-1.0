package main.java.by.punko.command.grouppersons;

import main.java.by.punko.command.Command;
import main.java.by.punko.command.CommandResult;
import main.java.by.punko.exception.IncorrectDataException;
import main.java.by.punko.exception.ServiceException;
import main.java.by.punko.model.Person;
import main.java.by.punko.service.PersonService;
import main.java.by.punko.util.Page;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Optional;
import static java.util.Optional.of;
import static main.java.by.punko.command.grouppersons.constant.GroupConstant.*;

public class AddNewPersonCommand implements Command {
    private static final Logger LOGGER =
            Logger.getLogger(AddNewPersonCommand.class.getName());
    @Override
    public CommandResult execute(HttpServletRequest request,
                                 HttpServletResponse response)
            throws ServiceException, IncorrectDataException, ServletException {
        PersonService personService = new PersonService();
        Optional<String> newName = of(request)
                .map(httpServletRequest ->
                        httpServletRequest.getParameter(NEWNAME));
        Optional<String> newPhone = of(request)
                .map(httpServletRequest ->
                        httpServletRequest.getParameter(NEWPHONE));
        Optional<String> newEmail = of(request)
                .map(httpServletRequest ->
                        httpServletRequest.getParameter(NEWEMAIL));
        if (newName.get()==null || newEmail.get()==null|| newPhone.get()==null||newName.get().length()==0||newEmail.get().length()==0 ||newPhone.get().length()==0) {
            LOGGER.info("missing parameter for new person in addition mode");
            request.setAttribute(ERROR_MESSAGE, ERROR_MESSAGE_TEXT);
        } else {
            Person newperson = new Person(newName.get(), newPhone.get(),

                    newEmail.get());
            personService.save(newperson);
        }
        List<Person> clients = personService.findAll();
        if (!clients.isEmpty()) {
            request.setAttribute(LISTGROUP, clients);
        }
        return new CommandResult(Page.WELCOME_PAGE.getPage(), false);
    }
}
