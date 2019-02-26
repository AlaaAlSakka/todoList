import java.util.Scanner;
import java.util.Date;
import java.util.Iterator;
import java.util.ArrayList;
import java.time.LocalDate;


public class Task implements Comparable<Task>{

    // isDone, title, project, date
    //  public TaskList project;

    private String title;
    private LocalDate dueDate;
    private boolean isDone = false;
    private String project;
    private String status;
    //public ArrayList<Task> doneList = new ArrayList<>();
   // TaskList taskList =new TaskList();


   /*public Task(String title, String dueDate) {
        this.title = title;
        this.dueDate = dueDate;
        this.isDone = false;
    }
*/


    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {

        this.title = title;
    }

    public LocalDate getDueDate()
    {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate)
    {
        this.dueDate = dueDate;
    }

    public boolean status ()
    {
        isDone = true;
        return isDone;
    }


    public String getProject()
    {

        return project;
    }

    public String getStatus( )
    {
        return status;
    }

    public void setProject(String project)
    {
        this.project = project;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }


    @Override
    public String toString()
    {
        return "Project: " + project + "--------" +"Task:" + title + "-------- " + dueDate + "--------" + status;
    }


    @Override
    public int compareTo(Task t )
    {

        return dueDate.compareTo(t.getDueDate());
    }




}







