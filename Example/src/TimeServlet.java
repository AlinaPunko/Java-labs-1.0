import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

@javax.servlet.annotation.WebServlet("/time")
public class TimeServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
    String Question1 = request.getParameter("isSummer");
    String Question2 = request.getParameter("isMorning");
    Date currentdate = new Date();
    int result = 0;
    if(currentdate.getMonth()+1>5&&currentdate.getMonth()+1<9 && Question1.equalsIgnoreCase("yes"))
    {
           result+=5;
    }
    if(currentdate.getHours()>5 && currentdate.getHours()<13 && Question2.equalsIgnoreCase("yes"))
    {
        result+=5;
    }
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        writer.println("<p>"+result +"</p>");
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }
}
