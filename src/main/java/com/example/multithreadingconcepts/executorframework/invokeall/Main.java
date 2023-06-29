package com.example.multithreadingconcepts.executorframework.invokeall;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(5);

        List<Task1> list = new ArrayList<>();

        for(int i = 0; i < 5; i++){
            Task1 t = new Task1("Task:"+ i);
            list.add(t);
        }

        List<Future<Result>> resultList = null;
        resultList = executorService.invokeAll(list);

        for(int i = 0; i < 5; i++){
            Future<Result> future =  resultList.get(i);

            try{
                Result result = future.get();
                System.out.println(result.getName() + " : "+ result.getTimeStamp());
            } catch (ExecutionException e) {
                throw new RuntimeException(e);
            }

        }

        executorService.shutdown();




    }
}
