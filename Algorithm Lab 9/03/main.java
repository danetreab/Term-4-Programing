import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.TreeSet;

public class main {
    private static Scanner x;
    public static void main(String[] args) throws IOException {
        TreeSet<student> tree = new TreeSet<>();
        x=new Scanner(new File("C:/Users/Danet/Desktop/Term-4-Programing/Algorithm Lab 9/03/student_list.txt"));
        Scanner Obj = new Scanner(System.in);
        
        while(x.hasNext()){
            String id = x.next();
            String name = x.next();
            String age = x.next();
            String address = x.next();
            // System.out.println(Integer.parseInt(id));
            System.out.println(Integer.parseInt(age));
            student s = new student(Integer.parseInt(id), name, Integer.parseInt(age), address);

            tree.add(s);
        }
        System.out.println(tree);
    }
}

