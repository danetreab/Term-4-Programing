public class Cat {
    private String name;
    public String color;
    public void setName(String _name){
        name = _name;
    }
    public String getName() {
        return name;
    }
    public void cry(){
        System.out.println(name+" is crying Meow Meow!");
    }
}
