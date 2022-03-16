public class MyThread2 implements Runnable{
    private boolean exit;
 
    private String name;
    Thread t;
 
    MyThread2(String threadname)
    {
        name = threadname;
        t = new Thread(this, name);
        System.out.println("New thread: " + t);
        exit = false;
        t.start(); // Starting the thread
    }
 
    // execution of thread starts from run() method
    public void run()
    {
        int i = 10;
        while (!exit) {
            System.out.println(name + ": " + i);
            i++;
            try {
                Thread.sleep(100);
            }
            catch (InterruptedException e) {
                System.out.println("Caught:" + e);
            }
        }
        System.out.println(name + " Stopped.");
    }
 
    // for stopping the thread
    public void stop()
    {
        exit = true;
    }
}
