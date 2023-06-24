package com.example.multithreadingconcepts.callable;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CombineCF {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        //Combining the Completable Futures using Compose
        CompletableFuture<Double> result = getUserDetail("123").
                                            thenCompose(user -> getCreditRating("123"));

        System.out.println(result.get());

    }


    public static CompletableFuture<String> getUserDetail(String userId){
        return CompletableFuture.supplyAsync(() -> {
            return "123";
        });
    }

    public static CompletableFuture<Double> getCreditRating(String userId){
        return CompletableFuture.supplyAsync(() ->{
           return 10.4;
        });
    }


}
