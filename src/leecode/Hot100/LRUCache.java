package leecode.Hot100;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @version: java version 18
 * @Author: Shy
 * @description: 继承LinkedHashMap
 * @date: 2024-06-18 21:13
 */
public class LRUCache extends LinkedHashMap {
    private int capacity;

    public LRUCache(int capacity) {
        super(capacity, 0.75F, true);
        this.capacity = capacity;
    }

    public int get(int key) {
        return (int) super.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry eldest) {
        return super.size() > capacity;
    }
}
