import java.util.Scanner;

class ex13 {
    public static void main(String[] args) {
        String name[] = new String[15];
        Scanner Obj = new Scanner(System.in);
        System.out.println("Enter Name : ");
        //get name
        for(int i=0;i<15;i++){
            name[i] = Obj.nextLine();
        }
        //Print Student
        for(int i=0;i<15;i++){
            System.out.println(name[i]);
        }
    }    
}

