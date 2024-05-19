package com.example.multijunit.multithreading.maxElement.Try3;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class MaxElementSearcherCallable implements Callable<Integer> {
    private final List<Integer> list;
    private final int from;
    private final int to;

    public MaxElementSearcherCallable(int from, int to, List<Integer> list) {
        this.from = from;
        this.to = to;
        this.list = list;
    }

    @Override
    public Integer call() {
        int maxElem = Integer.MIN_VALUE;
        for (int i = from; i <= to; i++) {
            int value = list.get(i);
            if (value > maxElem) {
                maxElem = value;
            }
        }
        return maxElem; // find max
    }
}
