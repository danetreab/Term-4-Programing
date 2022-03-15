public class countUp implements Runnable {
    public void run(){
        for(int i=1;i<=50;i++){
            System.out.println(i);
            try {
                Thread.sleep(100);
            } catch (Exception e) {
                //TODO: handle exception
            }
        }
    }
}
