package threading;

public class ThreadImplementRunnable implements Runnable{
    int threadNum;
    int timeMillis;
    public ThreadImplementRunnable(int threadNum, int timeMillis){
        this.threadNum=threadNum;
        this.timeMillis = timeMillis;
    }
    public void run(){
        try {
            //thread.sleep just makes the thread wait (blocked)
            Thread.sleep(timeMillis);
            System.out.println("Hello from thread"+ threadNum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return;

    }


}
