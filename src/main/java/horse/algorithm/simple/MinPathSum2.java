package horse.algorithm.simple;

/**
 * 给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * 说明：每次只能向下或者向右移动一步。
 */
public class MinPathSum2 {

    public static int minPathSum(int[][] grid) {
        
        int width = grid[0].length;
        int high = grid.length;
        /**
         *  利用动态规划法：
         *  求左下角到右下角最短路径，转换为求到每个点的最小路径。
         *  由于只能向下或者向右，所以除了第一列和第一行以外都有两种路径，我们先求第一行和第一列。
         * 1.先将第一行最小路径求和
         */
        for (int i = 1; i < high; i++) {
            grid[i][0] += grid[i - 1][0];
        }
        /**
         * 2.将第一列最小路径求和
         */
        for (int i = 1; i < width; i++) {
            grid[0][i] += grid[0][i - 1];
        }

        /**
         * 将i行j列路径求和，
         * 这里有两种路径，需要取最小路径。
         */
        for (int i = 1; i < high; i++) {
            for (int j = 1; j < width; j++) {
                grid[i][j] += Math.min(grid[i][j - 1], grid[i - 1][j]);
            }
        }
        int min = grid[high - 1][width - 1];
        return min;
    }


    private static void printGrid(int[][] grid, String title) {
        System.out.println("##########[" + title + "]################");
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                System.out.print(grid[i][j]);
                System.out.print("\t");
            }
            System.out.println("");
        }
    }

    public static void main(String[] args) {

        int[][] grid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        printGrid(grid, "源数据");
        System.out.println("最小路径和为：" + minPathSum(grid));


    }
}
