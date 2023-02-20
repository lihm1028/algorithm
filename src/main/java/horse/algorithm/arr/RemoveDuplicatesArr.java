package horse.algorithm.arr;

/**
 * @author li.hongming
 * @date 2023/2/20
 */
public class RemoveDuplicatesArr {


    public static void main(String[] args) {
//        int[] nums = {1, 1, 2, 3, 3, 4, 5};
        int[] nums = {0, 1, 2, 3, 3, 4, 4, 5, 6, 7, 8, 8, 8, 9, 10};
        int k = removeDuplicates(nums);

        System.out.println(k);
        // 打印所有数组元素
        for (int i = 0; i < k; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    /**
     * 指针向后移动
     *
     * @param nums
     * @return
     */
    public static int removeDuplicates(int[] nums) {
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[i] != nums[j]) {
                i = i + 1;
                nums[i] = nums[j];
            } else {
                //相等不用处理
            }

        }
        return i + 1;
    }
}
