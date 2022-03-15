public class main {
    public static void main(String[] args) {
        CountDown c = new CountDown();
        countUp c2 = new countUp();
        Thread t = new Thread(c2);
        c.start();
        // System.out.println(c.isAlive());
        t.start();
        if(c.isAlive() == false){
            System.out.println("hello");
        }else if(t.isAlive()==false){
            System.out.println("hello");
        }
    }
}
