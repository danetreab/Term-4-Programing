import java.util.Scanner;

class ex1 {
    public static void main(String[] args) {
        Scanner Obj = new Scanner(System.in);
        System.out.print("Enter the number : ");
        int a = Obj.nextInt();
        if(a<0){
            System.out.println("The number you have enter is negative");
        }else{
            System.out.println("The number you have enter is positive");
        }
    }
}

