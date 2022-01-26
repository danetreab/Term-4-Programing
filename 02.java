import java.util.Scanner;

class Hello {
    public static void main(String[] args) {
        Scanner Obj = new Scanner(System.in);
        System.out.print("Input first number : ");
        int a=Obj.nextInt();
        System.out.print("Input second number : ");
        int b=Obj.nextInt();
        System.out.println(a + " + " + b + " = " + (a+b));
        System.out.println(a + " - " + b + " = " + (a-b));
        System.out.println(a + " x " + b + " = " + (a*b));
        System.out.println(a + " / " + b + " = " + (a/b));
        System.out.println(a + " mod " + b + " = " + (a%b));
    }
}
