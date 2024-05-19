package com.example.multijunit.multithreading.maxElement.Try3;


import com.example.multijunit.timer.Timer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutionException;

import static java.lang.Math.ceil;
import static java.lang.Math.floor;

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

//        List<Integer> list = new ArrayList<>();
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Введите список чисел через пробел");
//        String str = scanner.nextLine();
//        for (String s : str.split("\\s")) {
//            list.add(Integer.parseInt(s));
//        }
//
//        System.out.println("Введите количество потоков");
//        int threadCount = scanner.nextInt();
//        List<Integer> list = new ArrayList<>();
//        int threadCount = 10;
    }
}
