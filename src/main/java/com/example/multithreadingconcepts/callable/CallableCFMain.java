package com.example.multithreadingconcepts.callable;


/*
    1. Examples of Completable Future using supplyAsync with Supplier
 */
import java.util.concurrent.*;
import java.util.function.Supplier;

public class CallableCFMain {

    public static void main(String[] args) throws ExecutionException, InterruptedException {


        ExecutorService executorService = Executors.newFixedThreadPool(5);

        for(int i = 0; i < 10; i++){
            callCF(executorService);
            //executorService.shutdown();
        }


        for(int i = 0; i < 10; i++){
            callCFSupplier(executorService);
        }

        executorService.shutdown();





    }


    public static void callCF(ExecutorService executorService) throws ExecutionException, InterruptedException {
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> {

            try{
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }


            return Thread.currentThread().getName();
        }, executorService);


        System.out.println(completableFuture.get());

    }

    public static void callCFSupplier(ExecutorService executorService) throws ExecutionException, InterruptedException {
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(new SupplierTest());

        //Block and get result of future
        System.out.println(completableFuture.get());
        executorService.shutdown();
    }
}
