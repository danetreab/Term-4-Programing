import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class createfile{
       public static void main(String[] args) {
        
        try {
            FileWriter Obj = new FileWriter("hello.txt");
            Obj.write("hello");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
       }
}