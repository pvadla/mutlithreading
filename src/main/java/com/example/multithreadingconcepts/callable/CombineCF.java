package com.example.multithreadingconcepts.callable;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class CombineCF {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        //Combining the Completable Futures using Compose
        CompletableFuture<Double> result = getUserDetail("123").
                                            thenCompose(user -> getCreditRating("123"));
        System.out.println(result.get());


        //Using thenCombine() method to combine two independent futures
        System.out.println(combinedFuture());



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

    public static CompletableFuture<Double> retrieveWeight(){
        System.out.println("Retrieving Weight: ");
       return CompletableFuture.supplyAsync(() -> {
           try{
               TimeUnit.SECONDS.sleep(1);
           } catch (InterruptedException e) {
               throw new RuntimeException(e);
           }

           return 65.0;
        });
    }

    public static CompletableFuture<Double> retrieveHeight(){
        System.out.println("Retrieving Height: ");
        return CompletableFuture.supplyAsync(() -> {
            try{
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            return 177.8;
        });
    }

    public static Double combinedFuture() throws ExecutionException, InterruptedException {
        System.out.println("Calculating BMI");
        CompletableFuture<Double> combinedFuture = retrieveWeight().thenCombine(retrieveHeight(), (weightInKg, heightInCm) -> {

            Double heightInMeter = heightInCm/100;
            return weightInKg / (heightInMeter*heightInMeter);
        });

        //System.out.println("Your BMI is - " + combinedFuture.get());
        return combinedFuture.get();
    }


}
