public class main {
    public static void main(String[] args) {
        CountDown down = new CountDown();
        Runnable up = new countUp();
        Thread t = new Thread(up);
        down.start();
        t.start();
    }
}
