package com.example.multithreadingconcepts.executorframework.invokeall;

import com.example.multithreadingconcepts.callable.CallableTest;

import java.time.LocalDateTime;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class Task1 implements Callable<Result> {

    private String name;

    public Task1(String name) {
        this.name = name;
    }

    @Override
    public Result call() throws Exception {

        System.out.println("Starting "+ this.name);

        try{
            long duration = (long) (Math.random() * 10);
            System.out.printf("%s: Waiting %d seconds for results.\n", this.name, duration);
            TimeUnit.SECONDS.sleep(duration);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        return new Result(this.name, LocalDateTime.now().toString());
    }
}
