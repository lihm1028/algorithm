package horse.algorithm.bloomfilter;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

import java.nio.charset.Charset;

public class GuavaBloomFilterDemo {

    public static void main(String[] args) {

        int total = 1000000;
//        final BloomFilter<CharSequence> bloomFilter = BloomFilter.create(Funnels.stringFunnel(Charset.forName("UTF-8")), total);
        // 可以设置误报率
        final BloomFilter<CharSequence> bloomFilter = BloomFilter.create(Funnels.stringFunnel(Charset.forName("UTF-8")), total,0.02);

        // 初始化 1000000 条数据到过滤器中
        for (int i = 0; i < total; i++) {
            bloomFilter.put("abc" + i);
        }

        System.out.println(bloomFilter.mightContain("abc123456"));


        int count = 0;

        for (int i = 0; i < total + 10000; i++) {
            if (bloomFilter.mightContain("abc" + i)) {
                count++;
            }
        }

        System.out.println("已匹配到元素个数为:" + count);


    }
}
