package datastruct;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;

/**
 * 使用 LinkedHashSet，保持一个频次的 freqMap
 */
public class LFUCacheTest03 {
    public static void main(String[] args) {
        LFUCache cache = new LFUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        // 返回 1
        System.out.println(cache.get(1));
        cache.put(3, 3);    // 去除 key 2
        // 返回 -1 (未找到key 2)
        System.out.println(cache.get(2));
        // 返回 3
        System.out.println(cache.get(3));
        cache.put(4, 4);    // 去除 key 1
        // 返回 -1 (未找到 key 1)
        System.out.println(cache.get(1));
        // 返回 3
        System.out.println(cache.get(3));
        // 返回 4
        System.out.println(cache.get(4));
    }

    static class LFUCache {
        Map<Integer, Node> cache = new HashMap<>();
        Map<Integer, LinkedHashSet<Integer>> freqMap = new HashMap<>();
        int cap;
        int size;
        int min = 1;

        public LFUCache(int cap) {
            this.cap = cap;
        }

        public void put(int key, int value) {
            Node node = cache.get(key);
            if (node == null) {
                node = new Node(key, value);
                if (size == cap) {
                    int removeKey = removeMin();
                    cache.remove(removeKey);
                    size--;
                }
                cache.put(key, node);


                addFreqMap(node.freq, key);
                size++;
            } else {
                node.value = value;
                incrFreq(node);
            }
        }

        private void addFreqMap(int freq, int key) {
            LinkedHashSet<Integer> freqSet = freqMap.get(freq);
            if (freqSet == null) {
                freqSet = new LinkedHashSet<>();
                freqMap.put(freq, freqSet);
            }
            freqSet.add(key);
        }

        public int get(int key) {
            Node node = cache.get(key);
            if (node == null) {
                return -1;
            }
            incrFreq(node);
            return node.value;
        }

        private int removeMin() {
            LinkedHashSet<Integer> freqSet = freqMap.get(min);
            Iterator<Integer> iterator = freqSet.iterator();
            int key = iterator.next();
            iterator.remove();

            min = 1;
            return key;
        }

        private void incrFreq(Node node) {
            int freq = node.freq;
            LinkedHashSet<Integer> oldFreqSet = freqMap.get(freq);
            oldFreqSet.remove(node.key);
            if (oldFreqSet.isEmpty() && min == freq) {
                min++;
            }

            node.freq++;
            addFreqMap(node.freq, node.key);
        }

    }

    static class Node {
        int key;
        int value;
        int freq = 1;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
