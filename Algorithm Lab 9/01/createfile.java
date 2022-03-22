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
                // p.write("Hello");
                // p.close();
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
    }
}