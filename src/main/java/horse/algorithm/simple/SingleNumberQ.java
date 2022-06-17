package horse.algorithm.simple;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * 说明：
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode.cn/leetbook/read/top-interview-questions/xm0u83/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class SingleNumberQ {

    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 7, 2, 3};
        System.out.println(singleNumber1(nums));
        System.out.println(singleNumber2(nums));
    }

    /**
     * 位运算 异或
     * 异或：相同为假，不同为真。
     * 任何数字和0异或还等于他自己
     * a^a=0；自己和自己异或等于0
     * a^0=a；任何数字和0异或还等于他自己
     * a^b^c=a^c^b；异或运算具有交换律
     *
     * @param nums
     * @return
     */
    public static int singleNumber1(int nums[]) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result = result ^ nums[i];
        }
        return result;
    }


    /**
     * 利用set集合的add方法，添加失败就说明已经存在
     *
     * @param nums
     * @return
     */
    public static int singleNumber2(int nums[]) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!set.add(nums[i])) {
                set.remove(nums[i]);
            }
        }
        return (int) set.toArray()[0];
    }
}
