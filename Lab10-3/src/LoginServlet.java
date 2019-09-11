import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet("/sign")
public class LoginServlet extends HttpServlet {

public static String url = "jdbc:jtds:sqlserver://ALINA-ПК/Lab10J;instance=SQLEXPRESS";

    private boolean flag = false;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection connection = DriverManager.getConnection(url);
            Statement statement =  connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Users");

            response.setContentType("text/html");
            PrintWriter writer = response.getWriter();
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            User user = new User();
            while (resultSet.next())
            {
                if (resultSet.getString(1).equals(username) && resultSet.getString(2).equals(password))
                {
                    flag = true;

                    user.login=resultSet.getString(1);
                }
                else flag = false;
            }

            if (!username.isEmpty() && !password.isEmpty() && flag) {
                request.setAttribute("newusername", username);
                request.setAttribute("date", new java.util.Date());
                this.getServletContext().getRequestDispatcher("/WEB-INF/MainWindow.jsp").forward(request, response);
                try
                {
                    writer.println("<p>Hello dear: " + username + "  Now time on server:  "+ new Date() +"</p>");
                }
                finally
                {
                    writer.close();
                }
            }
            else
            {
                request.getRequestDispatcher("Register.jsp").forward(request,response);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
