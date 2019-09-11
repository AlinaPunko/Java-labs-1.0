package main.java.by.punko.command.factory;


import main.java.by.punko.command.Command;
import main.java.by.punko.command.LoginPageCommand;
import main.java.by.punko.command.RegisterPageCommand;
import main.java.by.punko.command.authorithation.LoginCommand;
import main.java.by.punko.command.authorithation.RegisterNewUserCommand;
import main.java.by.punko.command.authorithation.SignOutCommand;
import main.java.by.punko.command.grouppersons.AddNewPersonCommand;
import main.java.by.punko.command.grouppersons.WelcomeCommand;

public class CommandFactory {
public static Command create(String command) {
        command = command.toUpperCase();
        System.out.println(command);
        CommandType commandEnum = CommandType.valueOf(command);
        Command resultCommand;
        switch (commandEnum) {
        case LOGIN: {
        resultCommand = new LoginCommand();
        break;
        }
        case REGISTER_NEW_USER: {
        resultCommand = new RegisterNewUserCommand();
        break;
        }
        case SIGN_OUT: {
        resultCommand = new SignOutCommand();
        break;
        }
        case ADD_NEW_PERSON:{
        resultCommand = new AddNewPersonCommand();
        break;
        }
        case LOGIN_PAGE:{
        resultCommand = new LoginPageCommand();
        break;
        }
        case WELCOME:{
        resultCommand = new WelcomeCommand();
        break;
        }
        case REGISTRATION_PAGE:{
        resultCommand = new RegisterPageCommand();
        break;
        }
default: {
        throw new IllegalArgumentException("Invalid command" +
        commandEnum);
        }
        }
        return resultCommand;
        }
        }
