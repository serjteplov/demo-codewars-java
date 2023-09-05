package ru.serj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        int manNumber = 2;
        int meetNumber = 2;

        ArrayList<int[]> interv = new ArrayList<>();
        int[] ints = {10,250};
        interv.add(ints);

        int[] applicate1 = {8, 20};
        int[] applicate2 = {15, 30};
        int[] applicate3 = {110, 160};
        int[] applicate4 = {222, 233};
        int[] applicate5 = {244, 246};
        int[] applicate6 = {240, 244};

        List<int[]> applicates = new ArrayList<>();
        applicates.add(applicate1);
        applicates.add(applicate2);
        applicates.add(applicate3);
        applicates.add(applicate4);
        applicates.add(applicate5);
        applicates.add(applicate6);

        long start = System.currentTimeMillis();
        List<int[]> list1 = intersect(interv.get(0), applicate1);
        for (int i = 1; i <= applicates.size() - 1; i++) {
            int[] app = applicates.get(i);
            list1 = list1.stream().flatMap(ints1 -> intersect(ints1, app).stream()).collect(Collectors.toList());
        }
        long finish = System.currentTimeMillis();
        long timeElapsed = finish - start;

        list1.forEach(a -> System.out.println(Arrays.toString(a)));
        System.out.println("timeElapsed (millis) = " + timeElapsed);
    }

    public static List<int[]> intersect(int[] input, int[] excluder) {
        List<int[]> minires = new ArrayList<>();

        int c1 = input[0];
        int c2 = excluder[0];
        int[] arr1 = {c1, c2};

        int c3 = excluder[1];
        int c4 = input[1];
        int[] arr2 = {c3, c4};

        if (c2 > c1 && c2 < c4) minires.add(arr1);
        if (c3 < c4 && c3 > c1) minires.add(arr2);
        if (c2 < c1 && c3 < c1) minires.add(input);
        if (c2 > c4 && c3 > c4) minires.add(input);

        return minires.size() == 0 ? List.of(new int[2]) : minires;
    }
}