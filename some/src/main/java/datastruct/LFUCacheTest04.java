package datastruct;

import java.util.HashMap;
import java.util.Map;

/**
 * 使用双向链表， 保持一个频次 freqMap
 */
public class LFUCacheTest04 {
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
        Map<Integer, DoubleLinkedList> freqMap = new HashMap<>();
        int size;
        int cap;
        int min;

        public LFUCache(int cap) {
            this.cap = cap;
        }

        public void put(int key, int value) {
            Node node = cache.get(key);
            if (node == null) {
                if (size == cap) {
                    DoubleLinkedList doubleLinkedList = freqMap.get(min);
                    Node removeNode = doubleLinkedList.removeTail();
                    cache.remove(removeNode.key);
                    size--;
                }
                node = new Node(key, value);
                addFreqMap(node.freq, node);
                cache.put(key, node);
                size++;
                min = 1;
            } else {
                node.value = value;
                incrFreq(node);
            }
        }

        public int get(int key) {
            Node node = cache.get(key);
            if (node == null) {
                return -1;
            }
            incrFreq(node);
            return node.value;
        }

        private void incrFreq(Node node) {
            int freq = node.freq;
            DoubleLinkedList oldDoubleLinkedList = freqMap.get(freq);
            oldDoubleLinkedList.removeNode(node);
            if (oldDoubleLinkedList.isEmpty() && min == freq) {
                min++;
            }
            node.freq++;
            addFreqMap(node.freq, node);
        }

        private void addFreqMap(int freq, Node node) {
            DoubleLinkedList doubleLinkedList = freqMap.get(freq);
            if (doubleLinkedList == null) {
                doubleLinkedList = new DoubleLinkedList();
                freqMap.put(freq, doubleLinkedList);
            }
            doubleLinkedList.addHead(node);
        }

    }

    static class DoubleLinkedList {
        Node head;
        Node tail;

        public DoubleLinkedList() {
            head = new Node();
            tail = new Node();
            head.next = tail;
            tail.prev = head;
        }

        boolean isEmpty() {
            return head.next == tail;
        }

        void addHead(Node node) {
            head.next.prev = node;
            node.next = head.next;
            head.next = node;
            node.prev = head;
        }

        void removeNode(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        Node removeTail() {
            Node removeNode = tail.prev;
            removeNode(removeNode);
            return removeNode;
        }
    }

    static class Node {
        int key;
        int value;
        int freq = 1;

        Node prev;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public Node() {
        }
    }
}
