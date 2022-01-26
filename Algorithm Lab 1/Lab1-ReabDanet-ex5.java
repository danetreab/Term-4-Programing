import java.util.Scanner;

class Lab1_ex5 {
   public static void main(String[] args) {
       Scanner Obj=new Scanner(System.in);
       System.out.print("Input number in feet : ");
       float a=Obj.nextFloat();
       a *= 0.305;
       System.out.println("Result in meter : "+a);
   } 
}
