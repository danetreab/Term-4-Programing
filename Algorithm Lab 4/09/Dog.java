public class Dog {
    public String name;
    public int weight;
    public String owner;
    public Dog(){

    }
    public Dog(String name){
        this.name=name;
    }
    public Dog(String name,int weight){
        this.name=name;
        this.weight=weight;
    }
    public void printInfo(){
        System.out.println("Dog name \""+name+"\"\tDog weight \""+weight+"\"\tDog Owner \""+owner);
    }
}
