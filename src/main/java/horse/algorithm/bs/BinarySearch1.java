package horse.algorithm.bs;

public class BinarySearch1 {


    /**
     * 二分查找法,折半查找法
     *
     * @param arr 要查找的已排序数组
     * @param key 待查找的元素
     * @return
     */
    static int binarySearch(int[] arr, int key) {
        int formIndex = 0;
        int high = arr.length - 1;
        while (formIndex <= high) {
            int mid = (formIndex + high) / 2;
            if (key > arr[mid]) {
                formIndex = mid + 1;
            } else if (key < arr[mid]) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
//        return -1;

        return -(formIndex + 1); //java实现，返回待插入下标位置
    }


    public static void main(String[] args) {
        int[] arr = new int[]{2, 3, 5, 6, 9};
        System.out.println(binarySearch(arr, 5));
        System.out.println(binarySearch(arr, 6));
        System.out.println(binarySearch(arr, 8));
        System.out.println(binarySearch(arr, 9));
        System.out.println(binarySearch(arr, 10));
        System.out.println(binarySearch(arr, 1));

    }
}
