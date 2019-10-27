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

@WebServlet(name = "InsertServlet")
public class InsertServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/insert.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf8");
        resp.setCharacterEncoding("utf8");
        String title = req.getParameter("title");
        String content = req.getParameter("content");
        String author = req.getParameter("author");
        String ctime = req.getParameter("ctime");
        int type =Integer.parseInt(req.getParameter("type"));
        int stat =Integer.parseInt(req.getParameter("stas"));
        //int id = Integer.parseInt(req.getParameter("id"));

        Bbs bbs = new Bbs();
        bbs.setType(type);
        bbs.setStat(stat);
        //bbs.setId(id);
        bbs.setContent(content);
        bbs.setCtime(ctime);
        bbs.setAuthor(author);
        bbs.setTitle(title);
        BbsDao bbsDao = new BbsDao();
        bbsDao.insertBbs(bbs);
        List<Bbs> list = bbsDao.getPageList(0,10);
        req.getSession().setAttribute("list",list);
        req.getSession().setAttribute("total",bbsDao.getTotal());
        req.getRequestDispatcher("/main.jsp").forward(req,resp);
    }

}
