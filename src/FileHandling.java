import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FileHandling {
    public static void main(String[] args) {
        File sourcefile = new File("C:\\Users\\Abba\\Desktop\\Java Stuffs\\studentrecords.csv");
        File destinationfile = new File("C:\\Users\\Abba\\Desktop\\Java Stuffs\\studentrecordsCopy.csv");

        try {
            List<String> studentsRecords = Files.readAllLines(Paths.get(sourcefile.toURI()), StandardCharsets.UTF_8);

            try (FileOutputStream output = new FileOutputStream(destinationfile)){

                studentsRecords.forEach(record -> {
                    try {
                        output.write(record.getBytes());
                        output.write("\n".getBytes());
                    } catch (IOException e) {
                        System.out.println(e);
                    }
                });
                output.write("The content of this file is copied from studentrecords File".getBytes());
                output.flush();

            } catch (FileNotFoundException e) {
                System.out.println(e);
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
