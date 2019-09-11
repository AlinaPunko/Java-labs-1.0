import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet( name="Auth", urlPatterns = "/Authorization")
public class Auth extends HttpServlet{
    private String passw = "qwe123";
    private String login = "admin";
    private static int count = 0;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter printWriter = response.getWriter();
        printWriter.print("<html>");
        printWriter.println(request.getSession().getLastAccessedTime());
        if (request.getParameter("pass").equals(passw) && request.getParameter("login").equals(login)) {
            count++;
            Cookie cookie = new Cookie(request.getParameter("login"),"admin " + count + " " + request.getSession().getLastAccessedTime());

            response.addCookie(cookie);
            response.sendRedirect("Home");
        }
        else
            // response.sendRedirect("WrongPassword.jsp");




            printWriter.print("</html>");
        printWriter.close();
    }



}
