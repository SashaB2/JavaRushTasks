package service_running_threads;

import java.util.Random;
import java.util.concurrent.*;

public class OperationTwo {

    public static void main(String[] args) throws InterruptedException {
        Account account1 = new Account(1000);
        Account account2 = new Account(2000);

        ScheduledExecutorService amountMonitoring = createSuccessMonitoringThread(account1);

        ExecutorService executorService =
                Executors.newFixedThreadPool(3);


        for (int i = 0; i < 10; i++) {
                        executorService.submit(
                                new Transfer(account1,
                                        account2,
                                        52)
                        );
        }

        executorService.shutdown();
        executorService.awaitTermination(10, TimeUnit.SECONDS);
        amountMonitoring.shutdown();
    }

    private static ScheduledExecutorService createSuccessMonitoringThread(
            final Account acc1){
        ScheduledExecutorService amountMonitoring =
                Executors.newScheduledThreadPool(1);
        amountMonitoring.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println("Failed transfers in Account 1: " +
                 acc1.getFailCounter());
            }
        }, 2, 3, TimeUnit.SECONDS);
        return amountMonitoring;
    }
}
