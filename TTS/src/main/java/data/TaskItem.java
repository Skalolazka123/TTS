
package data;

/**
 * @author Maryia Drozd
 * @version 1.0
 */

public class TaskItem
{

    private String taskName;

    private String respPerson;

    private String spentTime;

    private int id;

    private String projectName;

    public String getTaskName()
    {
        return taskName;
    }

    public void setTaskName(String taskName)
    {
        this.taskName = taskName;
    }

    public String getRespPerson()
    {
        return respPerson;
    }

    public void setRespPerson(String respPerson)
    {
        this.respPerson = respPerson;
    }

    public String getSpentTime()
    {
        return spentTime;
    }

    public void setSpentTime(String spentTime)
    {
        this.spentTime = spentTime;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getProjectName()
    {
        return projectName;
    }

    public void setProjectName(String projectName)
    {
        this.projectName = projectName;
    }

}
