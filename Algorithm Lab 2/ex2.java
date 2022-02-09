import java.util.Scanner;

class ex2 {
    public static void main(String[] args) {
        Scanner Obj = new Scanner(System.in);
        System.out.println("Input three number : ");
        int a = Obj.nextInt();
        int b = Obj.nextInt();
        int c = Obj.nextInt();
        if(a>=b && a>=c)  
            System.out.println(a+" is the largest Number");  
        else if (b>=a && b>=c)  
            System.out.println(b+" is the largest Number");  
        else  
            System.out.println(c+" is the largest number");  
    }
}
