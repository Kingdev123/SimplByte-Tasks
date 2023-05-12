package simplebyteIntershipTasks.Task2;
import java.util.Date;

public class Transaction_data {
    private double amount ;
    private Date timestamp ;
    private String memo ;
    private Account_data inAccount ;

    public Transaction_data(double amount , Account_data inAccount){
        this.amount = amount ;
        this.inAccount = inAccount ;
        this.timestamp = new Date();
        this.memo = "";
    }
    public Transaction_data(double amount, String memo, Account_data inAccount) {

        this(amount, inAccount);
        this.memo = memo;

    }

    public double getMoney(){
        return this.amount;
    }
    public void transactionInfo(){
        System.out.println(this.amount + " " +this.inAccount +  " " + this.memo + " "+ this.timestamp);
    }
}
