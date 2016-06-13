
package web;

import java.io.IOException;
import java.util.List;

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

@WebServlet("/project")
public class Project extends HttpServlet
{

    private static final long serialVersionUID = 1L;

    private TaskItemDAO tasksItemDao = new TaskItemDAO();

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
        List<TaskItem> tasks = tasksItemDao.findTasksInProject(reqIdParam);
        request.setAttribute("tasksList", tasks);
        request.setAttribute("projectName", reqNameParam);
        request.getRequestDispatcher("project.jsp").forward(request, response);
        return;
    }
}
