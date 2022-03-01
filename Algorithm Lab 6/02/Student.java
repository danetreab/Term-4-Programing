public class Student extends Human {
    Human human;
    public String schoolname;
    public String skill;
    Student(String name, int age, String nationality,String schoolname,String skill) {
        super(name, age, nationality);
        this.schoolname=schoolname;
        this.skill=skill;
    }
    public Human getHuman() {
        return this.human;
    }
    public void setHuman(Human human) {
        this.human = human;
    }

    public String getSchoolname() {
        return this.schoolname;
    }

    public void setSchoolname(String schoolname) {
        this.schoolname = schoolname;
    }

    public String getSkill() {
        return this.skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }
    public String getResponsible(){
        return "Study";
    }
    @Override
    public String toString(){
        return skill+" "+schoolname;
    }
}
