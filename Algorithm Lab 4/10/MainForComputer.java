import java.util.Scanner;

public class MainForComputer {
    public static void main(String[] args) {
        Computer c = new Computer();
        Computer c1 = new Computer();
        getInfo(c);
        getInfo(c1);
    }
    public static void getInfo(Computer computers){
        Scanner Obj = new Scanner(System.in);
            System.out.println("Brand\tModel\tRam");
            String brand = Obj.nextLine();
            String model = Obj.nextLine();
            int ram = Integer.valueOf(Obj.nextLine());
            computers = new Computer(brand,model,ram);
    }
    public static void getInfo_(Computer computers2){
        Scanner Obj = new Scanner(System.in);
            System.out.println("Brand\tModel\tRam\tHDD");
            String brand = Obj.nextLine();
            String model = Obj.nextLine();
            int ram = Integer.valueOf(Obj.nextLine());
            int HDD = Integer.valueOf(Obj.nextLine());
            computers2 = new Computer(brand,model,ram,HDD);
    }

}
