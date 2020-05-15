package com.company;


import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class Passenger extends Thread {
    Semaphore semaphore;
    CountDownLatch countDownLatch;
    int person;

    public Passenger(Semaphore semaphore, CountDownLatch countDownLatch, int person) {
        this.semaphore = semaphore;
        this.countDownLatch = countDownLatch;
        this.person = person;
    }

    public Passenger(CountDownLatch countDownLatch, int i, int person) {

    }

    @Override
    public synchronized void run() {
        try {
            semaphore.acquire();
            System.out.println("______________________________________________");
            System.out.println(" Пассажир " + person + " Стоит у окна кассы ");
            System.out.println("______________________________________________");

            sleep(200);

            System.out.println(" Пассажир " + person + " уходит от окна  кассы");
            System.out.println("_____________________________________________");

            semaphore.release();
            sleep(200);
            System.out.println(" Пассажир " + person + " Занимает место в автобусе ");


            countDownLatch.countDown();

        } catch (InterruptedException e) {
        }
    }


}











