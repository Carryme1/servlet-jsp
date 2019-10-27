package servlet;

import dao.BbsDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ReturnServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf8");
        BbsDao bbsDao = new BbsDao();

        req.getSession().setAttribute("list",bbsDao.getPageList(0,10));
        req.getSession().setAttribute("total",bbsDao.getTotal());
        req.getRequestDispatcher("/main.jsp").forward(req,resp);
    }
}
