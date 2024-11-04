package school.sptech;

import static school.sptech.Utils.createServer;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class UsingCompletableFuture {

    public static void main(String[] args) {

        createServer();

        // CompletableFuture is a class that represents a future result of an asynchronous computation
        // It is an advanced version of FutureTask, because it allows you to chain multiple tasks

        // supplyAsync() => run and return a result
        // runAsync() => run and return void
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(
              () -> Utils.getFactorial(20));

        CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(
              () -> Utils.getFactorial(30));

        // thenAccept() => run a task after the computation is completed and no result is returned
        // thenApply() => run a task after the computation is completed and return a result
        CompletableFuture.allOf(future, future2)
              .thenAccept((v) -> {
                  System.out.println("All tasks completed");
              });

        List<Integer> numbers = List.of(10, 20, 30, 40, 50);

        var futures = numbers.stream()
              .map(number -> CompletableFuture.supplyAsync(() -> Utils.getFactorial(number)))
              .toArray(CompletableFuture[]::new);

        System.out.println("Running async tasks..");

        // join() x get()
        // join() is similar to get(), but it throws an unchecked exception in case the computation
        // throws an exception. get() throws a checked exception.
        // Both methods block the current thread until the result is available

        // allOf() => wait for all tasks to complete
        CompletableFuture.allOf(futures).join();
        System.out.println("Tasks completed!");
    }


}
