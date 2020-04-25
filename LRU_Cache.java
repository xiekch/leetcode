import java.util.HashMap;
// https://leetcode.com/problems/lru-cache/discuss/45911/Java-Hashtable-%2B-Double-linked-list-(with-a-touch-of-pseudo-nodes)

class ListNode {
    int key;
    int value;
    ListNode pre;
    ListNode post;

    public ListNode() {
    }

    public ListNode(int key, int value) {
        this.key = key;
        this.value = value;
    }

    void addAfter(ListNode node) {
        this.pre = node;
        this.post = node.post;
        node.post.pre = this;
        node.post = this;
    }

    void removeFromList() {
        if (this.pre != null) {
            this.pre.post = this.post;
        }
        if (this.post != null)
            this.post.pre = this.pre;
        this.pre = this.post = null;
    }
}

class LRUCache {
    private final int capacity;
    private HashMap<Integer, ListNode> cache;
    private ListNode head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new ListNode();
        tail = new ListNode();
        head.post = tail;
        tail.pre = head;
        cache = new HashMap<>();
    }

    public int get(int key) {
        ListNode node = cache.get(key);
        if (node == null)
            return -1;
        node.removeFromList();
        node.addAfter(head);
        return node.value;
    }

    public void put(int key, int value) {
        ListNode node = cache.get(key);
        if (node != null) {
            node.value = value;
            node.removeFromList();
        } else
            node = new ListNode(key, value);
        node.addAfter(head);
        cache.put(key, node);
        if (cache.size() > capacity) {
            ListNode toRemove = tail.pre;
            toRemove.removeFromList();
            cache.remove(toRemove.key);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such: LRUCache obj =
 * new LRUCache(capacity); int param_1 = obj.get(key); obj.put(key,value);
 */
public class LRU_Cache {
    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(3);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        lruCache.put(3, 3);
        lruCache.put(4, 4);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(2));
        lruCache.put(5, 5);
        System.out.println(lruCache.get(2));
        System.out.println(lruCache.get(3));
    }
}