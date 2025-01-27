import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class _1_File_Handling {
    @SuppressWarnings("all")
    public static void main(String[] args) {

        // 1. Creating a File:
        File myFile = new File("example.txt");

        try{
            myFile.createNewFile();
            System.out.println("File Created Successfully!!\n");
        }catch (IOException e){
            System.out.println("Error:: Creating File");
            e.printStackTrace();
        }


        // 2. Writing to a File:
        try{
            FileWriter fileWriter = new FileWriter("file.txt");
            fileWriter.write("Hello World!\nThis content is written using JAVA!!");
            System.out.println("Finished Writting in File...\n");
            fileWriter.close();
        }catch (IOException e){
            System.out.println(e);
        }


        // 3. Reading content from a file:
        File newFile = new File("content.txt");
        try{
            Scanner sc = new Scanner(newFile);// Initialise the Scanner object to read data from the "java.txt" file
            while(sc.hasNextLine()){
                String line = sc.nextLine();
                System.out.println(line);
            }
            sc.close();
        }catch(IOException e){
            System.out.println("ERROR:: While Reading a File!!\n"+e);
        }


        // 4. Appending to a file:

        try {
            FileWriter writer = new FileWriter("content.txt", true); // 'true' enables appending
            writer.write("\n\nJava is awesome 😃 because it appended this line");
            writer.close();
            System.out.println("Data successfully appended to the file...");
        } catch (IOException e) {
            System.out.println("ERROR:: appending to the file.");
            e.printStackTrace();
        }

        // 5. Deleting a file:
        File file = new File("example.txt");
        if(myFile.delete()){
            System.out.println("Deleting the file...");
            System.out.println("Successfully Deleted: " + myFile.getName());
        }
        else{
            System.out.println("ERROR:: deleting the file");
        }

    }
}
