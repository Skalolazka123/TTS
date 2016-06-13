
package web.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.TaskItem;
import data.TaskItemDAO;

/**
 * @author Maryia Drozd
 * @version 1.0
 */

@WebServlet("/resultAddNewTask")
public class ResultAddNewTask extends HttpServlet
{

    private static final long serialVersionUID = 1L;

    private TaskItemDAO taskItemDao = new TaskItemDAO();

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
        String projectName = request.getParameter("project_name");

        TaskItem task = new TaskItem();
        task.setTaskName(taskName);
        task.setRespPerson(respPerson);
        task.setProjectName(projectName);

        int result = taskItemDao.create(task);
        request.setAttribute("result", result);
        request.getRequestDispatcher("result.jsp").forward(request, response);
        return;
    }
}