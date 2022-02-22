public class Student extends Human{
    public int studentId;
    public String schoolName;
    public String skill;
    public Student(){

    }
    public Student(int studentId,String schoolName,String skill){
        this.schoolName=schoolName;
        this.studentId=studentId;
        this.skill=skill;
    }
    public void setId(int studentId){
        this.studentId=studentId;
    }
    public int getId(){
        return studentId;
    }
    public void setSchool(String schoolName){
        this.schoolName=schoolName;
    }
    public String getSchool(){
        return schoolName;
    }
    public void setSkill(String skill){
        this.skill=skill;
    }
    public String getSkill(){
        return skill;
    }
}
