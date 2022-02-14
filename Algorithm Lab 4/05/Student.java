public class Student {
    public String firstname;
    public String lastname;
    public String student_id;
    public String address;
    public Student() {
        
    }
    public Student(String firstname,String lastname,String student_id) {
        this.firstname=firstname;
        this.lastname=lastname;
        this.student_id=student_id;
    }
    public Student(String firstname,String lastname,String student_id,String address) {
        this.firstname=firstname;
        this.lastname=lastname;
        this.student_id=student_id;
        this.address=address;
    }
    public void printInfo() {
        System.out.println("First Name : "+ firstname+"\nLast Name : "+lastname+"\nStudent-id : "+student_id+"\nAddress : "+address);
    }
}
