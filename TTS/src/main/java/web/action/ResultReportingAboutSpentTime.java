package web.action;

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
 * @author      Maryia Drozd
 * @version     1.0
 */

@WebServlet("/resultReporting")
public class ResultReportingAboutSpentTime extends HttpServlet {

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
      //Initialize parameters from request
        String startDateParam = request.getParameter("start_date");
        String endDateParam = request.getParameter("end_date");


        List<SpentTimeItem> spentTimeList = spentTimeItemDao.findInDateRange(startDateParam, endDateParam);
        request.setAttribute("spentTimeList", spentTimeList);
        List<SpentTimeItem> spentTimeForEachRespPersonList = spentTimeItemDao.findSpentTimeForEachRespPersonInDateRange(startDateParam, endDateParam);
        request.setAttribute("spentTimeForPersonList", spentTimeForEachRespPersonList);
        request.getRequestDispatcher("resultReportingAboutSpentTime.jsp").forward(request, response);
        return;
    }
}
