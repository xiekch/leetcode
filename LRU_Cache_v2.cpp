#include <iostream>
#include <map>
#include <vector>
using namespace std;

class Node {
public:
    Node* prev = nullptr;
    Node* next = nullptr;
    int key = 0;
    int value = 0;
};

class LRUCache {
    int capacity = 0;
    Node* dummyHead = nullptr;
    Node* dummyTail = nullptr;
    map<int, Node*> nodeMap;

    void addToHead(Node* node) {
        node->prev = dummyHead;
        node->next = dummyHead->next;
        dummyHead->next->prev = node;
        dummyHead->next = node;
    }

    void removeNode(Node* node) {
        node->prev->next = node->next;
        node->next->prev = node->prev;
        node->prev = node->next = nullptr;
    }

public:
    LRUCache(int capacity) {
        this->capacity = capacity;
        this->dummyHead = new Node();
        this->dummyTail = new Node();
        dummyHead->next = dummyTail;
        dummyTail->prev = dummyHead;
    }

    int get(int key) {
        if (nodeMap.find(key) == nodeMap.end()) {
            return -1;  // 键不存在
        }
        Node* node = nodeMap[key];
        removeNode(node);  // 移除当前节点
        addToHead(node);   // 移到头部（标记为最近使用）
        return node->value;
    }

    void put(int key, int value) {
        if (nodeMap.find(key) != nodeMap.end()) {
            // 键已存在：更新值并移到头部
            Node* node = nodeMap[key];
            node->value = value;
            removeNode(node);
            addToHead(node);
            return;
        }

        // 键不存在：创建新节点
        Node* newNode = new Node();
        newNode->key = key;
        newNode->value = value;

        if (nodeMap.size() >= capacity) {
            // 容量已满，删除尾部节点
            auto removedNode = dummyTail->prev;
            removeNode(removedNode);
            nodeMap.erase(removedNode->key);  // 从映射中移除
            delete removedNode;  // 释放内存
        }
        addToHead(newNode);
        nodeMap[newNode->key] = newNode;  // 更新映射
    }

    void printList() {
        Node* cur = dummyHead->next;
        while (cur != dummyTail) {
            cout << cur->value << " ";
            cur = cur->next;
        }
        cout << endl;
    }
};

int main() {
    LRUCache lRUCache = LRUCache(2);
    lRUCache.put(1, 1);  // cache is {1=1}
    lRUCache.put(2, 2);  // cache is {1=1, 2=2}
    // lRUCache.printList();
    cout << lRUCache.get(1) << endl;  // return 1
    lRUCache.printList();
    lRUCache.put(3, 3);               // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
    cout << lRUCache.get(2) << endl;  // returns -1 (not found)
    lRUCache.put(4, 4);               // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
    lRUCache.printList();
    cout << lRUCache.get(1) << endl;  // return -1 (not found)
    cout << lRUCache.get(3) << endl;  // return 3
    cout << lRUCache.get(4) << endl;  // return 4
    cout << endl;
}