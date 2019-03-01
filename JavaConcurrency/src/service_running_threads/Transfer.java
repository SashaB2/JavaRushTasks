package service_running_threads;


import java.util.Random;
import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class Transfer implements Callable{

    private Account account1;
    private Account account2;
    private int amount;

    public Transfer(Account account1, Account account2, int amount) {
        this.account1 = account1;
        this.account2 = account2;
        this.amount = amount;
    }

    @Override
    public Object call() throws Exception {
        if(account1.getLock().tryLock(1, TimeUnit.SECONDS)){
            try{
                if(account1.getBalance() < amount){
                    throw new InsufficientFundsException();
                }
                if(account2.getLock().tryLock(1, TimeUnit.SECONDS)){
                    try {
                        account1.withdraw(amount);
                        Thread.sleep(new Random().nextInt(3000 ));
                        account2.deposit(amount);
                        System.out.println("a1: " + account1.getBalance() +" | " + "ac2: " + account2.getBalance());
                    }finally {
                        account2.getLock().unlock();
                    }
                }else{
                    account2.incFailedTransferCount();
                    System.out.println("Error waiting lock");
                }
            }finally {
                account1.getLock().unlock();
            }
            return true;
        }else{
            account1.incFailedTransferCount();
            System.out.println("Error waiting lock");
            return false;
        }

    }
}
