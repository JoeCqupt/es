package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Solution146 {

    class LRUCache {
        class Node {
            int key;
            int val;

            public Node() {
            }

            public Node(int key, int val) {
                this.key = key;
                this.val = val;
            }

            Node prv;
            Node next;
        }


        int cap;
        Map<Integer, Node> cacheMap = new HashMap<>();
        Node head;
        Node tail;
        int size;

        public LRUCache(int capacity) {
            cap = capacity;
            head = new Node();
            tail = new Node();
            head.next = tail;
            tail.prv = head;
        }

        public int get(int key) {
            Node node = cacheMap.get(key);
            if (node == null) {
                return -1;
            }

            // 移除node
            removeNode(node);
            // 头部插入node
            insertHead(node);
            return node.val;
        }

        public void removeNode(Node node) {
            node.next.prv = node.prv;
            node.prv.next = node.next;
        }

        public void insertHead(Node node) {
            node.next = head.next;
            head.next.prv = node;
            node.prv = head;
            head.next = node;
        }

        public Node remoteTail() {
            Node remove = tail.prv;

            tail.prv.prv.next = tail;
            tail.prv = tail.prv.prv;

            return remove;
        }

        public void put(int key, int value) {
            Node node = cacheMap.get(key);
            if (node == null) {
                //表示是新key
                node = new Node(key, value);
                if (size == cap) {
                    //表示容量已经满了，要移除最后一个元素
                    Node remove = remoteTail();
                    cacheMap.remove(remove.key);
                    size--;
                }
                cacheMap.put(key, node);
                insertHead(node);
                size++;
            } else {
                node.val = value;
                removeNode(node);
                insertHead(node);
            }
        }
    }

}
