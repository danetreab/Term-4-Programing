public abstract class Human {
    private String name;
    private int age;
    private String nationality;
    Human(String name,int age,String nationality){
        this.name=name;
        this.age=age;
        this.nationality=nationality;
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

    public String getNationality() {
        return this.nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
    public abstract String GetResponsible();
    @Override
    public String toString(){
        return name+" "+age+" "+nationality;
    }
}
