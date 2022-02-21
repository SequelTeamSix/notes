package threading;

import java.util.concurrent.Callable;

public class ThreadImplementCallable implements Callable<Integer> {
    int threadNum;
    int timeMillis;

    public ThreadImplementCallable(int threadNum, int timeMillis) {
        this.threadNum = threadNum;
        this.timeMillis = timeMillis;
    }


    @Override
    public Integer call() throws Exception {
        Thread.sleep(timeMillis);
        return threadNum;
    }
}
