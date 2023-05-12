package simplebyteIntershipTasks.Task2;
import java.util.ArrayList;
import java.util.Random;

public class Bank_data {
    private String name ;
    private ArrayList<User_data> users ;
    private ArrayList<Account_data> accounts ;

    public Bank_data(String name ){
        this.name = name ;
        accounts = new ArrayList<Account_data>();
        users = new ArrayList<User_data> ();
    }


    public void addAccount(Account_data acc){
        this.accounts.add(acc);
    }

    public String getNewUserUUID(){
        Random rng = new Random();
        boolean nonUnique  ;
        String uuid  ;
        int len = 6 ;


        do {
            uuid = "" ;
            for (int c = 0 ; c<len ; c++){
                uuid +=( (Integer)rng.nextInt(10)).toString() ;

            }
            nonUnique = false ;
            for (User_data u : this.users){
                if (uuid.compareTo(u.getUUID()) == 0){
                    nonUnique = true ;
                    break ;
                }
            }

        }while (nonUnique);
        return uuid ;
    }
    public String getNewAccountUUID(){
        Random rng = new Random();
        boolean nonUnique  ;
        String uuid  ;
        int len = 10 ;


        do {
            uuid = "" ;
            for (int c = 0 ; c<len ; c++){
                uuid +=( (Integer)rng.nextInt(10)).toString() ;

            }
            nonUnique = false ;
            for (Account_data a : this.accounts){
                if (uuid.compareTo(a.getUUID()) == 0){
                    nonUnique = true ;
                    break ;
                }
            }

        }while (nonUnique);
        return uuid ;

    }

    public User_data addUser(String firstName , String lastName , String pin){
        User_data newUser = new User_data( firstName ,  lastName ,  pin , this);
        this.users.add(newUser);

        Account_data newAccount = new Account_data("savings" , newUser , this);
        this.accounts.add(newAccount);
        newUser.addAccount(newAccount);
        return newUser;



    }
    public User_data userLogin (String userID , String pin){
        for (User_data u :this.users){
            if (u.getUUID().compareTo(userID) ==0 &&u.validatePin(pin) )
                return u ;



        }

        return null ;
    }
    public String getName(){
        return this.name;
    }

}
