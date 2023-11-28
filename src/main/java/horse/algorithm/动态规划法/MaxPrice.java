package horse.algorithm.动态规划法;

/**
 * @author li.hongming
 * @date 2023/5/26
 */
public class MaxPrice {
    public static void main(String[] args) {

        // 计算切换钢材 最大价值

        int n = 10;
        // 钢材长度价格
        int[] prices = new int[]{0, 1, 2, 3, 4, 5, 4, 3};

        System.out.println(topDownCutMaxPrice(prices, 2));
    }


    // 自顶向下球最大价值,切割最大价值
    public static int topDownCutMaxPrice(int[] p, int n) {
        if (n == 0) {
            return 0;
        }
        int r = 0;
        for (int i = 1; i <= n; i++) {
            int temp = p[i] + topDownCutMaxPrice(p, n - i);
            r = (r > temp) ? r : temp;
            System.out.println("价格temp="+temp+" i="+i+" n-i="+(n - i) +" 最大价格:"+r);

        }
        return r;
    }

}
