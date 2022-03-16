public class student{
    int id;
    String name;
    int age;
    String address;
    public int getId() {
        return this.id;
    }public void setId(int id) {
        this.id = id;
    }public String getName() {
        return this.name;
    }public void setName(String name) {
        this.name = name;
    }public int getAge() {
        return this.age;
    }public void setAge(int age) {
        this.age = age;
    }public String getAddress() {
        return this.address;
    }public void setAddress(String address) {
        this.address = address;
    }student(){}
    student(int id, String name,int age, String address){
        this.id=id;
        this.name=name;
        this.age=age;
        this.address=address;
    }@Override
    public String toString() {
        return id+" "+name+" "+age+" "+address;
    }

} 

