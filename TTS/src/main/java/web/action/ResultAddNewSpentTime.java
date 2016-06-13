
package web.action;

import java.io.IOException;

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

@WebServlet("/resultAddSpentTimeForTask")
public class ResultAddNewSpentTime extends HttpServlet
{

    private static final long serialVersionUID = 1L;

    private SpentTimeItemDAO spentTimeItemDao = new SpentTimeItemDAO();

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
        String taskName = request.getParameter("task_name");
        String respPerson = request.getParameter("resp_person");
        String spentTimeHours = request.getParameter("spent_time_hours");
        String date = request.getParameter("date");

        SpentTimeItem spentTime = new SpentTimeItem();
        spentTime.setTask(taskName);
        spentTime.setRespPerson(respPerson);
        spentTime.setHours(spentTimeHours);
        spentTime.setDate(date);

        int result = spentTimeItemDao.create(spentTime);
        request.setAttribute("result", result);
        request.getRequestDispatcher("result.jsp").forward(request, response);
        return;
    }
}