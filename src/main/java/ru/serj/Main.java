package ru.serj;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;
import java.util.Optional;

public class Main {

    public static void main(String[] args) {

        int N = 5;
        int M = 11;
        int k = M / N;
        int l = M % N;
        Integer[] cn = {4, 4, 12, 4, 5};
        Integer[] division = new Integer[N];

        for (int i = 0; i <= l - 1; i++) {
            division[i] = (int) Math.ceil((float)cn[i] / (k+1));
        }
        for (int i = l; i < N; i++) {
            if (k == 0) division[i] = null;
            else division[i] = (int) Math.ceil((float)cn[i] / k);
        }

        Arrays.stream(division).forEach(value -> System.out.println("value = " + value));

        Optional<Integer> result = Arrays.stream(division).filter(Objects::nonNull).max(Comparator.naturalOrder());
        System.out.println("result = " + result);
    }
}