import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.util.Date;

@WebFilter(filterName = "SecondFilter")
public class SecondFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("Second");
        String phone = req.getParameter("phone");
        String email =req.getParameter("email");
        if(!phone.isEmpty() ||!email.isEmpty()){
            req.getRequestDispatcher("/Hello.jsp").forward(req,resp);
        }else{
            req.setAttribute("errorMessage","Provide phone or mail");
            req.getRequestDispatcher("/index.jsp").forward(req,resp);
        }
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
