import java.util.Scanner;

class Lab1_ex6 {
    public static void main(String[] args) {
        Scanner Obj= new Scanner(System.in);
        System.out.print("Input the number in pound : ");
        float a=Obj.nextFloat();
        a*=0.454;
        System.out.println("The result in kilograms : "+a);
    }
}
