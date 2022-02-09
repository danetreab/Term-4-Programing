import java.util.Scanner;

class Lab1_ex10 {
    public static void main(String[] args) {
        Scanner Obj=new Scanner(System.in);
        final float pi = 3.14f; 
        System.out.print("Enter the radius of the circle : ");
        float a=Obj.nextFloat();
        float area=pi*a*a, perimeter=2*pi*a;
        System.out.println("Area of circle : "+area);
        System.out.println("Perimeter of circle : "+perimeter);
    }
}
