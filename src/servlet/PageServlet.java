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

@WebServlet(name = "PageServlet")
public class PageServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        int start = 0;
        int count = 10;
        try {
            start = Integer.parseInt(request.getParameter("start"));
        } catch (NumberFormatException e) {
        }

        int next = start + count;
        int pre = start - count;
        int total = new BbsDao().getTotal();
        int last;
        if (0 == total % count)
            last = total - count;
        else
            last = total - total % count;
        pre = pre < 0 ? 0 : pre;
        next = next > last ? last : next;

        request.setAttribute("total", total);
        request.setAttribute("last", last);
        request.setAttribute("next", next);
        request.setAttribute("pre", pre);

        List<Bbs> list = new BbsDao().getPageList(start, count);
        request.setAttribute("list", list);
        request.getRequestDispatcher("/main.jsp").forward(request, response);
    }
}
