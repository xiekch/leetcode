#include <queue>
#include <map>
#include <vector>
using namespace std;

class LRUCache {
private:
    int capacity;
    vector<pair<int,int> >v;
public:
    LRUCache(int capacity) {
        this->capacity=capacity;
    }
    
    int get(int key) {
        for(int i=0;i<v.size();i++){
            if(v[i].first==key){
                pair<int,int> temp=v[i];
                for(int j=i;j<v.size()-1;j++){
                    v[j]=v[j+1];
                }
                v[v.size()-1]=temp;
                return temp.second;
            }
        }
        return -1;
    }
    
    void put(int key, int value) {
        if(get(key)!=-1){
            v[v.size()-1].second=value;
            return;
        }
        if(v.size()>=capacity){
            for(int i=0;i<v.size()-1;i++){
                v[i]=v[i+1];
            }
            v[v.size()-1]=make_pair(key,value);
        }else{
            v.push_back(make_pair(key,value));
        }
    }
};

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache* obj = new LRUCache(capacity);
 * int param_1 = obj->get(key);
 * obj->put(key,value);
 */