public class CountDown extends Thread{
    public void run(){
        for(int i=1000;i>=0;i--){
            System.out.println(i);
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                //TODO: handle exception
            }
        }
    }
}
