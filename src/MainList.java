import org.springframework.jdbc.core.BeanPropertyRowMapper;
import pojo.JWUser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/main")
public class MainList extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Object login_status = session.getAttribute("login_status");
        if (login_status == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        List<JWUser> list = DbHelper.query("select * from jw_users",
                new BeanPropertyRowMapper<>(JWUser.class));

        request.setAttribute("user_data", list);
        request.getRequestDispatcher("main.jsp").forward(request, response);
    }
}
