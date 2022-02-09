import java.util.Scanner;

class ex3 {
    public static void main(String[] args) {
        Scanner Obj = new Scanner(System.in);
        System.out.println("Enter your age : ");
        int a = Obj.nextInt();
        if(a<0){
            System.out.println("The age cannot be less than 0");
        }else{
            System.out.println("Your age is "+ a);
        }
    }   
}
