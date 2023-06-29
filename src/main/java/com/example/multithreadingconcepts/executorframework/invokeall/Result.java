package com.example.multithreadingconcepts.executorframework.invokeall;

public class Result {

    private String name;
    private String timeStamp;

    public Result(String name, String timeStamp) {
        super();
        this.name = name;
        this.timeStamp = timeStamp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    @Override
    public String toString() {
        return "Result{" +
                "name='" + name + '\'' +
                ", timeStamp='" + timeStamp + '\'' +
                '}';
    }
}
