import java.util.Scanner;

public class MainForDog {
    public static void main(String[] args) {
        Dog dog = new Dog();
        Dog dogs = new Dog("KILI");
        fillData(dog);
    }
    public static void fillData(Dog dogs) {
        Scanner Obj = new Scanner(System.in);
            System.out.println("Name weight");
            String name = Obj.nextLine();
            int weight = Integer.valueOf(Obj.nextInt());
            dogs = new Dog(name,weight);
    }
    public static void fillData_(Dog dog) {
        Scanner Obj = new Scanner(System.in);
            System.out.println("Name");
            String name = Obj.nextLine();
            dog = new Dog(name);
    }
}
