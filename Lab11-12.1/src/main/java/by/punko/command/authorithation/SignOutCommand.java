package main.java.by.punko.command.authorithation;

import main.java.by.punko.command.Command;
import main.java.by.punko.command.CommandResult;
import main.java.by.punko.command.session.SessionAttribute;
import main.java.by.punko.exception.IncorrectDataException;
import main.java.by.punko.exception.ServiceException;
import main.java.by.punko.util.Page;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SignOutCommand implements Command {
    private static final Logger LOGGER =
            Logger.getLogger(SignOutCommand.class.getName());
    @Override
    public CommandResult execute(HttpServletRequest request,
                                 HttpServletResponse response) throws ServiceException, IncorrectDataException {
        HttpSession session = request.getSession();
        String username =
                (String)session.getAttribute(SessionAttribute.NAME);
        LOGGER.info("user was above: name:" + username);
        session.removeAttribute(SessionAttribute.NAME);
        return new CommandResult(Page.LOGIN_PAGE.getPage(), false);
    }
}
