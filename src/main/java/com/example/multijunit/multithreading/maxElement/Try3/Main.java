package com.example.multijunit.multithreading.maxElement.Try3;


import com.example.multijunit.timer.Timer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;


public class Main {
    public static void main(String[] args) throws InterruptedException, ExecutionException {

        Timer timer = new Timer();

        List<Integer> list = new ArrayList<>();

        for(int i = 0; i < 30000; i++) {
            list.add(i);
        }

        ListSearcher listSearcher = new ListSearcher(24);

        timer.start();
        int max = listSearcher.getMax(list);

        timer.stop();

        System.out.println(max);

        System.out.println("multy: " + timer.getTime());

        Timer timer2 = new Timer();
        timer2.start();
        int max2 = listSearcher.getMaxSingleThread(list);
        timer2.stop();

        System.out.println("single: " + timer2.getTime());

        listSearcher.shutdown();
    }
}
