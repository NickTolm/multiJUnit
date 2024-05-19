package com.example.multijunit.multithreading.maxElement.Try3;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ListSearcher {
    private final ExecutorService executorService;
    private final int threadsCount;

    public ListSearcher(int threadsCount) {
        this.threadsCount = threadsCount;
        executorService = Executors.newFixedThreadPool(threadsCount);
    }

    public int getMaxSingleThread(List<Integer> list) {
        int max = Integer.MIN_VALUE;
        for(Integer element : list) {
            if (element > max) {
                max = element;
            }
        }
        return max;
    }

    public int getMax(List<Integer> list) throws ExecutionException, InterruptedException {
        List<Future<Integer>> futures = runThreads(list);
        int max = Integer.MIN_VALUE;
        for (Future<Integer> future : futures) {
            int value = future.get();
            if (max < value) {
                max = value;
            }
        }
        return max;
    }

    private List<Future<Integer>> runThreads(List<Integer> list) {
        List<Future<Integer>> futures = new ArrayList<>();
        int countOfElements = Math.ceilDiv(list.size(), threadsCount);
        int start = 0;
        int end = countOfElements - 1;
        for (int threads = 0; threads < threadsCount; threads++) {
            futures.add(executorService.submit(new MaxElementSearcherCallable(start, end, list)));
            start += countOfElements;
            end += countOfElements;
            if(end >= list.size()) {
                end = list.size() - 1;
            }
        }
        executorService.shutdown();
        return futures;
    }
    public void shutdown() {
        executorService.shutdown();
    }
}