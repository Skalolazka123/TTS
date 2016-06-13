
package web.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.ProjectItem;
import data.ProjectItemDAO;

/**
 * @author Maryia Drozd
 * @version 1.0
 */

@WebServlet("/resultAddNewProject")
public class ResultAddNewProject extends HttpServlet
{

    private static final long serialVersionUID = 1L;

    private ProjectItemDAO projectItemDao = new ProjectItemDAO();

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
        String projectName = request.getParameter("project_name");
        String respPerson = request.getParameter("resp_person");

        ProjectItem project = new ProjectItem();
        project.setProjectName(projectName);
        project.setRespPerson(respPerson);

        int result = projectItemDao.create(project);
        request.setAttribute("result", result);
        request.getRequestDispatcher("result.jsp").forward(request, response);
        return;
    }
}