package datastruct;

import java.util.HashMap;
import java.util.Map;

/**
 * 使用双向链表实现LFUCache
 * 时间复杂度 O(n)
 */
public class LFUCacheTest02 {

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
        Node head;
        Node tail;
        int size;
        int cap;

        public LFUCache(int cap) {
            this.cap = cap;
            head = new Node();
            tail = new Node();
            head.next = tail;
            tail.prev = head;
        }

        public int get(int key) {
            Node node = cache.get(key);
            if (node == null) {
                return -1;
            }
            node.freq++;
            movieTo(node);
            return node.value;
        }

        public void put(int key, int value) {
            Node node = cache.get(key);
            if (node == null) {
                node = new Node(key, value);
                if (size == cap) {
                    Node remove = head.next;
                    remove(remove);
                    size--;
                    cache.remove(remove.key);
                }
                addAfter(node, head);
                movieTo(node);
                cache.put(key, node);
                size++;
            } else {
                node.value = value;
                node.freq++;
                movieTo(node);
            }
        }

        private void remove(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        private void addAfter(Node node, Node p) {
            p.next.prev = node;
            node.next = p.next;
            p.next = node;
            node.prev = p;
        }

        private void addBefore(Node node, Node p) {
            p.prev.next = node;
            node.prev = p.prev;

            p.prev = node;
            node.next = p;
        }


        private void movieTo(Node node) {
            int freq = node.freq;
            Node p = node.next;
            // 移除当前node
            remove(node);
            while (p != tail && freq >= p.freq) {
                p = p.next;
            }

            // 插入
            addBefore(node, p);
        }
    }

    static class Node {
        int key;
        int value;
        int freq = 1;
        Node next;
        Node prev;

        public Node() {
        }

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

}
