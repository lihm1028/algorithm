package horse.algorithm.bs;

/**
 * 二分查找变体
 */
public class BinarySearchVariant {

    /**
     * 变体2：查找最后一个值等于给定值的元素
     *
     * @param nums
     * @param n
     * @param value
     * @return
     */
    public static int bsearch2(int[] nums, int n, int value) {

        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (nums[mid] > value) {
                high = mid - 1;
            } else if (nums[mid] == value) {
                if (mid == n - 1 || nums[mid + 1] != value) {
                    return mid;
                }

            } else {
                low = mid + 1;
            }

        }
        return -1;
    }


    /**
     * 变体3：查找第一个值大于或等于给定值的元素
     *
     * @param nums
     * @param n
     * @param firstValue
     * @return
     */
    public static int bsearch3(int[] nums, int n, int firstValue) {

        int low = 0;
        int high = n - 1;

        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (nums[mid] >= firstValue) {
                if (mid == 0 || nums[mid - 1] < firstValue) {
                    return mid;
                } else {
                    high = mid - 1;
                }
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }


    /**
     * 变体4：查找最后一个值小于或者等于给定值的元素
     *
     * @param nums
     * @param n
     * @param value
     * @return
     */
    public static int bsearch4(int[] nums, int n, int value) {

        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (nums[mid] > value) {
                high = mid - 1;
            } else {
                if ((mid == n - 1) || (nums[mid + 1] > value)) {
                    return mid;
                } else {
                    low = mid + 1;
                }

            }
        }
        return -1;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{3, 4, 5, 5, 6, 7, 10};

        /**
         * 查找最后一个值等于给定值的元素
         */
        System.out.println(bsearch2(nums, nums.length, 5));


        /**
         * 查找第一个值大于或等于给定值的元素
         */
        System.out.println(bsearch3(nums, nums.length, 5));


        /**
         * 变体4：查找最后一个值小于或者等于给定值的元素
         */
        System.out.println(bsearch4(nums, nums.length, 8));
    }
}
