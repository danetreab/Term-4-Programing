import java.util.Scanner;

class ex4 {
    public static void main(String[] args) {
    Scanner Obj = new Scanner(System.in);
    System.out.println("Enter Score : ");
    int Score = Obj.nextInt();
    if(Score>=95 || Score<=100){
        System.out.println("A");
    }else if(Score>=80 || Score <=94){
        System.out.println("B");
    }else if(Score>=74 || Score <=79){
        System.out.println("C");
    }else if(Score>=55 || Score<=73){
        System.out.println("D");
    }else{
        System.out.println("F");
    }
    }
}
