public class countUp implements Runnable {
    private boolean shouldexit=false;
    public void setShouldexit(boolean shouldexit) {
        this.shouldexit = shouldexit;
    }
    public void run(){
        for(int i=1;i<=50;i++){
            if(shouldexit){
                break;
            }
            System.out.println(i);
            try {
                Thread.sleep(2000);
            } catch (Exception e) {
                //TODO: handle exception
            }
        }
    }
}
