package ru.serj;


import java.util.Arrays;

public class Main {
    private static final int POLOSA = 3;
    private static final int TARGET = 6;

    public static void main(String[] args) {
        boolean[][] obst = new boolean[TARGET+1][POLOSA+2];
        for (int i = 0; i <= TARGET; i++) {
            obst[i][0] = true;
            obst[i][POLOSA+1] = true;
        }
        obst[1][1] = true;
        obst[2][1] = true;
        obst[2][2] = true;
        obst[3][2] = true;
        obst[3][3] = true;
        obst[4][1] = true;
        obst[4][2] = true;
        obst[4][3] = true;
        obst[5][1] = true;
        obst[5][2] = true;

        for (int i = 0; i <= POLOSA+1; i++) System.out.print("  " + i + "    ");
        System.out.println();
        for (int i = TARGET; i >= 0; i--) System.out.println(i + Arrays.toString(obst[i]));

        System.out.println("recursive = " + recur(obst, 0, 2));
        boolean[] firstCheck = new boolean[]{false, true, true, true, false};
        System.out.println("iterative = " + iterat(obst, firstCheck));
    }

    public static int recur(boolean[][] obst, int i, int j) {
        if (i == TARGET) return i;
        int max1 = !obst[i+1][j-1]                                    ? recur(obst, i+1, j-1) : 0;
        int max2 = !obst[i+1][j]    && max1 < TARGET                  ? recur(obst, i+1, j)     : 0;
        int max3 = !obst[i+1][j+1]  && max1 < TARGET && max2 < TARGET ? recur(obst, i+1, j+1) : 0;
        int tsarMax = Math.max(max1, Math.max(max2, max3));
        return tsarMax == 0 ? i : tsarMax;
    }

    public static int iterat(boolean[][] obst, boolean[] lineToCheck) {
        for (int i = 0; i < obst.length-1; i++) {

            boolean[] temp = new boolean[5];
            for (int k = 1; k <= POLOSA; k++) {
                if (lineToCheck[k] && !obst[i + 1][k]) {
                    temp[k] = true;
                    temp[k+1] = true;
                    temp[k-1] = true;
                }
            }

            if (!temp[1] && !temp[2] && !temp[3]) return i;
            lineToCheck = Arrays.copyOf(temp, POLOSA + 2);
        }
        return obst.length-1;
    }
}