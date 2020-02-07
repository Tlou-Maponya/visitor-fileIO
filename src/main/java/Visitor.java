import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Visitor {

    Logger visitorLog = LogManager.getLogger(Visitor.class);
    public String fullName;
    public int age;
    public String comments;
    public String assist;

    private DateTimeFormatter formatDate = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    private LocalDateTime now = LocalDateTime.now();

    public Visitor(){}

    public Visitor(String name, int a, String comment, String assistant){


        System.out.println(formatDate.format(now));
        fullName = name;
        age = a;
        comments = comment;
        assist = assistant;
    }

/**************************************************************************************************************/

    public void save(){
        StringBuilder buildVisitor = new StringBuilder();
        buildVisitor.append("Name: " + fullName + "\n")
                    .append(" ")
                    .append("Age: " + age + "\n")
                    .append(" ")
                    .append("Date: " + formatDate.format(now) + "\n")
                    .append(" ")
                    .append("Comment: " + comments + "\n")
                    .append(" ")
                    .append("Assisted by: " + assist + "\n");

        String full_Name = fullName.replace(" ", "_");
        String fileName = "visitor_" + full_Name + ".txt";

        File createFile = null;
        try {
            createFile = new File(fileName);
            if(createFile.createNewFile()) {
                Files.write(Paths.get(fileName),String.valueOf(buildVisitor).getBytes());
            }
            else
                throw new IOException("Error, file already exist");
        } catch (IOException e) {
            e.printStackTrace();
            visitorLog.info(e);
            System.out.println("Exception caught");
        }
    }

    public String load(String name)
    {

        String full_Name = name.replace(" ", "_");
        String fileName = "visitor_" + full_Name + ".txt";
        BufferedReader bufferedFile = null;
        try {
            bufferedFile = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = bufferedFile.readLine()) !=null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return full_Name;
    }

}
