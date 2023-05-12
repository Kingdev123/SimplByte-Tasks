package simplebyteIntershipTasks.Task2;


import java.util.ArrayList;

public class Account_data {
    private String name ;
    private String uuid ;
    private User_data holder ;
    private ArrayList<Transaction_data> transactions ;

    public Account_data(String name , User_data holder, Bank_data theBank){
        this.name = name ;
        this.holder = holder ;
        this.uuid = theBank.getNewAccountUUID ();
        this.transactions = new ArrayList<Transaction_data> ();
    }

    public String getUUID() {
        return uuid;
    }

    public String  getSummaryLine(){
        double balance = this.getBalance();

        if (balance >= 0) {
            return String.format("%s : %.02f ₹ : %s", this.uuid, balance,
                    this.name);
        } else {
            return String.format("%s : (%.02f) ₹ : %s", this.uuid, balance,
                    this.name);
        }
    }

    public double getBalance(){
        double balance = 0;
        for (Transaction_data t :this.transactions){
            balance += t.getMoney();
        }
        return balance ;
    }
    public void addTransaction(double amount, String memo) {

        // create new transaction and add it to our list
        Transaction_data newTrans = new Transaction_data(amount, memo, this);
        this.transactions.add(newTrans);

    }

    public void showTransactions(){
        for (Transaction_data t : transactions){
            t.transactionInfo();
        }
    }
}
