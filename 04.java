import java.util.Scanner;

class Hi{
    public static void main(String[] arg){
        Scanner Obj= new Scanner(System.in);
        System.out.println("Input a binary number : ");
        int Binary=Obj.nextInt();
        long decimal=0;
        long remainder,j=1;
        while(Binary!=0){
            remainder=Binary%10;
            decimal=decimal+remainder*j;     
            j=j*2;
            Binary=Binary/10;
        }
        System.out.println(decimal);
    }
}
