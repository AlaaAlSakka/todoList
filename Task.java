import java.util.Scanner;
import java.util.Date;
import java.util.Iterator;
import java.util.ArrayList;
import java.time.LocalDate;


public class Task implements Comparable<Task>{

    private String project;
    private String title;
    private LocalDate dueDate;
    private boolean isDone = false;
    private String status;


    public Task(String project, String title, LocalDate date, String isDone)
    {
        this.title = title;
        this.project = project;
        this.dueDate = date;
        //TODO convert string to boolean
        this.status = isDone;

    }

    public Task()
    {
    }


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
        return "Project: " + project + "--------" +"Task:" + title + "--------" + dueDate + "--------" + status;
    }

    public String toWriteInFile()
    {
        return "" + project + "--------" +"" + title + "--------" + dueDate + "--------" + status;

    }


    @Override
    public int compareTo(Task t )
    {

        return dueDate.compareTo(t.getDueDate());
    }




}







