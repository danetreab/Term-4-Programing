public class main {
    public static void main(String[] args) throws InterruptedException{
        CountDown c = new CountDown();
        countUp c2 = new countUp();
        Thread t = new Thread(c2);
        c.start();
        t.start();
        int max=100000;
        int slept=0;
        while(slept<max){
            Thread.sleep(300);
            slept+=300;
            if(!c.isAlive() || !t.isAlive()){
                System.exit(0);
            }
        }
        if(c.isAlive()){
            c.setShouldexit(true);
            c.join();
        }
        System.exit(0);
    }
}
