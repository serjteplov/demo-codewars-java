package ru.serj;

import java.util.ArrayDeque;
import java.util.Deque;

public class Main2 {
    public static void main(String[] args) {

        Deque<Integer> queue = new ArrayDeque<>();
        queue.offerFirst(5);
        queue.offerFirst(6);
        queue.offerFirst(15);
        queue.offerFirst(16);

        Integer l = queue.pollLast();
        System.out.println("l = " + l);
        System.out.println("queue.size() = " + queue.size());
        l = queue.pollLast();
        System.out.println("l = " + l);
        System.out.println("queue.size() = " + queue.size());
        l = queue.pollLast();
        System.out.println("l = " + l);
        System.out.println("queue.size() = " + queue.size());
        l = queue.pollLast();
        System.out.println("l = " + l);
        System.out.println("queue.size() = " + queue.size());
    }


}