package non_blocking_synchronized;
import java.util.concurrent.TimeUnit;

public class Operations {
    public static void main(String[] args) throws InsufficientFundsException, InterruptedException {
        final Account a = new Account(1000);
        final Account b = new Account(2000);

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    transfer(a, b, 500);
                } catch (InsufficientFundsException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        transfer(b, a, 300);
    }

    static void transfer(Account acc1, Account acc2, int amount) throws InsufficientFundsException, InterruptedException {
        if(acc1.getBalance() < amount){
            throw new InsufficientFundsException();
        }

        if(acc1.getLock().tryLock(1, TimeUnit.SECONDS)){
            try{
                if(acc2.getLock().tryLock(1, TimeUnit.SECONDS)){
                    try {
                        acc1.withdraw(amount);
                        acc2.deposit(amount);
                    }finally {
                        acc2.getLock().unlock();
                    }
                }else{
                    acc2.incFailedTransferCount();
                    System.out.println("Error waiting lock");
                }
            }finally {
                acc1.getLock().unlock();
            }
        }else{
            acc1.incFailedTransferCount();
            System.out.println("Error waiting lock");
        }

    }
}

class InsufficientFundsException extends Exception{

}
