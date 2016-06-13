
package data;

import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Maryia Drozd
 * @version 1.0
 */

public class TaskItemDAO extends DataAccessObject
{

    /**
     * Create new task record
     * 
     * @param TaskItem
     *            task
     */
    public int create(TaskItem task)
    {
        PreparedStatement statement = null;
        Connection connection = null;
        int result = 0;
        try
        {
            connection = getConnection();
            String sql = "insert into tasks "
                    + "(name, id_project_name, id_responsible_person) "
                    + "values (?, ?, ?)";
            statement = connection.prepareStatement(sql);
            statement.setString(1, task.getTaskName());
            statement.setString(2, task.getProjectName());
            statement.setString(3, task.getRespPerson());
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
     * Finding all records from tasks table
     * 
     * @return List<TaskItem>
     */
    public List<TaskItem> findAll()
    {
        LinkedList<TaskItem> tasksItems = new LinkedList<TaskItem>();
        ResultSet rs = null;
        PreparedStatement statement = null;
        Connection connection = null;
        try
        {
            connection = getConnection();
            String sql = "SELECT t.id, t.name AS task_name FROM tasks t";
            statement = connection.prepareStatement(sql);
            rs = statement.executeQuery();
            while (rs.next())
            {
                TaskItem tasksItem = new TaskItem();
                if (!(rs.getString(1) == null))
                {
                    tasksItem.setId(Integer.valueOf(rs.getString(1)));
                }
                if (!(rs.getString(2) == null))
                {
                    tasksItem.setTaskName(rs.getString(2));
                }
                tasksItems.add(tasksItem);
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
        return tasksItems;
    }

    /**
     * Finding tasks records for selected project
     * 
     * *@param String param
     * 
     * @return List<TaskItem>
     */
    public List<TaskItem> findTasksInProject(String param)
    {
        LinkedList<TaskItem> tasksItems = new LinkedList<TaskItem>();
        ResultSet rs = null;
        PreparedStatement statement = null;
        Connection connection = null;
        try
        {
            connection = getConnection();
            String sql = "SELECT p.name, t.id, t.name " + "FROM projects p "
                    + "RIGHT OUTER JOIN tasks t ON t.id_project_name = p.id "
                    + "WHERE p.id = ?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, param);
            rs = statement.executeQuery();
            while (rs.next())
            {
                TaskItem taskItem = new TaskItem();
                if (!(rs.getString(1) == null))
                {
                    taskItem.setProjectName(rs.getString(1));
                }
                if (!(rs.getString(2) == null))
                {
                    taskItem.setId(Integer.valueOf(rs.getString(2)));
                }
                if (!(rs.getString(3) == null))
                {
                    taskItem.setTaskName(rs.getString(3));
                }
                tasksItems.add(taskItem);
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
        return tasksItems;
    }
}
