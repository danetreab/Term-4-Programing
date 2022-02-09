import java.util.Scanner;

class Lab1_ex9 {
    public static void main(String[] args) {
        Scanner Obj=new Scanner(System.in);
        System.out.print("Input your name : ");
        String a=Obj.nextLine();
        System.out.print("Input your age : ");
        // String b=Obj.nextLine();
        int b = Integer.parseInt(Obj.nextLine());
        System.out.print("Input your address : ");
        String c=Obj.nextLine();


        System.out.println("Your name : "+a);
        System.out.println("Your age : "+b);
        System.out.println("Your address : "+c);
    }
}
