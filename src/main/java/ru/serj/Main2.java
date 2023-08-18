package ru.serj;

import java.math.BigInteger;
import java.util.Arrays;

public class Main2 {
    public static void main(String[] args) {
        int n = 3;
        int h = 4*n-3; //9
        int w = 2*n-1; //5
        BigInteger[][] matrix = new BigInteger[h][w];
        // заполнить шестигранник нулями
        for (int j = 0; j <= w-1; j++) {
            int start = Math.abs(n - 1 - j);
            int finish = h - 1 - Math.abs(n - 1 - j);
            for (int i = start; i <= finish; i = i+2) {
                matrix[i][j] = BigInteger.valueOf(0);
            }
        }

        System.out.println("matrix = " + Arrays.deepToString(matrix));
        System.out.println("matrix.length = 9 " + matrix.length);
        System.out.println("matrix[0] 1 1 1 1 1 = " + Arrays.deepToString(matrix[0]));
        System.out.println("matrix[8] 1 1 1 1 1 = " + Arrays.deepToString(matrix[8]));
        System.out.println("matrix[8][4] 1 = " + matrix[8][4]);
        // System.out.println("matrix[8][5] 1= " + matrix[8][5]);
    }


}