#include <iostream>
#include <string>
using namespace std;
struct Node {
    string word;
    Node *left;
    Node *right;
    Node() : left(NULL), right(NULL) {}
    Node(string word) : word(word), left(NULL), right(NULL) {}
};

class Trie {
    Node *root;
    // caution: Node *&root
    void insert(Node *&root, string word) {
        if (root == NULL) {
            root = new Node(word);
            return;
        }
        if (word == root->word)
            return;
        if (word > root->word) {
            insert(root->right, word);
        } else {
            insert(root->left, word);
        }
    }

    bool search(Node *root, string word) {
        if (root == NULL)
            return false;
        if (root->word == word)
            return true;
        if (root->word < word)
            return search(root->right, word);
        else {
            return search(root->left, word);
        }
    }

    bool startsWith(Node *root, string prefix) {
        if (root == NULL)
            return false;
        if (root->word.find(prefix) == 0)
            return true;
        if (root->word < prefix)
            return startsWith(root->right, prefix);
        else {
            return startsWith(root->left, prefix);
        }
    }

  public:
    /** Initialize your data structure here. */
    Trie() { root = NULL; }

    /** Inserts a word into the trie. */
    void insert(string word) { insert(root, word); }

    /** Returns if the word is in the trie. */
    bool search(string word) { return search(root, word); }

    /** Returns if there is any word in the trie that starts with the given
     * prefix. */
    bool startsWith(string prefix) { return startsWith(root, prefix); }
};

// ["Trie","insert","insert","insert","insert","insert","insert","search","search","search","search","search","search","search","search","search","startsWith","startsWith","startsWith","startsWith","startsWith","startsWith","startsWith","startsWith","startsWith"]
// [[],["app"],["apple"],["beer"],["add"],["jam"],["rental"],["apps"],["app"],["ad"],["applepie"],["rest"],["jan"],["rent"],["beer"],["jam"],["apps"],["app"],["ad"],["applepie"],["rest"],["jan"],["rent"],["beer"],["jam"]]

int main(int argc, char const *argv[]) {
    cout << (string("app") < string("apple")) << endl; // true
    Trie trie;
    trie.insert("app");
    trie.insert("apple");
    trie.insert("beer");
    trie.insert("add");
    trie.insert("jam");
    trie.insert("cental");
    cout << trie.search("apple") << endl;     // returns true
    cout << trie.startsWith("apple") << endl; // returns true
    cout << trie.search("car") << endl;       // returns false
    cout << trie.startsWith("app") << endl;   // returns true
    trie.insert("app");
    cout << trie.search("app") << endl;       // returns true
    cout << trie.startsWith("app") << endl;   // returns true
    cout << trie.startsWith("cent") << endl; // returns true
    return 0;
}
