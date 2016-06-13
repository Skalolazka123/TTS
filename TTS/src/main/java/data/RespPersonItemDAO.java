
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

public class RespPersonItemDAO extends DataAccessObject
{

    /**
     * Find all records from responsible_persons table
     * 
     * @return List<RespPersonItem>
     */
    public List<RespPersonItem> findAll()
    {
        LinkedList<RespPersonItem> respPersonItems = new LinkedList<RespPersonItem>();
        ResultSet rs = null;
        Connection connection = getConnection();
        PreparedStatement statement = null;
        String sql = "SELECT r.id, r.name FROM responsible_persons r";
        try
        {
            statement = connection.prepareStatement(sql);
            rs = statement.executeQuery();
            while (rs.next())
            {
                RespPersonItem respPersonItem = new RespPersonItem();
                if (!(rs.getString(1) == null))
                {
                    respPersonItem.setId(Integer.valueOf(rs.getString(1)));
                }
                if (!(rs.getString(2) == null))
                {
                    respPersonItem.setPersonName(rs.getString(2));
                }
                respPersonItems.add(respPersonItem);
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

        return respPersonItems;
    }
}
