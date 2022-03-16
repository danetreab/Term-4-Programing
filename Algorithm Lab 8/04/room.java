import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class room {
    static HashMap<Integer,student> h = new HashMap<>();
    public static void addstudent(int id,String name,int age,String address){
        student s = new student(id,name,age,address);
        if(age<0){
                try {
                    throw new Exceptionerror("\nAge can't be negative");
                } catch (Exceptionerror e) {
                    e.printStackTrace();
                }
            }else{
                h.put(id, s);
                // System.out.println(h);
            }
    }
    public static void search(int id){
        System.out.println(h.get(id));
    }
    public static void edit(int id) {
        Scanner Obj = new Scanner(System.in);
        if(h.containsKey(id)){
            System.out.print("Student ID : ");
                int newid = Obj.nextInt();
                System.out.print("Student Name : ");
                String newname = Obj.next();
                System.out.print("Student age : ");
                int newage = Obj.nextInt();
                System.out.print("Address : ");
                String newaddress = Obj.next();
            // Student s = new Student(newid, name, age, address);
            h.remove(id);
            addstudent(newid, newname, newage, newaddress);
        }else{
            try {
                throw new Exceptionerror("\nID not exist"); 
            } catch (Exceptionerror e) {
                e.printStackTrace();
            }   
        }
    }
    public static void remove(int key) {
        h.remove(key);
    }
    public static void list(){
        System.out.println(h);
    }
    public static void main(String[] args) {
        Scanner Obj = new Scanner(System.in);
        int i=0;
        do{
            System.out.println("1. Add Student");
            System.out.println("2. Search Student");
            System.out.println("3. Edit Student");
            System.out.println("4. Remove Student");
            System.out.println("5. Print list of student");
            System.out.println("6. Exit");
            System.out.print("Input : ");
            i = Obj.nextInt();
            if(i==1){
                System.out.print("Student ID : ");
                int id = Obj.nextInt();
                System.out.print("Student Name : ");
                String name = Obj.next();
                System.out.print("Student age : ");
                int age = Obj.nextInt();
                System.out.print("Address : ");
                String address = Obj.next();
                addstudent(id, name, age, address);
            }else if(i==2){
                System.out.print("Enter ID to Search : ");
                int id = Obj.nextInt();
                search(id);
            }else if(i==3){
                System.out.print("Enter id to Edit : ");
                int id = Obj.nextInt();
                edit(id);
            }else if(i==4){
                System.out.print("Enter id to remove : ");
                int id = Obj.nextInt();
                remove(id);
            }else if(i==5){
                list();
            }
        }while(i!=6);
    }
}

