package com.example.multithreadingconcepts.completablefuture;

import java.util.concurrent.*;
import java.util.function.Supplier;

public class Main {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        /*
            Run a task specified by a Runnable Object asynchronously.
            runAsync

         */
//        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
//
//            //Simulate long running job
//            try{
//                Thread.sleep(5000);
//                System.out.println("In run async method");
//            } catch (Exception e) {
//                throw new RuntimeException(e);
//            }
//        });
//        future.get();


        /*
            Example of SuppyAsync()
         */

//        CompletableFuture<String> future = CompletableFuture.supplyAsync(new Supplier<String>() {
//            @Override
//            public String get() {
//                try{
//                    TimeUnit.SECONDS.sleep(1);
//                } catch (Exception e) {
//                    throw new RuntimeException(e);
//                }
//                return "Result of the asynchronous computation";
//            }
//        });
//
//        String result = future.get();
//        System.out.println(result);


        /*
            Using supply Async along with the executor
         */

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        CompletableFuture<String> future = CompletableFuture.supplyAsync(new Supplier<String>() {
            @Override
            public String get() {
                try{
                    TimeUnit.SECONDS.sleep(1);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                return "Result of the asynchronous computation";
            }
        }, executorService);

        String result = future.get();
        System.out.println(result);
        executorService.shutdown();




    }
}
