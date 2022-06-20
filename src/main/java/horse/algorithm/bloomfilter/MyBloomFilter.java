package horse.algorithm.bloomfilter;

import java.util.BitSet;

/**
 * 布隆过滤器
 *
 *
 * <p>
 * 主要有个特点：存在的不一定存在，不存在的肯定不存在。
 * <p>
 * 布隆过滤器（英语：Bloom Filter）是1970年由布隆提出的。它实际上是一个很长的二进制向量和一系列随机映射函数。布隆过滤器可以用于检索一个元素是否在一个集合中。
 */
public class MyBloomFilter {


    /**
     * 默认容量10亿的比特位
     */
    private static final int DEFAULT_CAPACITY = 256 << 22;

    /**
     * 为了降低错误率使用加法hash算法，定义了8个元素的质说数组
     */
    private static final int[] seeds = {3, 5, 7, 11, 13, 31, 37, 61};

    /**
     * 初始化布隆过滤器
     */
    private static BitSet bitSet = new BitSet(DEFAULT_CAPACITY);


    private static HashFuncation[] funcations = new HashFuncation[seeds.length];


    private static void add(String key) {
        for (HashFuncation funcation : funcations) {
            bitSet.set(funcation.hash(key), true);
        }
    }

    private static boolean contains(String key) {
        boolean result = true;
        for (HashFuncation funcation : funcations) {
            result = bitSet.get(funcation.hash(key));
            if (!result) {
                break;
            }
        }
        return result;
    }


    public static void main(String[] args) {

        /**
         * 构建8个不同的hash方法
         */
        for (int i = 0; i < seeds.length; i++) {
            funcations[i] = new HashFuncation(DEFAULT_CAPACITY, seeds[i]);
        }

        /**
         * 添加1亿数据
         */
        for (int i = 0; i < 100000000; i++) {
            add(String.valueOf(i));
        }

        String id = "123456789";
        add(id);

        System.out.println(contains(id));   // true
        System.out.println("" + contains("234567890"));  //false


        /**
         * 判断值是否存在过滤器中
         * 布隆过滤器有误报率
         */
        int count = 0;
        for (int i = 0; i < DEFAULT_CAPACITY + 10000; i++) {
            if (contains("" + i)) {
                count++;
            }
        }
        System.out.println("已匹配数量 " + count);

    }

    /**
     * 哈希函数
     */
    public static class HashFuncation {

        private int size;

        /**
         * 种子
         */
        private int seed;


        public HashFuncation(int size, int seed) {
            this.size = size;
            this.seed = seed;
        }

        /**
         * 哈希算法
         *
         * @param key
         * @return
         */
        public int hash(String key) {
            int result = 0;
            int len = key.length();
            for (int i = 0; i < len; i++) {
                result = seed * result + key.charAt(i);
            }
            return (size - 1) & result;
        }
    }

}
