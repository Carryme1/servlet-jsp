package servlet;

import dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="ResetServlet")
public class ResetServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/reset.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf8");
        resp.setCharacterEncoding("utf8");
        String name = req.getParameter("uname");
        String upwd = req.getParameter("upwd");
        String npwd =req.getParameter("npwd");

        UserDao userDao = new UserDao();
        userDao.updatePwd(name,upwd,npwd);
        req.getRequestDispatcher("/index.jsp").forward(req,resp);
    }
}
