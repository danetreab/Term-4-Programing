import java.lang.Math;
import java.util.Scanner;
class ex6 {
    public static void main(String[] args) {
        Scanner Obj=new Scanner(System.in);
        int input;
        int ran_num = (int)(Math.random()*10);
        do{
            System.out.print("Quest a number : ");
            input = Obj.nextInt();
            if(input<ran_num){
                System.out.println("The number is bigger than "+input);
            }else if(input>ran_num){
                System.out.println("The numer is smaller than "+input);
            }else{
                System.out.println("Congrat! You are correct the number is "+input);
            }
        }while(ran_num!=input);
    }    
}


