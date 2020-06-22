package com.company.lab8;

import ando.logicClass.MyLogicClass;
import utils.ArrayUtils;

import java.io.IOException;
import java.util.Scanner;

public class Console {

    public void play(int[][] matrix, String outFile) throws IOException, InterruptedException {

        if(!ArrayUtils.fileFinded(outFile)) {
            System.err.println("Выходной файл указан неверно");
            return;
        }

        Scanner sc = new Scanner(System.in);
        int i, j;
        int[][] changedArr;
        int rows = matrix.length;

        int columns = matrix[0].length;

        System.out.println("Исходный массив");
        for (int i0 = 0; i0 < rows; i0++) {
            for (int j0 = 0; j0 < columns; j0++) {
                System.out.print(" " + matrix[i0][j0]);
            }
            System.out.println();
        }

        System.out.println("Массив с удаленными одинаковыми столбцами");
        changedArr = Solution.Sort_Vib(matrix);

        System.out.print("Файл сохранен в " + outFile);
        sc.next();


    }
}
