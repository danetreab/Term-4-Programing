public class Dog {
    private String name;
    public Dog() {
        
    }
    public Dog(String _name) {
        name=_name;
    }
    public void cry() {
        System.out.println(name+" is crying wooh! wooh!");
    }
    public static void main(String[] args) {
        Dog c=new Dog("Kiki");
        c.cry();
    }
}
