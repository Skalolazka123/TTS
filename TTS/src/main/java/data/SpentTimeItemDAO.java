
package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Maryia Drozd
 * @version 1.0
 */

public class SpentTimeItemDAO extends DataAccessObject
{

    /**
     * Create new spent_time record
     * 
     * @param SpentTimeItem
     *            spentTime
     */
    public int create(SpentTimeItem spentTime)
    {
        PreparedStatement statement = null;
        Connection connection = null;
        int result = 0;
        try
        {
            connection = getConnection();
            String sql = "INSERT INTO spent_time (date, hours, id_responsible_person, id_task) "
                    + "values (?, ?, ?, ?)";
            statement = connection.prepareStatement(sql);
            statement.setString(1, spentTime.getDate());
            statement.setString(2, spentTime.getHours());
            statement.setString(3, spentTime.getRespPerson());
            statement.setString(4, spentTime.getTask());
            result = statement.executeUpdate();

        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
        finally
        {
            close(statement, connection);
        }
        return result;
    }

    /**
     * Find all spent_time records from selected task
     * 
     * @param String
     *            param
     * 
     * @return List<SpentTimeItem>
     */
    public List<SpentTimeItem> findAllSpentTimeForSelectedTask(String param)
    {
        List<SpentTimeItem> spentTimeItems = new LinkedList<SpentTimeItem>();
        ResultSet rs = null;
        PreparedStatement statement = null;
        Connection connection = null;
        try
        {
            connection = getConnection();
            String sql = "SELECT t.name, r.name, s.hours "
                    + "FROM spent_time s "
                    + "LEFT OUTER JOIN tasks t ON t.id = s.id_task "
                    + "LEFT OUTER JOIN responsible_persons r ON s.id_responsible_person = r.id "
                    + "WHERE t.id = ?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, param);
            rs = statement.executeQuery();
            while (rs.next())
            {
                SpentTimeItem spentTimeItem = new SpentTimeItem();
                if (!(rs.getString(1) == null))
                {
                    spentTimeItem.setTask(rs.getString(1));
                }
                if (!(rs.getString(2) == null))
                {
                    spentTimeItem.setRespPerson(rs.getString(2));
                }
                if (!(rs.getString(3) == null))
                {
                    spentTimeItem.setHours(rs.getString(3));
                }
                spentTimeItems.add(spentTimeItem);
            }
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
        finally
        {
            close(rs, statement, connection);
        }
        return spentTimeItems;
    }

    /**
     * Find all spent_time records for selected Date Range
     * 
     * @param String
     *            startDate
     * @param String
     *            endDate
     * 
     * @return List<SpentTimeItem>
     */
    public List<SpentTimeItem> findInDateRange(String startDate, String endDate)
    {
        List<SpentTimeItem> spentTimeItems = new LinkedList<SpentTimeItem>();
        ResultSet rs = null;
        PreparedStatement statement = null;
        Connection connection = null;
        try
        {
            connection = getConnection();
            String sql = "SELECT s.date, s.hours, r.name, t.name "
                    + "FROM spent_time s "
                    + "LEFT OUTER JOIN tasks t ON t.id = s.id_task "
                    + "LEFT OUTER JOIN responsible_persons r ON s.id_responsible_person = r.id "
                    + "WHERE (s.date BETWEEN ?  AND ?)";
            statement = connection.prepareStatement(sql);
            statement.setString(1, startDate);
            statement.setString(2, endDate);
            rs = statement.executeQuery();
            while (rs.next())
            {
                SpentTimeItem spentTimeItem = new SpentTimeItem();
                if (!(rs.getString(1) == null))
                {
                    spentTimeItem.setDate(rs.getString(1));
                }
                if (!(rs.getString(2) == null))
                {
                    spentTimeItem.setHours(rs.getString(2));
                }
                if (!(rs.getString(3) == null))
                {
                    spentTimeItem.setRespPerson(rs.getString(3));
                }
                if (!(rs.getString(4) == null))
                {
                    spentTimeItem.setTask(rs.getString(4));
                }
                spentTimeItems.add(spentTimeItem);
            }
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
        finally
        {
            close(rs, statement, connection);
        }
        return spentTimeItems;
    }

    /**
     * Find all spent_time records for each Responsible Person for selected Date
     * Range
     * 
     * @param String
     *            startDate
     * @param String
     *            endDate
     * 
     * @return List<SpentTimeItem>
     */
    public List<SpentTimeItem> findSpentTimeForEachRespPersonInDateRange(
            String startDate, String endDate)
    {
        List<SpentTimeItem> spentTimeItems = new LinkedList<SpentTimeItem>();
        ResultSet rs = null;
        PreparedStatement statement = null;
        Connection connection = null;
        try
        {
            connection = getConnection();
            String sql = "SELECT r.name, SUM(s.hours) FROM spent_time s "
                    + "RIGHT JOIN responsible_persons r ON s.id_responsible_person = r.id "
                    + "WHERE (s.date BETWEEN ?  AND ?) " + "GROUP BY r.name;";
            statement = connection.prepareStatement(sql);
            statement.setString(1, startDate);
            statement.setString(2, endDate);
            rs = statement.executeQuery();
            while (rs.next())
            {
                SpentTimeItem spentTimeItem = new SpentTimeItem();
                if (!(rs.getString(1) == null))
                {
                    spentTimeItem.setRespPerson(rs.getString(1));
                }
                if (!(rs.getString(2) == null))
                {
                    spentTimeItem.setHours(rs.getString(2));
                }
                spentTimeItems.add(spentTimeItem);
            }
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
        finally
        {
            close(rs, statement, connection);
        }
        return spentTimeItems;
    }

}
