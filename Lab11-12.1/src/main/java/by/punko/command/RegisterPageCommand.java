package main.java.by.punko.command;

import main.java.by.punko.exception.IncorrectDataException;
import main.java.by.punko.exception.ServiceException;
import main.java.by.punko.util.Page;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegisterPageCommand implements Command {
    @Override
    public CommandResult execute(HttpServletRequest request,
                                 HttpServletResponse response) throws ServiceException, IncorrectDataException,
            ServiceException, IOException {
        System.out.println("REGISTER_PAGE");
        return new CommandResult(Page.REGISTER_PAGE.getPage(), false);
    }
}
