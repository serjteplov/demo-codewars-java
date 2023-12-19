package ru.serj;

import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    public static void main(String[] args) {

        int[][] stena = {{-1, 0, 0, 0}, {0, -1, -1, 0}, {0, 0, -1, 0}, {0, 0, 0, 0}};

        int L = 0;
        int x1 = 0;
        int y1 = 3;
        int x2 = 0;
        int y2 = 1;

        Deque<int[]> queue = new ArrayDeque<>();
        queue.offerFirst(new int[]{x1, y1, 0});
        stena[y1][x1] = 1;

        while (!queue.isEmpty()) {
            int[] current = queue.pollLast();
            int xx = current[0];
            int yy = current[1];
            int ll = current[2];
            stena[yy][xx] = 1;
            if (xx == x2 && yy == y2) {
                L = ll;
                break;
            }
            if (check(xx+1, yy, stena)) queue.offerFirst(new int[]{xx+1, yy, ll+1});
            if (check(xx-1, yy, stena)) queue.offerFirst(new int[]{xx-1, yy, ll+1});
            if (check(   xx, yy+1, stena)) queue.offerFirst(new int[]{xx, yy+1, ll+1});
            if (check(   xx, yy-1, stena)) queue.offerFirst(new int[]{xx, yy-1, ll+1});
        }
        System.out.println("L = " + L);
    }

    public static boolean check(int x, int y, int[][] stena) {
        try {
            return stena[y][x] == 0;
        } catch (Exception e) {
            return false;
        }
    }
}

// walk to target
/*

        int sx = Integer.signum(x2 - x1);
        int sy = Integer.signum(y2 - y1);
        int i = x1;
        int j = y1;
        int k = 2;
        System.out.println(i + " " + j);
        while (i != x2 || j != y2) {
            if (i != x2 && (k % 2 == 0 || j == y2)) i = i + sx;
            else j = j + sy;
            k++;
            System.out.println(i + " " + j);
        }

*/