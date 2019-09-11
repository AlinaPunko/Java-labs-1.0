package task2;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Client extends Thread {
    private String name;
    private Restaurant restaurant;
    private Semaphore semaphore;

    public Client(Restaurant pCallCenter, Semaphore pSemaphore, int pName) {
        this.name = String.valueOf(pName);
        this.semaphore = pSemaphore;
        this.restaurant = pCallCenter;
    }

    public String getClientName() {
        return this.name;
    }

    @Override
    public void run() {
        Random rand = new Random();
        int waitingTime = rand.nextInt(600) + 100;
        System.out.println("Client " + this.getName() + " entered the restaurant");
        boolean key  = false;
        while(!key) {
            try {
                if (semaphore.tryAcquire(waitingTime, TimeUnit.MICROSECONDS)) {
                    System.out.println("Client " + this.getClientName() + " is eating");
                    restaurant.sit(this);
                    restaurant.showTables();
                    Thread.sleep(rand.nextInt(3000) + 500);
                    restaurant.endedeating(this);
                    semaphore.release();
                    System.out.println("Client " + this.getClientName() + " left restaurant");
                    key = true;
                } else {
                    System.out.println("Client " + this.getClientName() + " is waiting");
                    Thread.sleep(5000);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
