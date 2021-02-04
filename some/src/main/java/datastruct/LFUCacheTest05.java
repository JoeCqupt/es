package datastruct;

import java.util.HashMap;
import java.util.Map;

/**
 * 使用 双向链表嵌套 来实现LFUCache
 */
public class LFUCacheTest05 {
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
        DoubleLinkedList<FreqNode> freqNodes;
        int size;
        int cap;

        public LFUCache(int cap) {
            this.cap = cap;
            try {
                freqNodes = new DoubleLinkedList<>(FreqNode.class);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public int get(int key){
            Node node = cache.get(key);
            if(node == null){
                return -1;
            }
            incrFreq(node);
            return node.value;
        }

        public void put(int key, int value) {
            Node node = cache.get(key);
            if (node == null) {
                if(size == cap){
                    FreqNode minFreqNode = (FreqNode) freqNodes.head.next;
                    Node remove = (Node) minFreqNode.nodes.tail.prev;
                    minFreqNode.nodes.remove(remove);
                    if(minFreqNode.nodes.isEmpty()){
                        freqNodes.remove(minFreqNode);
                    }
                    cache.remove(remove.key);
                    size--;
                }
                node = new Node(key, value);
                FreqNode freqNode = null;
                FreqNode firstNode = (FreqNode) freqNodes.head.next;
                if (freqNodes.isEmpty() || firstNode.freq!= node.freq) {
                    freqNode = new FreqNode(1);
                    freqNodes.addHeadNode(freqNode);
                } else {
                    freqNode = firstNode;
                }
                node.freqNode = freqNode;
                freqNode.nodes.addHeadNode(node);
                cache.put(key, node);
                size++;
            } else {
                node.value = value;
                incrFreq(node);
            }
        }

        private void incrFreq(Node node) {
            DoubleLinkedList<Node> nodes = node.freqNode.nodes;
            nodes.remove(node);

            node.freq++;
            FreqNode freqNode = null;
            FreqNode next = (FreqNode) node.freqNode.next;
            if (next == freqNodes.tail || next.freq!= node.freq) {
                freqNode = new FreqNode(node.freq);
                freqNodes.addNodeAfter(freqNode, node.freqNode);
            } else {
                freqNode = next;
            }

            if (nodes.isEmpty()) {
                freqNodes.remove(node.freqNode);
            }
            node.freqNode = freqNode;
            freqNode.nodes.addHeadNode(node);
        }
    }

    static class DoubleLinkedList<T extends BaseNode> {
        T head;
        T tail;

        public DoubleLinkedList(Class<T> clazz) throws Exception {
            head = clazz.newInstance();
            tail = clazz.newInstance();
            head.next = tail;
            tail.prev = head;
        }

        public boolean isEmpty() {
            return head.next == tail;
        }

        // 头插法
        public void addHeadNode(T node) {
            head.next.prev = node;
            node.next = head.next;
            head.next = node;
            node.prev = head;
        }

        public void addNodeAfter(T node, T prevNode) {
            prevNode.next.prev = node;
            node.next = prevNode.next;

            prevNode.next = node;
            node.prev = prevNode;
        }

        public void remove(T node) {
            node.next.prev = node.prev;
            node.prev.next = node.next;
        }
    }

    static class BaseNode {
        BaseNode prev;
        BaseNode next;
    }

    static class FreqNode extends BaseNode {
        DoubleLinkedList<Node> nodes;
        int freq;

        public FreqNode(int freq) {
            this.freq = freq;
            try {
                nodes = new DoubleLinkedList<>(Node.class);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public FreqNode() {
        }
    }

    static class Node extends BaseNode {
        int key;
        int value;
        int freq = 1;

        FreqNode freqNode;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public Node() {
        }
    }
}
