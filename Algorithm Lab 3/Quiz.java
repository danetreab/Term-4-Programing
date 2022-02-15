import java.lang.Math;
import java.util.Scanner;

//Reab Danet
class Quiz {
    public static void main(String[] args) {
        // int random_int = (int)Math.floor(Math.random()*(150-20+1)+20);
        Scanner Obj=new Scanner(System.in);
        int numbers[] = new int[20];
        for(int i=0;i<numbers.length;i++){
            numbers[i]=(int)Math.floor(Math.random()*(150-20+1)+20);
        }

        // do{
        //     System.out.println("0. Exit");
        //     System.out.println("1. Print All");
        //     System.out.println("2. Find");
        //     System.out.println("3. Find Max");
        //     System.out.println("4. Sum Element");
        //     System.out.println("5. Find Avg");
        //     System.out.print("Enter the number : ");
        //     int t=Obj.nextInt();
        //     if(t>=0 || t<=5);
        // }while(t!=0);
        printAll(numbers);
        space(2);
        System.out.println(find(numbers, 5));
        space(2);
        System.out.println(findMax(numbers));
        space(2);
        System.out.println(sumElement(numbers));
        space(2);
        System.out.println(findAvg(numbers));

    }
    public static void space(int n) {
        for(int i=0;i<n;i++){
            System.out.println();
        }
    }
    public static void printAll(int[] numbers) {
        for(int i=0;i<numbers.length;i++)
        System.out.println(numbers[i]);
    }
    public static int find(int[]numbers, int key) {
        for(int i=0;i<numbers.length;i++){
            if(numbers[i]==key){
                return i;
            }
        }
        return 0;
    }
    public static int findMax(int[] numbers) {
        int Max=-99;
        for(int i=0;i<numbers.length;i++){
            if(numbers[i]>Max){
                Max=numbers[i];
            }
        }
        return Max;
    }
    public static int sumElement(int[] numbers) {
        int total=0;
        for(int i=0;i<numbers.length;i++){
            total += numbers[i];
        }
        return total;
    }
    public static int findAvg(int[] numbers) {
        return sumElement(numbers)/numbers.length;
    }
}
