
package web.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.ProjectItem;
import data.ProjectItemDAO;
import data.RespPersonItem;
import data.RespPersonItemDAO;

/**
 * @author Maryia Drozd
 * @version 1.0
 */

@WebServlet("/addNewTask")
public class AddNewTask extends HttpServlet
{

    private static final long serialVersionUID = 1L;

    private RespPersonItemDAO respPersonItemDao = new RespPersonItemDAO();

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
        List<RespPersonItem> respPersonList = respPersonItemDao.findAll();
        request.setAttribute("respPersonList", respPersonList);
        List<ProjectItem> projectList = projectItemDao.findAll();
        request.setAttribute("projectList", projectList);
        request.getRequestDispatcher("addTask.jsp").forward(request, response);
        return;
    }
}
