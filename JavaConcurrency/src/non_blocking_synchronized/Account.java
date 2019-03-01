package non_blocking_synchronized;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Account {
    private AtomicInteger failCounter;
    private int balance;
    private Lock lock;


    public Account(int balance) {
        this.balance = balance;
        lock = new ReentrantLock();
    }


    public void incFailedTransferCount(){
        failCounter.incrementAndGet();
    }

    public void withdraw(int amount){
        balance =- amount;
    }

    public void deposit(int amount){
        balance += amount;
    }

    public int getBalance() {
        return balance;
    }

    public AtomicInteger getFailCounter() {
        return failCounter;
    }

    public Lock getLock() {
        return lock;
    }
}
