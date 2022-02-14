public class Dog {
    private String name;
    private int weight;
    public Dog(){

    }
    public Dog(String name){
        this.name=name;
    }
    public Dog(String name,int weight){
        this.weight=weight;
    }
    public void printInfo(){
        System.out.println("Dog name \""+name+"\" Weight \""+weight+"\"");
    }
}
