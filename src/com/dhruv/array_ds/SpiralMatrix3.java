package com.dhruv.array_ds;

import java.util.Arrays;

public class SpiralMatrix3 {
    public static void main(String[] args) {
        int rows = 5, cols = 6, rStart = 1, cStart = 4 ;
        int[][] ans = spiralMatrixIII(rows, cols, rStart,cStart);
        for(int[] ar: ans ){
            System.out.println(Arrays.toString(ar));
        }
    }
    public static int[][] spiralMatrixIII(int R, int C, int r0, int c0) {
        int count = 0;
        int total = R * C;
        int[][] a = new int[total][2];
        a[count][0] = r0;
        a[count][1] = c0;
        count++;
        spiral(R, C, r0, c0, count, total, 1, a);
        return a;
    }

    static void spiral(int r, int c, int r0, int c0, int count, int total, int inc, int[][] a) {

        if (count == total) {
            return;
        }
        for (int cc = c0 + 1; cc <= c0 + inc && count < total; cc++) {
            if (cc < c && r0 < r && cc >= 0 && r0 >= 0) {
                a[count][0] = r0;
                a[count][1] = cc;
                count++;
            }
        }
        c0 = c0 + inc;
        for (int cr = r0 + 1; cr <= r0 + inc && count < total; cr++) {
            if (cr < r && c0 < c && cr >= 0 && c0 >= 0) {
                a[count][0] = cr;
                a[count][1] = c0;
                count++;
            }
        }
        r0 = r0 + inc;
        inc++;
        for (int cc = c0 - 1; cc >= c0 - inc && count < total; cc--) {
            if (cc < c && r0 < r && cc >= 0 && r0 >= 0) {
                a[count][0] = r0;
                a[count][1] = cc;
                count++;
            }
        }
        c0 = c0 - inc;
        for (int cr = r0 - 1; cr >= r0 - inc && count < total; cr--) {
            if (cr < r && c0 < c && cr >= 0 && c0 >= 0) {
                a[count][0] = cr;
                a[count][1] = c0;
                count++;
            }
        }
        r0 = r0 - inc;
        spiral(r, c, r0, c0, count, total, inc + 1, a);
    }
}
