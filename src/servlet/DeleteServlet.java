package servlet;

import dao.BbsDao;
import entity.Bbs;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet(name = "DeleteServlet")
public class DeleteServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf8");

        int id=Integer.parseInt(req.getParameter("id"));

        BbsDao bbsDao = new BbsDao();
        bbsDao.getDelete(id);
        List<Bbs> list = bbsDao.getPageList(0,10);
        req.getSession().setAttribute("list",list);
        req.getSession().setAttribute("total",list.size());
        req.getRequestDispatcher("/main.jsp").forward(req,resp);
    }
}
