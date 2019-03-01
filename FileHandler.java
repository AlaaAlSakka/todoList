import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.time.format.DateTimeFormatter;


public class FileHandler
{

    private final String filepath = "//Users//alaa/Desktop//TodoList//file";


    public void saveArrayList(ArrayList<Task> taskList)
    {
        try {
            FileOutputStream os = new FileOutputStream(filepath);
            DataOutputStream oo = new DataOutputStream(os);
            oo.writeUTF("\r");
            for (Task task : taskList)
            {
                System.out.println(task.toString());
                oo.writeUTF(task.toString() + "\r");
            }
            //oo.writeObject(taskList);
            System.out.println("Done saving");
            os.close();
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        }
    }

    public ArrayList<Task> loadFromFile() throws Exception
    {
        FileInputStream is = new FileInputStream(filepath);
        DataInputStream ii = new DataInputStream(is);

        ArrayList<Task> taskList = new ArrayList<>();
        String line = ii.readUTF();
        Task task;

        while(ii.available()>0) {
            line = ii.readUTF();
            System.out.println(line);

            String[] values = line.split("--------");
            String project = values[0].substring(9);
            System.out.println(project);
            String title = values[1].substring(5);
            System.out.println(title);
            String date = values[2];
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate localDate = LocalDate.parse(date, formatter);
            String status = values[3];
            task = new Task(project, title, localDate, status);
            taskList.add(task);




        }
            return null;
    }




}
