import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class student implements Comparable<student>{
    int id;
    String name;
    int age;
    String address;

    student(int id,String name,int age,String address){
        this.id=id;
        this.name=name;
        this.age=age;
        this.address=address;
    }
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    @Override
    public String toString() {
        return id+" "+name+" "+age+" "+address;
    }
    public static void main(String[] args) throws IOException {
        ArrayList<student> arr = new ArrayList<>();
        FileWriter f = new FileWriter("C:/Users/Danet/Desktop/Term-4-Programing/Algorithm Lab 9/03/student_list.txt");
        Scanner Obj = new Scanner(System.in);
        int i=0;
        do{
            
            System.out.print("ID : ");
            int id = Obj.nextInt();
            System.out.print("Name : ");
            Obj.nextLine();
            String name = Obj.nextLine();
            System.out.print("Age : ");
            int age = Obj.nextInt();
            System.out.print("Address : ");
            Obj.nextLine();
            String address = Obj.nextLine();
            student s = new student(id, name, age, address);
            arr.add(s);
            i++; 
        }while(i<5);
        for(int t=0;t<5;t++){
            f.write(arr.get(t)+"\n");
        }
        f.close();
    }
    @Override
    public int compareTo(student o) {
        return name.compareTo(o.name);
    }
}
