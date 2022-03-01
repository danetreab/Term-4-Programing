public class main {
    public static void main(String[] args) {
        Human student = new Student("Jonh", 15, "Khmer", "CADT", "Computer Scient");
        Human teacher = new Teacher("Mark", 15, "English", 1500, "NPIC");
        MoveAble tiger = new Tiger("Red",55);
        
        System.out.println(student.getName()+" "+student.getAge()+" "+student.getNationality()+" "+student);
        System.out.println(teacher.getName()+" "+teacher.getAge()+" "+teacher.getNationality()+" "+teacher);
        System.out.println(tiger);
        tiger.moveDown();tiger.moveLeft();tiger.moveDown();
    }
}
