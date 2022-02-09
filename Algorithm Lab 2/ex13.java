public class ex13 {
    public static void main(String[] args) {
        System.out.println(sum(7.3, 6));
        System.out.println(sum(7.3, 6));
        System.out.println(sum(7, 6.3));
        System.out.println(sum(7.3, 6,9.3));
    }
    public static double sum(double x,int y){
        return x+y;
    }
    public static double sum(double x,double y){
        return x+y;
    }
    public static double sum(int x,double y){
        return x+y;
    }
    public static double sum(double x,double y,double z){
        return x+y+z;
    }
}
