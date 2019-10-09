package servlet;

import dao.BbsDao;
import entity.Bbs;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "UpdateServlet")
public class UpdateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/update.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf8");
        Bbs bbs = new Bbs();
        int id = Integer.parseInt(req.getParameter("id"));
        int type = Integer.parseInt(req.getParameter("type"));
        int stat = Integer.parseInt(req.getParameter("stas"));
        String title = req.getParameter("title");
        String author = req.getParameter("author");
        String content = req.getParameter("content");
        String ctime = req.getParameter("ctime");

        bbs.setTitle(title);
        bbs.setAuthor(author);
        bbs.setCtime(ctime);
        bbs.setContent(content);
        bbs.setId(id);
        bbs.setStat(stat);
        bbs.setType(type);
        BbsDao bbsDao = new BbsDao();
        bbsDao.updateBbs(bbs);

        req.getSession().setAttribute("detail",bbsDao.getDetail(id));
        req.getRequestDispatcher("/main.jsp").forward(req,resp);
    }
}
