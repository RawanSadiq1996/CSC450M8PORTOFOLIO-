package com.myproject.concurrency; 

// Define the CountUp class that implements the Runnable interface for the first thread
class CountUp implements Runnable {
    @Override
    public void run() {
        // Count up to 20
        for (int i = 1; i <= 20; i++) {
            System.out.println("Count Up: " + i);
            try {
                Thread.sleep(500); // Adding delay for better visibility
            } catch (InterruptedException e) {
                System.out.println("CountUp thread interrupted.");
            }
        }
    }
}

// Define the CountDown class that implements the Runnable interface for the second thread
class CountDown implements Runnable {
    @Override
    public void run() {
        // Count down from 20 to 0
        for (int i = 20; i >= 0; i--) {
            System.out.println("Count Down: " + i);
            try {
                Thread.sleep(500); // Adding delay for better visibility
            } catch (InterruptedException e) {
                System.out.println("CountDown thread interrupted.");
            }
        }
    }
}

// Main class where thread creation and management happen
public class ConcurrencyCounter {
    public static void main(String[] args) {
        // Create thread objects for counting up and counting down
        Thread thread1 = new Thread(new CountUp());
        Thread thread2 = new Thread(new CountDown());

        // Start the first thread (Count Up)
        thread1.start();

        // Wait for thread1 to finish before starting thread2
        try {
            thread1.join();
        } catch (InterruptedException e) {
            System.out.println("Thread join interrupted.");
        }

        // Start the second thread (Count Down)
        thread2.start();

        // Wait for thread2 to finish
        try {
            thread2.join();
        } catch (InterruptedException e) {
            System.out.println("Thread join interrupted.");
        }

        System.out.println("Both threads have finished execution.");
    }
}
