package org.ms.ds.misc;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

class CacheEntry {
    int key;
    String value;

    CacheEntry(int key, String value) {
        this.key = key;
        this.value = value;
    }
}

public class LRUCacheImplementation {

    Deque<CacheEntry> q = new LinkedList<>();
    Map<Integer, CacheEntry> map = new HashMap<>();
    int CACHE_SIZE = 3;

    public String getFromCache(int key) {
        if(map.containsKey(key)) {
            CacheEntry entry = map.get(key);
            q.remove(entry);
            q.addFirst(entry);
            return entry.value;
        }

        return null;
    }

    public void putEntryIntoCache(int key, String value) {
        //replace case
        if(map.containsKey(key)) {
            CacheEntry entry = map.get(key);
            q.remove(entry);
        } else {
            if(q.size() == CACHE_SIZE) {
                CacheEntry entryToBeRemoved = q.removeLast();
                map.remove(entryToBeRemoved.key);
            }
        }

        CacheEntry newEntry = new CacheEntry(key, value);
        q.addFirst(newEntry);
        map.put(key, newEntry);
    }

    public static void main(String[] args) {

        LRUCacheImplementation cache = new LRUCacheImplementation();
        cache.putEntryIntoCache(1, "Product-1-Info");
        cache.putEntryIntoCache(2, "Product-2-Info");
        cache.putEntryIntoCache(3, "Product-3-Info");
        cache.putEntryIntoCache(4, "Product-4-Info");

        System.out.println(cache.getFromCache(2));
        System.out.println(cache.getFromCache(6));

    }

}



