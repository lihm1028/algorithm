package horse.algorithm.middle;

import java.util.Arrays;

/**
 * 矩阵置零
 * 给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用原地算法。
 */
public class SetZeroesSolution {

    public static void setZeroes(int[][] matrix) {
        final int row = matrix.length;
        final int col = matrix[0].length;

        boolean[] rowZero = new boolean[row];
        boolean[] colZero = new boolean[col];

        /**
         * 第一次遍历，确定哪些行和列是0
         */
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < row; j++) {
                if (matrix[i][j] == 0) {
                    rowZero[i] = true;
                    colZero[j] = true;
                }

            }
        }
        /**
         * 将存在0的行和列都设为0
         */
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < row; j++) {
                if (rowZero[i] || colZero[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
        Arrays.toString(matrix);
        setZeroes(matrix);
        Arrays.toString(matrix);
    }

}
