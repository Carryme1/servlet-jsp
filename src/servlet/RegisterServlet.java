package servlet;

import dao.UserDao;
import entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RegisterServlet")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/register.jsp").forward(req, resp);
        System.out.println("1:doGet");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf8");
        resp.setCharacterEncoding("utf8");

        String name = req.getParameter("uname");
        String password = req.getParameter("upwd");
        if(name==null||password==null) {
            req.setAttribute("message", "账户名或密码为空！");
            req.getRequestDispatcher("/register.jsp").forward(req, resp);
        }
        UserDao userDao = new UserDao();
        userDao.addUser(name,password);
        req.getRequestDispatcher("/index.jsp").forward(req, resp);
        System.out.println("2:doPost");
    }
}
