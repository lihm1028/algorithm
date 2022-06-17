package horse.algorithm.simple;

import java.util.HashMap;
import java.util.Map;

/**
 * 鸡蛋掉落
 * 给你 k 枚相同的鸡蛋，并可以使用一栋从第1层到第n层共有n层楼的建筑。
 * 已知存在楼层f,满足 0 <= f <= n ，任何从高于f的楼层落下的鸡蛋都会碎，从f楼层或比它低的楼层落下的鸡蛋都不会破。
 * <p>
 * 每次操作，你可以取一枚没有碎的鸡蛋并把它从任一楼层 x 扔下（满足 1 <= x <= n）。
 * 如果鸡蛋碎了，你就不能再次使用它。如果某枚鸡蛋扔下后没有摔碎，则可以在之后的操作中 重复使用 这枚鸡蛋。
 * 请你计算并返回要确定f确切的值的最小操作次数是多少？
 *
 * <p>
 * 输入：k = 1, n = 2
 * 输出：2
 * 解释：
 * 鸡蛋从 1 楼掉落。如果它碎了，肯定能得出 f = 0 。
 * 否则，鸡蛋从2楼掉落。如果它碎了，肯定能得出 f = 1 。
 * 如果它没碎，那么肯定能得出 f = 2 。
 * 因此，在最坏的情况下我们需要移动 2 次以确定 f 是多少。
 */
public class SuperEggDropSolution {


    static Map<Integer, Integer> map = new HashMap<>();

    /**
     * 输入：k = 1, n = 2
     * 输出：2
     * 解释：
     * 鸡蛋从 1 楼掉落。如果它碎了，肯定能得出 f = 0 。
     * 否则，鸡蛋从 2 楼掉落。如果它碎了，肯定能得出 f = 1 。
     * 如果它没碎，那么肯定能得出 f = 2 。
     * 因此，在最坏的情况下我们需要移动 2 次以确定 f 是多少。
     * 示例 2：
     * <p>
     * 输入：k = 2, n = 6
     * 输出：3
     * 示例 3：
     * <p>
     * 输入：k = 3, n = 14
     * 输出：4
     *
     * @param args
     */
    public static void main(String[] args) {
//        System.out.println(superEggDrop(1, 2));
        System.out.println(superEggDrop(2, 6));
//        System.out.println(superEggDrop(3, 14));
    }

    public static int superEggDrop(int K, int N) {
        return dp(K, N);
    }

    private static int dp(int k, int n) {

        if (map.containsKey(n * 100 + k)) {
            return map.get(n * 100 + k);
        }
        int ans;
        if (n == 0) {
            ans = 0;
        } else if (k == 1) {
            ans = n;
        } else {
            int l = 1, r = n;
            while (l + 1 < r) {
                int mid = (l + r) / 2;
                int t1 = dp(k - 1, mid - 1);
                int t2 = dp(k, n - mid);
                if (t1 < t2) {
                    l = mid;
                } else if (t1 > t2) {
                    r = mid;
                } else {
                    l = r = mid;
                }
            }
            ans = 1 + Math.min(Math.max(dp(k - 1, l - 1), dp(k, n - l)), Math.max(dp(k - 1, r - 1), dp(k, n - r)));
        }
        map.put(n * 100 + k, ans);
        return ans;
    }


}
