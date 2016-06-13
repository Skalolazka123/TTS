
package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Maryia Drozd
 * @version 1.0
 */

public class DataAccessObject
{

    /**
     * Create connection to DB. Static method
     * 
     */
    protected static Connection getConnection()
    {
        Connection connection = null;

        final String JDBC_URL = "jdbc:mysql://127.0.0.1:3306/tts?autoReconnect=true&useSSL=false&serverTimezone=UTC";
        final String DB_LOGIN = "root";
        final String DB_PASSWORD = "password";
        final String JDBC_DRIVER = "com.mysql.jdbc.Driver";

        try
        {
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(JDBC_URL, DB_LOGIN,
                    DB_PASSWORD);
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return connection;

    }

    /**
     * Close session with DB if we didn't use ResultSet class Using for UPDATE
     * and INSERT queries (for example) Static method
     * 
     */
    protected static void close(Statement statement, Connection connection)
    {
        close(null, statement, connection);
    }

    /**
     * Close session with DB Static method
     * 
     */
    protected static void close(ResultSet rs, Statement statement,
            Connection connection)
    {
        try
        {
            if (rs != null) rs.close();
            if (statement != null) statement.close();
            if (connection != null) connection.close();
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }
}