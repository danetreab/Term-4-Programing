public class Teacher extends Human implements MoveAble{
    public double salary;
    public String schoolname;
    Teacher(String name, int age, String nationality,double salary,String schoolname) {
        super(name, age, nationality);
        this.salary=salary;
        this.schoolname=schoolname;
    }
    @Override
    public void moveLeft() {
        System.out.println("Teacher move left");
    }

    @Override
    public void moveRight() {
        System.out.println("Teacher move right");
    }

    @Override
    public void moveUp() {
        System.out.println("Teacher move up");
    }

    @Override
    public void moveDown() {
        System.out.println("Teacher move down");
    }

    @Override
    public String GetResponsible() {
        return "Teach";
    }
    
}
