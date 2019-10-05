package servlet;

import dao.UserDao;
import entity.User;

import javax.jws.WebService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        String name = req.getParameter("uname");
        String password = req.getParameter("upwd");

        UserDao userDao = new UserDao();
        User user = userDao.getLogin(name, password);
        if(user == null) {
            req.setAttribute("message", "账户名或密码错误！请重试！");
            req.getRequestDispatcher("/index.jsp").forward(req, resp);
        }
        else {
            req.getRequestDispatcher("/main.jsp").forward(req,resp);
        }
    }
}
