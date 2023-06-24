package com.example.multithreadingconcepts.callable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;

public class CallableMain {

    public static void main(String[] args) throws Exception {

        ExecutorService executor = Executors.newFixedThreadPool(10);

        List<Future<String>> list = new ArrayList<Future<String>>();
        Callable<String> callTest = new CallableTest();

        //Here, we are not blocking the task, results will be retrieved in the future
        for(int i = 0; i < 10; i++){
            Future<String> ftr = executor.submit(callTest);
            list.add(ftr);
        }
        // If we want to block the task, we can use get method
        for(int i = 0; i < 10; i++){
            String str = executor.submit(callTest).get();
            System.out.println(str);
        }


        for(Future<String> l: list){
            try{
                System.out.println(new Date() + ": "+ l.get());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (ExecutionException e) {
                throw new RuntimeException(e);
            }
        }


        executor.shutdown();


    }
}
