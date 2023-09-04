package ru.serj;

import java.util.Arrays;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        String input1 = "[9, 9, 4, 8, 9, 9]";
        String input2 = "[9, 9, 6]";

        input1 = input1.substring(1, input1.length() - 1);
        input2 = input2.substring(1, input2.length() - 1);
        int[] arr1 = Stream.of(input1.split(", ")).mapToInt(Integer::parseInt).toArray();
        int[] arr2 = Stream.of(input2.split(", ")).mapToInt(Integer::parseInt).toArray();
        int l1 = arr1.length;
        int l2 = arr2.length;
        int[] arr3 = new int[Math.max(l1, l2) + 1];
        int l3 = arr3.length;

        for (int i = l3 - 2; i >= 0; i--) {
            int one = i > l1 - 1 ? 0 : arr1[i];
            int two = i > l2 - 1 ? 0 : arr2[i];
            arr3[l3 - 2 - i] = one + two;
        }

        int vume = 0;
        for (int i = 0; i <= l3 - 1; i++) {
            arr3[i] += vume;
            vume = arr3[i] / 10;
            if (vume > 0) {
                arr3[i] = arr3[i] % 10;
            }
        }
        if (arr3[l3 - 1] == 0) {
            arr3 = Arrays.copyOf(arr3, l3 - 1);
            l3--;
        }
        for (int i = 0; i <= (l3 / 2) - 1; i++) {
            arr3[i] += arr3[l3 - 1 - i];
            arr3[l3 - 1 - i] = arr3[i] - arr3[l3 - 1 - i];
            arr3[i] = arr3[i] - arr3[l3 - 1 - i];
        }

        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
        System.out.println(Arrays.toString(arr3));
    }
}