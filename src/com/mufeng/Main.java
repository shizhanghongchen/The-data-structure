package com.mufeng;

import com.mufeng.queues.ArrayQueues;

public class Main {

    public static void main(String[] args) {
        ArrayQueues<Integer> queues = new ArrayQueues<>();

        for (int i = 0; i < 10; i++){
            queues.enqueues(i);
            System.out.println(queues);
            if (i % 3 == 2){
                queues.dequeues();
                System.out.println(queues);
            }
        }
    }
}
