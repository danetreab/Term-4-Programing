import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class App {
    public static void main(String[] args) throws Exception {
        File Obj = new File("hello.txt");
        Obj.createNewFile();
    }
}
