
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

public class ProjectItemDAO extends DataAccessObject
{

    /**
     * Create new project record
     * 
     * @param ProjectItem
     *            project
     */
    public int create(ProjectItem project)
    {
        PreparedStatement statement = null;
        Connection connection = null;
        int result = 0;
        try
        {
            connection = getConnection();
            String sql = "INSERT INTO projects "
                    + "(name, id_responsible_person) " + "VALUES (?, ?)";
            statement = connection.prepareStatement(sql);
            statement.setString(1, project.getProjectName());
            statement.setString(2, project.getRespPerson());
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
     * Find all records from projects table
     * 
     * @return List<ProjectItem>
     */
    public List<ProjectItem> findAll()
    {
        LinkedList<ProjectItem> projectItems = new LinkedList<ProjectItem>();
        ResultSet rs = null;
        Connection connection = getConnection();
        PreparedStatement statement = null;
        String sql = "SELECT p.id, p.name AS project_name, r.name FROM projects p "
                + "INNER JOIN responsible_persons r ON p.id_responsible_person = r.id";
        try
        {
            statement = connection.prepareStatement(sql);
            rs = statement.executeQuery();
            while (rs.next())
            {
                ProjectItem projectItem = new ProjectItem();
                if (!(rs.getString(1) == null))
                {
                    projectItem.setId(Integer.valueOf(rs.getString(1)));
                }
                if (!(rs.getString(2) == null))
                {
                    projectItem.setProjectName(rs.getString(2));
                }
                if (!(rs.getString(3) == null))
                {
                    projectItem.setRespPerson(rs.getString(3));
                }

                projectItems.add(projectItem);
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        finally
        {
            close(rs, statement, connection);
        }

        return projectItems;
    }
}
