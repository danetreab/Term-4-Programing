public class Student extends Human implements MoveAble {
    public String schoolname;
    public String skill;
    Student(String name, int age, String nationality,String schoolname,String skill) {
        super(name, age, nationality);
        this.schoolname=schoolname;
        this.skill=skill;
    }
    @Override
    public void moveLeft() {
        System.out.println("Student Turn left");
    }

    @Override
    public void moveRight() {
        System.out.println("Student Turn right");
    }

    @Override
    public void moveUp() {
        System.out.println("Student move Up");
    }

    @Override
    public void moveDown() {
        System.out.println("Student move Down");
    }
    @Override
    public String GetResponsible() {
        return "Study";
    }
    @Override
    public String toString(){
        return schoolname+" "+skill;
    }
    
}
