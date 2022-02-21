package threading;

public class BankAccount {

    int balance;

    public BankAccount(int balance) {
        this.balance = balance;
    }

    public void deposit(int amt){
        balance = balance + amt;
    }

    public int getBalance(){
        return balance;
    }


}
