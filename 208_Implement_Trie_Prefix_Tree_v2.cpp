#include <iostream>
#include <string>
using namespace std;
class TrieNode {
  private:
    TrieNode *links[26] = {NULL};
    bool isEnd; // whether the node can be the end of a word

  public:
    TrieNode() { isEnd = false; }
    bool getIsEnd() { return isEnd; }
    void setEnd() { isEnd = true; }

    void put(char ch) {
        if (links[ch - 'a'] == NULL)
            links[ch - 'a'] = new TrieNode();
    }
    TrieNode *get(char ch) { return links[ch - 'a']; }

    bool containKey(char ch) { return links[ch - 'a'] != NULL; }
};

class Trie {
    TrieNode root;
    TrieNode *searchPrefix(string word) {
        TrieNode *node = &root;
        for (int i = 0; node != NULL && i < word.size(); i++) {
            char ch = word[i];
            node = node->get(ch);
        }
        return node;
    }

  public:
    /** Initialize your data structure here. */
    Trie() {}

    /** Inserts a word into the trie. */
    void insert(string word) {
        TrieNode *node = &root;
        for (int i = 0; i < word.size(); i++) {
            char ch = word[i];
            node->put(ch);
            node = node->get(ch);
        }
        node->setEnd();
    }

    /** Returns if the word is in the trie. */
    bool search(string word) {
        TrieNode *node = searchPrefix(word);
        if (node == NULL)
            return false;
        return node->getIsEnd() == true;
    }

    /** Returns if there is any word in the trie that starts with the given
     * prefix. */
    bool startsWith(string prefix) {
        TrieNode *node = searchPrefix(prefix);
        if (node == NULL)
            return false;
        return true;
    }
};

// ["Trie","insert","insert","insert","insert","insert","insert","search","search","search","search","search","search","search","search","search","startsWith","startsWith","startsWith","startsWith","startsWith","startsWith","startsWith","startsWith","startsWith"]
// [[],["app"],["apple"],["beer"],["add"],["jam"],["rental"],["apps"],["app"],["ad"],["applepie"],["rest"],["jan"],["rent"],["beer"],["jam"],["apps"],["app"],["ad"],["applepie"],["rest"],["jan"],["rent"],["beer"],["jam"]]

int main(int argc, char const *argv[]) {
    cout << (string("app") < string("apple")) << endl;
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
    cout << trie.search("app") << endl;      // returns true
    cout << trie.startsWith("app") << endl;  // returns true
    cout << trie.startsWith("cent") << endl; // returns true
    return 0;
}
