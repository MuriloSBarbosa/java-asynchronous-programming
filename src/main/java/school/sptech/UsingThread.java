package school.sptech;

import static school.sptech.Utils.getFactorial;

public class UsingThread {

    public static void main(String[] args) {
        int number = 20;
        // create a new thread for each operation can be expensive,
        // because it requires creating a new thread and managing it.
        // It is better to use a thread pool for this kind of operation
        Thread newThread = new Thread(() -> {
            getFactorial(number);
        });
        newThread.start();

        System.out.println("Thread state: " + newThread.getState());
    }


}