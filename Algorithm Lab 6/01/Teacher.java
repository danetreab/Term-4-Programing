public class Teacher extends Human {
    public int salary;
    public String schoolname;
    Human human;
    public int getSalary() {
        return this.salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getSchoolname() {
        return this.schoolname;
    }

    public void setSchoolname(String schoolname) {
        this.schoolname = schoolname;
    }
    Teacher(String name, int age, String nationality,int salary,String schoolname) {
        super(name, age, nationality);
        this.salary=salary;
        this.schoolname=schoolname;
    }
    public String getResponsible(){
        return "Teach";
    }
    @Override
    public String toString(){
        return schoolname+" "+salary;
    }
}
