public class Human implements DoAble {
    private String name;
    private int age;
    private String nationality;
    Human(){
        
    }
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

    @Override
    public void doThis() {
        System.out.println("Say Hello");
    }

    @Override
    public void doThat() {
        System.out.println("Say Hi");
    }
    @Override
    public String toString(){
        return "Name : "+name+"\nAge : "+age+"\nNationality : "+nationality;
    }
    
}
