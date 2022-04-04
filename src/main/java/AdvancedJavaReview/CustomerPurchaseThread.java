package AdvancedJavaReview;

public class CustomerPurchaseThread implements Runnable{
    int waitMillis;
    int amt;
    CustomerAccount account;
    int threadNum;
    public CustomerPurchaseThread(int threadNum, int waitMillis, int amt, CustomerAccount account){
        this.waitMillis = waitMillis;
        this.amt = amt;
        this.account = account;
        this.threadNum = threadNum;
    }
    @Override
    public void run() {
        try {
            System.out.println("Starting thread "+ threadNum+"!");
            Thread.sleep(waitMillis);
            account.purchase(amt);
            System.out.println("Finishing thread "+ threadNum+"!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
