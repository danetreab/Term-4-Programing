import java.lang.Math;
class ex10 {
    public static void main(String[] args) {
        int a[]=new int[10];
        for(int i=0;i<10;i++){
            a[i]=(int)(Math.random()*10);
        }
        printAll(a);
    }
    public static double find_Avg(int[] numbers){
        int avg=0;
        for(int i=0;i<10;i++){
            avg += numbers[i];
        }
        return (double)avg/numbers.length;
    }
    public static int find_max(int[] numbers){
        int Max=-99;
        for(int i=0;i<numbers.length;i++){
            if(numbers[i]>Max){
                Max=numbers[i];
            }
        }
        return Max;
    }
    public static void printAll(int[] numbers){
    System.out.print("The Array of number is : ");
        for(int i=0;i<numbers.length;i++){
            System.out.print(numbers[i]+ " ");
        }
        System.out.println("\nThe Avg is "+find_Avg(numbers));
        System.out.println("The Max value is "+find_max(numbers));
    }
}

