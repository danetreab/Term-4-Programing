package app;
public class search implements Runnable {
	private int startIndex, endIndex;
	private static int nElements=10001, key, myArray [];
	private boolean flag;
	private String threadName;
    @Override
    public void run() {
        for(int i = startIndex; i<=endIndex; i++) {
			if(key == myArray[i]) {
				System.out.println("Search is successful by " + threadName+"\nThe number is "+ key+ "\ngood bye!");
				flag = true;
				return;
			}
		}
		if(flag == false) {
			System.out.println("Search is unsuccessful by " + threadName);
		}
    }
	public search(){

	}
    public search(int startIndex, int endIndex, String threadName) {
		this.startIndex = startIndex;
		this.endIndex = endIndex;
		this.threadName = threadName;
		Thread thread = new Thread(this);
		thread.start();
	}
    public static void setValue(){
        myArray = new int[nElements];
        for(int i=0,t=1;i<nElements;i++,t++){
            myArray[i]=t;
        }
        key = (int)((Math.random()*(10000-1+1))+1);
    }
}
