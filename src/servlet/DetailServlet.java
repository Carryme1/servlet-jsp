package servlet;

import dao.BbsDao;
import entity.Bbs;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DetailServlet")
public class DetailServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf8");
        BbsDao bbsDao = new BbsDao();
        int id = Integer.parseInt(req.getParameter("id"));
        Bbs detail = bbsDao.getDetail(id);
        System.out.println(id);
        req.getSession().setAttribute("detail",detail);
        req.getRequestDispatcher("/detail.jsp").forward(req,resp);
    }
}
