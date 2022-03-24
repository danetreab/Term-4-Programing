import java.io.FileReader;
import java.io.IOException;

public class readfile {
    public static void main(String[] args) throws IOException {
        FileReader p = new FileReader("C:\\Git\\Term-4-Programing\\Algorithm Lab 9\\01\\data.txt");
        int line;
        while((line = p.read()) != -1){
            System.out.print((char)line);
        }
    }
}
