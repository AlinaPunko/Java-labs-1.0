package main.java.com.ServletTest.forms;

import main.java.com.ServletTest.classes.DataProcessor;
import main.java.com.ServletTest.classes.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RegisterServlet", urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String errorMessage = null;
        if(login.isEmpty() || password.isEmpty()){
            errorMessage = "You should to fill both fields";
        }else if(!DataProcessor.IsSuchUserExist(login, password)){
            DataProcessor.RegisterUser(login, password);

            User user = User.Initialize();
            user.setUsername(login);
            user.setPassword(password);
            request.setAttribute("user", user);
            request.getRequestDispatcher("Welcome.jsp").include(request, response);
        }else{
            errorMessage = "Such user already exist. Try different credentials";
        }

        request.setAttribute("errorMessage", errorMessage);
        if(errorMessage != null)
            request.getRequestDispatcher("RegisterForm.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("errorMessage", null);
        request.getRequestDispatcher("RegisterForm.jsp").forward(request, response);
    }
}
