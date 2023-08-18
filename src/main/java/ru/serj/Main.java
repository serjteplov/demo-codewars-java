package ru.serj;

import java.math.BigInteger;

import static java.math.BigInteger.ONE;
import static java.math.BigInteger.ZERO;


public class Main {
    public static void main(String[] args) {
        int n = 3;
        int w = 2*n-1;

        BigInteger[][] matrix = new BigInteger[w+2][w+1];
        for (int j = 0; j <= w-1; j++) {
            for (int i = 1; i <= w - Math.abs(n-1 - j); i++) {
                matrix[i][j] = ZERO;
            }
        }
        matrix[n][w] = ONE;

        for (int j = w-1; j >= 0; j--) {
            for (int i = w; i > 0; i--) {
                if (matrix[i][j] == null) continue;
                int adjust = j < n - 1 ? 1 : 0;
                var rightUp = matrix[i-1+adjust][j+1] == null ? ZERO : matrix[i-1+adjust][j+1];
                var rightDown = matrix[i+adjust][j+1] == null ? ZERO : matrix[i+adjust][j+1];
                var down = matrix[i+1][j] == null ? ZERO : matrix[i+1][j];
                matrix[i][j] = rightUp.add(rightDown).add(down);
            }
        }



        System.out.println("bee = " + matrix[1][0]);
    }


}