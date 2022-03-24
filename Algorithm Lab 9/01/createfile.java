import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class createfile{
    public static void main(String[] args) {
        String name ="";
            try {
                FileWriter p = new FileWriter("C:\\Git\\Term-4-Programing\\Algorithm Lab 9\\01\\data.txt");
                do{
                    System.out.print("Input : ");
                    Scanner Obj = new Scanner(System.in);
                    name = Obj.nextLine();
                    p.write(name+"\n");
                    
                }while(!name.equals("stop"));
                p.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
    }
}
