package datastruct;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 使用优先队列来实现 LFUCache
 * 时间负责度O(logn)  O(n)
 */
public class LFUCacheTest01 {

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

        while (!cache.freQueue.isEmpty()) {
            System.out.println(cache.freQueue.poll());
        }
    }


    static class LFUCache {
        Map<Integer, Node> cache = new HashMap<>();
        PriorityQueue<Node> freQueue;
        int size;
        int cap;// 容量
        int index;

        public LFUCache(int cap) {
            this.cap = cap;
            freQueue = new PriorityQueue<>(cap);
        }

        public int get(int key) {
            Node node = cache.get(key);
            if (node == null) {
                return -1;
            }
            freQueue.remove(node);
            node.fre++;
            node.index = index++;
            freQueue.offer(node);
            return node.value;
        }

        public void put(int key, int value) {
            Node node = cache.get(key);
            if (node == null) {
                size++;
                if (size > cap) {
                    Node remove = freQueue.poll();
                    cache.remove(remove.key);
                    size--;
                }
                node = new Node(key, value, index++);
                freQueue.offer(node);
                cache.put(key, node);
            } else {
                freQueue.remove(node);
                node.value = value;
                node.fre++;
                node.index = index++;
                freQueue.offer(node);
            }
        }

    }

    static class Node implements Comparable<Node> {
        Integer key;
        Integer value;
        int fre = 1;
        int index;

        public Node(Integer key, Integer value, int index) {
            this.key = key;
            this.value = value;
            this.index = index;
        }

        @Override
        public int compareTo(Node n) {
            int r = fre - n.fre;
            return r == 0 ? index - n.index : r;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "key=" + key +
                    ", value=" + value +
                    ", fre=" + fre +
                    ", index=" + index +
                    '}';
        }
    }
}
