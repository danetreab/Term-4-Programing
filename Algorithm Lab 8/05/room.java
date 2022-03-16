import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

public class room {
    static ArrayList<student> h = new ArrayList<>();
    public static void addstudent(int id,String name,int age,String address){
        student s = new student(id,name,age,address);
        if(age<0){
                try {
                    throw new Exceptionerror("\nAge can't be negative");
                } catch (Exceptionerror e) {
                    e.printStackTrace();
                }
            }else{
                h.add(s);
                // System.out.println(h);
            }
    }
    public static void search(int id){
        student t = new student();
        boolean flage=false;
        int temp=0;
        for(int i=0;i<h.size();i++){
            if(id==h.get(i).id){
                flage=true;
                i=temp;
            }
        }
        if(flage){
            System.out.println(h.get(temp));
        }else{
            try {
                throw new Exceptionerror("\nSearch Not found");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    public static void edit(int id) {
        boolean flage=false;
        Scanner Obj = new Scanner(System.in);
        for(int i=0;i<h.size();i++){
        if(id==h.get(i).id){
            System.out.print("Student ID : ");
                int newid = Obj.nextInt();
                System.out.print("Student Name : ");
                String newname = Obj.next();
                System.out.print("Student age : ");
                int newage = Obj.nextInt();
                System.out.print("Address : ");
                String newaddress = Obj.next();
            // Student s = new Student(newid, name, age, address);
            h.remove(i);
            addstudent(newid, newname, newage, newaddress);
            flage=true;
        }
        // System.out.println(h);
    }
    if(flage==false){
        try {
            throw new Exceptionerror("\nID not exist"); 
        } catch (Exceptionerror e) {
            e.printStackTrace();
        }   
        }
    }
    public static void remove(int key) {
        boolean flage=false;
        for(int i=0;i<h.size();i++){
            if(key==h.get(i).id){
                h.remove(i);
                flage=true;
            }
        }
        if(flage==false){
            try {
                throw new Exceptionerror("can't find that id");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
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
