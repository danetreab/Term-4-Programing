import java.util.*; 
class Helloworld{
    public static void main(String[] arg){
        Scanner Obj = new Scanner(System.in);
        System.out.print("Input first number : ");
        int a=Obj.nextInt();
        System.out.print("Input second number : ");
        int b=Obj.nextInt();
        System.out.println(a + "x" + b + "=" + a*b);
    }
}