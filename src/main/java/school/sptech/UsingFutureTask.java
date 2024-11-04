package school.sptech;

import static school.sptech.Utils.createServer;
import static school.sptech.Utils.getFactorial;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class UsingFutureTask {

    public static void main(String[] args) {
        createServer();
        // ExecutorService is a more advanced version of Thread
        // It allows you to create a pool of threads and manage them.
        // We can use:
        // newCachedThreadPool() - creates a thread pool that creates new threads as needed,
        // but will reuse previously constructed threads when they are available
        // newFixedThreadPool(int nThreads) - creates a thread pool that reuses a fixed number of threads
        // newSingleThreadExecutor() - creates a single-threaded executor that uses a single worker
        // thread operating off an unbounded queue
        ExecutorService threadpool = Executors.newCachedThreadPool();

        // Calling submit() returns a Future object that represents the result of the computation
        Future<Integer> futureTask = threadpool.submit(() -> getFactorial(20));

        System.out.println("Running async tasks..");

        threadpool.shutdown();
    }
}
