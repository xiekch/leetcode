#include <iostream>
using namespace std;

struct Node {
    Node* prev = nullptr;
    Node* next = nullptr;
    int val = 0;
};

class DoublyLinkedList {
    Node* head = new Node{nullptr, nullptr, 0};
    Node* tail = new Node{nullptr, nullptr, 0};

public:
    DoublyLinkedList() {
        head->next = tail;
        tail->prev = head;
    }
    void add(int value) {
        Node* newNode = new Node{nullptr, nullptr, value};
        tail->prev->next = newNode;
        newNode->prev = tail->prev;
        newNode->next = tail;
        tail->prev = newNode;
    }

    void remove(int value) {
        Node* node = this->head->next;
        while (node != tail) {
            if (node->val == value) {
                node->prev->next = node->next;
                node->next->prev = node->prev;
                node->next = node->prev = nullptr;
                break;
            }
            node = node->next;
        }
    }

    void print() {
        Node* node = head->next;
        while (node != tail) {
            cout << node->val;
            if (node->next != tail) {
                cout << " -> ";
            }
            node = node->next;
        }
        cout << endl;
    }
};

int main() {
    DoublyLinkedList dl;
    dl.add(1);
    dl.add(2);
    dl.add(3);
    dl.add(5);
    dl.print();
    dl.remove(3);
    dl.print();
}
