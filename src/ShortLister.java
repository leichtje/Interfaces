import javax.swing.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;


import static java.nio.file.StandardOpenOption.CREATE;

public class ShortLister {

    public static void main(String[] args) {
        JFileChooser chooser = new JFileChooser();
        File selectedFile;
        String rec;
        ShortWordFilter shortWordFilter = new ShortWordFilter();

        try
        {
            File workingDirectory = new File(System.getProperty("user.dir"));
            chooser.setCurrentDirectory(workingDirectory);

            if(chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
            {
                selectedFile = chooser.getSelectedFile();
                Path file = selectedFile.toPath();
                InputStream in =
                        new BufferedInputStream(Files.newInputStream(file, CREATE));
                BufferedReader reader =
                        new BufferedReader(new InputStreamReader(in));

                int line = 0;
                System.out.println("Here are the words in the file that are less than 5 letters: ");
                while(reader.ready())
                {
                    rec = reader.readLine();
                    line++;
                    if (shortWordFilter.accept(rec)) {
                        System.out.println(rec);
                    }
                }
                reader.close();
                System.out.println("\n\nData file read!");
            }
        }
        catch (FileNotFoundException ex)
        {
            System.out.println("File not found!!!");
            ex.printStackTrace();
        }
        catch (IOException ex)
        {
            ex.printStackTrace();
        }
    }



}
