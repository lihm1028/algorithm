package horse.algorithm.datastruct;

import java.util.Arrays;
import java.util.Hashtable;
import java.util.Objects;
import java.util.UUID;

/**
 * @author li.hongming
 * @date 2023/4/7
 */
public class HashTable<K, V> {

    /**
     * 缺省容量
     */
    static final int DEFAULT_INITIAL_CAPACITY = 1 << 4;

    /**
     * 扩容因子
     */
    static final float loadFactor = 0.75f;


    /**
     * The table is rehashed when its size exceeds this threshold.  (The
     * value of this field is (int)(capacity * loadFactor).)
     *
     * @serial
     */
    private int threshold;


    /**
     * The number of times this Hashtable has been structurally modified
     * Structural modifications are those that change the number of entries in
     * the Hashtable or otherwise modify its internal structure (e.g.,
     * rehash).  This field is used to make iterators on Collection-views of
     * the Hashtable fail-fast.  (See ConcurrentModificationException).
     */
    private transient int modCount = 0;


    /**
     * The maximum size of array to allocate.
     * Some VMs reserve some header words in an array.
     * Attempts to allocate larger arrays may result in
     * OutOfMemoryError: Requested array size exceeds VM limit
     */
    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;


    // 表
    Entry<K, V>[] table;

    /**
     * 元素数
     */
    int count;


    public HashTable() {
        this(DEFAULT_INITIAL_CAPACITY);
    }

    public HashTable(int initCapacity) {
        table = new Entry[initCapacity];
        threshold = (int) Math.min(initCapacity * loadFactor, MAX_ARRAY_SIZE + 1);
    }

    private void addEntry(int hash, K key, V value, int index) {
        modCount++;

        Entry<?, ?> tab[] = table;
        if (count >= threshold) {
            // Rehash the table if the threshold is exceeded
            rehash();

            tab = table;
            hash = key.hashCode();
            index = (hash & 0x7FFFFFFF) % tab.length;
        }

        // Creates the new entry.
        @SuppressWarnings("unchecked")
        Entry<K, V> e = (Entry<K, V>) tab[index];
        tab[index] = new Entry<>(hash, key, value, e);
        count++;
    }


    synchronized public V put(K key, V value) {
        // Make sure the value is not null
        if (value == null) {
            throw new NullPointerException();
        }
        // Makes sure the key is not already in the hashtable.
        Entry<?, ?> tab[] = table;
        int hash = key.hashCode();
        int index = (hash & 0x7FFFFFFF) % tab.length;
        @SuppressWarnings("unchecked")
        Entry<K, V> entry = (Entry<K, V>) tab[index];
        for (; entry != null; entry = entry.next) {
            if ((entry.hash == hash) && entry.key.equals(key)) {
                V old = entry.value;
                entry.value = value;
                return old;
            }
        }
        addEntry(hash, key, value, index);
        return null;

    }

    public V get(K key) {
        Entry<?, ?> tab[] = table;
        int hash = hash(key);
        int index = (hash & 0x7FFFFFFF) % tab.length;
        for (Entry<?, ?> e = tab[index]; e != null; e = e.next) {
            if ((e.hash == hash) && e.key.equals(key)) {
                return (V) e.value;
            }
        }
        return null;
    }

    void check(Object... objs) {
        Arrays.asList(objs).forEach(x -> {
            Objects.requireNonNull(x);
        });
    }

    int hash(K key) {
        return key.hashCode();
    }

    protected void rehash() {
        int oldCapacity = table.length;
        Entry<?, ?>[] oldMap = table;

        // overflow-conscious code
        int newCapacity = (oldCapacity << 1) + 1;
        if (newCapacity - MAX_ARRAY_SIZE > 0) {
            if (oldCapacity == MAX_ARRAY_SIZE)
                // Keep running with MAX_ARRAY_SIZE buckets
                return;
            newCapacity = MAX_ARRAY_SIZE;
        }
        Entry<K, V>[] newMap = new Entry[newCapacity];

        modCount++;
        threshold = (int) Math.min(newCapacity * loadFactor, MAX_ARRAY_SIZE + 1);
        table = newMap;

        for (int i = oldCapacity; i-- > 0; ) {
            for (Entry<K, V> old = (Entry<K, V>) oldMap[i]; old != null; ) {
                Entry<K, V> e = old;
                old = old.next;

                int index = (e.hash & 0x7FFFFFFF) % newCapacity;
                e.next = (Entry<K, V>) newMap[index];
                newMap[index] = e;
            }
        }
    }

    public synchronized V remove(Object key) {
        Entry<?, ?> tab[] = table;
        int hash = key.hashCode();
        int index = (hash & 0x7FFFFFFF) % tab.length;
        @SuppressWarnings("unchecked")
        Entry<K, V> e = (Entry<K, V>) tab[index];
        for (Entry<K, V> prev = null; e != null; prev = e, e = e.next) {
            if ((e.hash == hash) && e.key.equals(key)) {
                modCount++;
                if (prev != null) {
                    prev.next = e.next;
                } else {
                    tab[index] = e.next;
                }
                count--;
                V oldValue = e.value;
                e.value = null;
                return oldValue;
            }
        }
        return null;
    }

    int getSize() {
        return count;
    }


    static class Entry<K, V> {
        int hash;
        K key;
        V value;
        Entry<K, V> next;

        public Entry(int hash, K key, V value, Entry<K, V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }


    public static void main(String[] args) {
        HashTable ht = new HashTable<String, String>(32);
        for (int i = 0; i < 100; i++) {
            ht.put(String.format("key:%s", i), UUID.randomUUID().toString());
        }
        System.out.println(String.format("size:%s,length:%s", ht.getSize(), ht.table.length));
        for (int j = 0; j < 50; j++) {
            ht.remove(String.format("key:%s", j));
        }
        System.out.println(String.format("size:%s,length:%s", ht.getSize(), ht.table.length));
        System.out.println(ht.get("key:51"));
        System.out.println(ht.remove("key:51"));
        System.out.println(ht.get("key:51"));
    }


}
