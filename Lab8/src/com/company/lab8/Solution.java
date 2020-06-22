package com.company.lab8;

public class Solution {

    public static int[][] Sort_Vib(int[][] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                int min = a[i][j];
                int imin = j;
                for (int g = j + 1; g < a.length; g++) {
                    if (a[i][g] < min) {
                        min = a[i][g];
                        imin = g;
                    }
                }
                if (j != imin) {
                    int temp = a[i][j];
                    a[i][j] = a[i][imin];
                    a[i][imin] = temp;
                }
            }
        }
        return a;
    }
}

