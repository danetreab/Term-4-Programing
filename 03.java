import java.util.Scanner;

class Yes {
    public static void main(String[] args) {
        Scanner Obj = new Scanner(System.in);
        System.out.print("Input a number : ");
        int a=Obj.nextInt();
        for(int i=1;i<=10;i++){
            System.out.println(a + " x " + i + " = " + (a*i));
        }
    }
}
