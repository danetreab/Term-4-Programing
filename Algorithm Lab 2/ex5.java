import java.util.Scanner;

class ex5 {
    public static void main(String[] args) {
        Scanner Obj = new Scanner(System.in);
        System.out.println("Enter name : ");
        String a=Obj.nextLine();
        System.out.println("Enter gender : ");
        String b=Obj.nextLine();
        if(b.equals("F") || b.equals("f") || b.equals("Female")){
            System.out.println("Hello Miss, "+a);
        }else if(b.equals("M") || b.equals("m") || b.equals("Male")){
            System.out.println("Hello Ms, "+a);
        }else{
            System.out.println("Hello Mr, "+a);
        }
    }
}
