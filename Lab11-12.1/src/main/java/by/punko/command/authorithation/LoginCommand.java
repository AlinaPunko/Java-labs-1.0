package main.java.by.punko.command.authorithation;

import main.java.by.punko.command.Command;
import main.java.by.punko.command.CommandResult;
import main.java.by.punko.command.session.SessionAttribute;
import main.java.by.punko.exception.IncorrectDataException;
import main.java.by.punko.exception.ServiceException;
import main.java.by.punko.model.User;
import main.java.by.punko.service.UserService;
import main.java.by.punko.util.HashPassword;
import main.java.by.punko.util.Page;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Optional;

import static main.java.by.punko.command.authorithation.constants.AuthConstants.*;
import static java.util.Optional.of;

public class
LoginCommand implements Command {
    private static final Logger LOGGER = Logger.getLogger(LoginCommand.class.getName());
    private void setAttributesToSession(String name, HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.setAttribute(SessionAttribute.NAME, name);
    }
    @Override
    public CommandResult execute(HttpServletRequest request,
                                 HttpServletResponse response) throws ServiceException, IncorrectDataException, ServletException, IOException {
        boolean isUserFind = false;
        Optional<String> login = of(request)
                .map(httpServletRequest ->
                        httpServletRequest.getParameter(LOGIN));
        Optional<String> password = of(request)
                .map(httpServletRequest ->
                        httpServletRequest.getParameter(PASSWORD));
        if (login.get()==null || password.get()==null||login.get().length()==0||password.get().length()==0) {
            return forwardLoginWithError(request, ERROR_MESSAGE, ERROR_MESSAGE_TEXT);
        }
        byte[] pass = HashPassword.getHash(password.get());
        isUserFind = initializeUserIfExist(login.get(), pass, request);
        if (!isUserFind) {
            LOGGER.info("user with such login and password doesn't exist");
            return forwardLoginWithError(request, ERROR_MESSAGE,
                    AUTHENTICATION_ERROR_TEXT);
        } else {
            LOGGER.info("user has been authorized: login:" + login + " password:" + password);
            return new CommandResult(COMMAND_WELCOME, false);
        }
    }
    public boolean initializeUserIfExist(String login, byte[] password,
                                         HttpServletRequest request) throws ServiceException {
        UserService userService = new UserService();
        Optional<User> user = userService.login(login, password);
        boolean userExist = false;
        if (user.isPresent()) {
            setAttributesToSession(user.get().getLogin(), request);
            userExist = true;
        }
        return userExist;
    }
    private CommandResult forwardLoginWithError(HttpServletRequest request,
                                                final String ERROR, final String ERROR_MESSAGE) {
        request.setAttribute(ERROR, ERROR_MESSAGE);
        return new CommandResult(Page.LOGIN_PAGE.getPage(), false);
    }
}
