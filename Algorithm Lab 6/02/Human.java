abstract class Human {
    private String name;
    private int age;
    private String nationality;
    Human(String name,int age, String nationality){
        this.name=name;
        this.age=age;
        this.nationality=nationality;
    }
    public String getNationality() {
        return nationality;
    }
    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public abstract String getResponsible();
    @Override 
    public String toString(){
        return name+" "+age+" "+nationality;
    }
}
