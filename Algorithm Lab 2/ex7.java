public class ex7 {
    
    public static void main(String[] args) {
        int a=1,b=2;
        System.out.println(add(a,b));
        System.out.println(minus(a,b));
        System.out.println(div(a,b));
        System.out.println(multi(a,b));
        System.out.println(mod(a,b));
    }
    public static int add(int x,int y){
        return x+y;
    }
    public static int minus(int x,int y){
        return x-y;
    }
    public static int div(int x,int y){
        return x/y;
    }
    public static int multi(int x,int y){
        return x*y;
    }
    public static int mod(int x,int y){
        return x%y;
    }
}
