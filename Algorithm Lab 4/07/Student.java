import java.util.jar.Attributes.Name;

public class Student {
    public int id;
    public String name;
    public String department;
    public int generation;
    
    public Student(){

    }
    public Student(String name) {
        this.name=name;
    }
    public Student(int id,String name){
        this.id=id;
        this.name=name;
    }
    public Student(int id,String name,String department){
        this.id=id;
        this.name=name;
        this.department=department;
    }
    public Student(int id,String name,String department,int generation){
        this.id=id;
        this.name=name;
        this.department=department;
        this.generation=generation;
    }
    public void printInfo(){
        System.out.println("ID : "+id+"\nName : "+name+"\nDepartment : "+department+"\nGeneration : "+generation);
    }
}
