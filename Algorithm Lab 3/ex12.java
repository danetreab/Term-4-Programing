import java.util.Scanner;
import java.lang.Math;
class ex12 {
    public static void main(String[] args) {
        Scanner Obj = new Scanner(System.in);
        System.out.println("Row Column: ");
        int row = Obj.nextInt();
        int column = Obj.nextInt();
        int a[][]= new int[row][column];
        for(int i=0;i<row;i++){
            for(int j=0;j<column;j++){
                a[i][j]=(int)(Math.random()*10);
            }
        }
        for(int i=0;i<row;i++){
            for(int j=0;j<column;j++){
                System.out.print(a[i][j]+ " ");
            }
            System.out.println();
        }
    }    
}


