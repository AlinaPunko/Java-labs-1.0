import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            response.setContentType("text/html");
            PrintWriter writer = response.getWriter();
            String login = request.getParameter("username");
            String password = request.getParameter("password");
            String retry = request.getParameter("retry");

            if (login != "" && password != "" && retry.equals(password)) {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                Connection connection = DriverManager.getConnection(LoginServlet.url);
                Statement statement =  connection.createStatement();
                String sqlCommand = "insert into dbo.Users VALUES('"+login+"', '"+password+"')";
                statement.executeUpdate(sqlCommand);
                request.getRequestDispatcher("/Login.jsp").forward(request, response);
            } else {
                writer.println("Error of registration");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
