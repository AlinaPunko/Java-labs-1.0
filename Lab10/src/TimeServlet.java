import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet(urlPatterns = "/time")
public class TimeServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request,
                          javax.servlet.http.HttpServletResponse response)
            throws javax.servlet.ServletException, IOException {
    }
    protected void doGet(javax.servlet.http.HttpServletRequest request,
                         javax.servlet.http.HttpServletResponse response)
            throws javax.servlet.ServletException, IOException {
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Good morning </title>");
        out.println("</head>");
        out.println("<body>");
        out.println("Protocol "+request.getProtocol());
        out.println("<br>");
        out.println("URL request "+request.getRequestURL());
        out.println("<br>");
        out.println("IP "+request.getRemoteAddr());
        out.println("<br>");
        out.println("User "+request.getRemoteUser());
        out.println("<br>");
        out.print("Header info ");
        Enumeration<String> e = request.getHeaderNames();
        while(e.hasMoreElements()){
            String name = e.nextElement();
            String value = request.getHeader(name);
            out.println(name + ":  " + value);
        }
        out.println("</body>");
        out.println("</html>");
    }
}
