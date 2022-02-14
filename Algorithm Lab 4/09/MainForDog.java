import java.util.Scanner;

public class MainForDog {
    public static void main(String[] args) {
        Dog[] dog = new Dog[5];
        fillData(dog);
        printInfo(dog);
    }
    public static void fillData(Dog[] dogs){
        Scanner Obj = new Scanner(System.in);
        System.out.println("Dog-Name\tDog-Weight");
        for(int i=0;i<5;i++){
            String name = Obj.nextLine();
            int Weight = Integer.valueOf(Obj.nextLine());
            dogs[i]=new Dog(name,Weight);
        }
    }
    public static void printInfo(Dog[] dogs) {
        for(int i=0;i<5;i++){
            System.out.println("Dog-name \""+dogs[i].name+"\"\tDog-Weight \""+dogs[i].weight+"\"");
        }
    }
}
