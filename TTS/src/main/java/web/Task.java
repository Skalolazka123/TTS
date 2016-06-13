
package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.SpentTimeItem;
import data.SpentTimeItemDAO;

/**
 * @author Maryia Drozd
 * @version 1.0
 */

@WebServlet("/task")
public class Task extends HttpServlet
{

    private static final long serialVersionUID = 1L;

    private SpentTimeItemDAO spentTimeItemsDao = new SpentTimeItemDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException
    {
        execute(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException
    {
        execute(request, response);
    }

    private void execute(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException
    {
        String reqIdParam = request.getParameter("id");
        String reqNameParam = request.getParameter("name");
        List<SpentTimeItem> spentTime = spentTimeItemsDao.findAllSpentTimeForSelectedTask(reqIdParam);
        request.setAttribute("task", spentTime);
        request.setAttribute("taskName", reqNameParam);
        request.getRequestDispatcher("task.jsp").forward(request, response);
        return;
    }
}
