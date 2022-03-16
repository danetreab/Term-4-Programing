public class CountDown extends Thread{
    private boolean shouldexit=false;
    public void setShouldexit(boolean shouldexit) {
        this.shouldexit = shouldexit;
    }
    public void run(){
        for(int i=1000;i>=0;i--){
            if(shouldexit){
                break;
            }
            System.out.println(i);
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                //TODO: handle exception
            }
        }
    }
}
