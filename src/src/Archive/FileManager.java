package Archive;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class FileManager {
    public static String read(String fileName){
        String content = "";
        try {
            FileReader file = new FileReader(fileName);
            BufferedReader bf = new BufferedReader(file);

            while(bf.ready()){
                content += bf.readLine() + "\n";
            }
            bf.close();
        } catch (Exception e) {
            System.err.println("Error reading the file: " + fileName + "\n error:" + e);
        }
        return content;
    }

    public static boolean write(String fileName, String content){
        try {
            FileWriter file = new FileWriter("Archive/"+fileName, true);
            file.append(content);
            file.close();
        } catch (Exception e) {
            System.err.println("Error writing file: " + fileName + "\nError: " + e);
            return false;
        }
        return true;
    }

    public static void flush(String fileName){
        try {
            FileWriter file = new FileWriter(fileName);
            file.flush();
            file.close();
        } catch (Exception e) {
            System.err.println("Error cleaning the file: " + fileName + "\nError: " + e);
        }
    }
}
