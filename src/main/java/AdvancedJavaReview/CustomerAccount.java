package AdvancedJavaReview;

public class CustomerAccount {
    int customerID;
    int balance;
    String username;
    String address;
    public CustomerAccount(int customerID, int initAmt){
        this.balance = initAmt;
        this.customerID = customerID;
    }
    public boolean purchase(int amt) throws InterruptedException {
        int tempBalance = balance;
        int oldBalance = tempBalance;

        if(balance<amt){
            System.out.println("Customer had insufficient funds to purchase item cost "+ amt
            + " using balanace "+ balance);
            return false;
//          the customer didn't have enough funds
        }

        Thread.sleep((int) Math.random()*100);
        tempBalance = tempBalance - amt;

//        balance = tempBalance;
        changeBalance(-1*amt);
        System.out.println("Customer "+ customerID +" purchased for "+ amt + "" +
                "from balance of "+oldBalance+", balance is now " +
                tempBalance);
        return true;

    }
    private synchronized void changeBalance(int amt){
        balance = balance + amt;
    }
    public void deposit(int amt){
        changeBalance(amt);
    }
    public void changePassword(){

    }
    public void applyForCreditCard(){

    }
    public void getCart(){

    }
    public int getBalance(){
        return balance;
    }
    public int getCustomerID(){
        return customerID;
    }
}
