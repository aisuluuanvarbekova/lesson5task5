package com.company;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class Main {

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(4, true);
        CountDownLatch countDownLatch = new CountDownLatch(100);
        for (int i = 1; i <= 100; i++) {
            new Passenger(semaphore, countDownLatch, i).start();

        }
        try {
            while ((countDownLatch.getCount() <= 1)) ;
            Thread.sleep(100);

            Thread.sleep(1000);
            System.out.println(" Начинаем обратный отсчет с (5)");

            countDownLatch.countDown();
            Thread.sleep(1000);
            System.out.println(" 5 ");

            countDownLatch.countDown();
            Thread.sleep(1000);
            System.out.println(" 4 ");

            countDownLatch.countDown();
            Thread.sleep(1000);
            System.out.println(" 3 ");

            countDownLatch.countDown();
            Thread.sleep(1000);
            System.out.println(" 2 ");

            countDownLatch.countDown();
            Thread.sleep(1000);
            System.out.println(" 1 ");
            countDownLatch.countDown();

            countDownLatch.await();
            Thread.sleep(1000);
            System.out.println(" Автобус полный");
            Thread.sleep(2000);
            System.out.println(" Направляемся в город Ош");
            Thread.sleep(2000);
            System.out.println(" Держим Путь!!! ");
            countDownLatch.countDown();


        } catch (InterruptedException e) {
        }
    }
}




