import org.springframework.jdbc.core.BeanPropertyRowMapper;
import pojo.JWUser;

import javax.servlet.http.HttpSession;
import java.io.IOException;

@javax.servlet.annotation.WebServlet("/login")
public class Login extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String userName = request.getParameter("username");
        String password = request.getParameter("password");

        JWUser jwUser = DbHelper.queryForObject("select * from jw_users where user_name=? and user_pwd=?",
                new BeanPropertyRowMapper<>(JWUser.class), userName, password);

        if (jwUser != null && jwUser.getUser_id() > 0) {
            HttpSession session = request.getSession();
            session.setAttribute("login_status", jwUser);
            response.sendRedirect("main");
        } else {
            request.setAttribute("msg", "用户名或密码错误");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }
}
