package main.java.by.punko.command.authorithation;

import main.java.by.punko.command.Command;
import main.java.by.punko.command.CommandResult;
import main.java.by.punko.exception.IncorrectDataException;
import main.java.by.punko.exception.ServiceException;
import main.java.by.punko.model.User;
import main.java.by.punko.service.UserService;
import main.java.by.punko.util.HashPassword;
import main.java.by.punko.util.Page;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;
import static java.util.Optional.of;

import static main.java.by.punko.command.authorithation.constants.AuthConstants.*;

public class RegisterNewUserCommand implements Command {
    private static final Logger LOGGER =
            Logger.getLogger(RegisterNewUserCommand.class.getName());
    private CommandResult forwardToRegisterWithError(HttpServletRequest
                                                             request, String ERROR, String ERROR_MESSAGE) {
        request.setAttribute(ERROR, ERROR_MESSAGE);
        return new CommandResult(Page.REGISTER_PAGE.getPage(), false);
    }
    private CommandResult forwardToLogin(HttpServletRequest request) {
        return new CommandResult(Page.LOGIN_PAGE.getPage(), false);
    }
    @Override
    public CommandResult execute(HttpServletRequest request,
                                 HttpServletResponse response) throws ServiceException, IncorrectDataException {
        Optional<String> login = of(request)
                .map(httpServletRequest ->
                        httpServletRequest.getParameter(NAME_FOR_REGISTER));
        Optional<String> password = of(request)
                .map(httpServletRequest ->
                        httpServletRequest.getParameter(PASSWORD_FOR_REGISTER));
        if (login.get()==null || password.get()==null||login.get().length()==0||password.get().length()==0) {
            LOGGER.info("invalid login or password format was received:" +
                    login + " " + password);
            return forwardToRegisterWithError(request, REGISTER_ERROR,
                    ERROR_MESSAGE_TEXT);
        }
        byte[] pass = HashPassword.getHash(password.get());
        User user = new User(login.get(), pass);
        UserService userService = new UserService();
        int userCount = userService.save(user);
        if (userCount != 0) {
            LOGGER.info("user was registered: login:" + login + " password:" +
                    password);
            return forwardToLogin(request);
        } else {
            LOGGER.info("invalid login or password format was received:" +
                    login + " " + password);
            return forwardToRegisterWithError(request, REGISTER_ERROR,
                    REGISTER_ERROR_MESSAGE_IF_EXIST);

        }
    }
}
