import java.util.Scanner;

class ex9 {
    public static void main(String[] args) {
        int a[]= new int[5];
        Scanner Obj =new Scanner(System.in);
        System.out.println("Enter the number : ");
        for(int i=0;i<5;i++){
            a[i] = Obj.nextInt();
        }
        System.out.println("Printed Number : ");
        for(int i=0;i<5;i++){
            System.out.println(a[i]);
        }
    }    
}
