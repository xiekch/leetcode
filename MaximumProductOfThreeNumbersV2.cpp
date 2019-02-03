#include <vector>
#include <cstring>
using namespace std;


// heap sort
class Solution {
public:
    int maximumProduct(vector<int>& nums) {
        vector<int>big,small;
        for(int n:nums){           
                for(auto it=small.begin();;it++){
                    if(it==small.end()){small.push_back(n);break;}
                    else if(*it>n){small.insert(it,n);break;}
                }
                if(small.size()>2)small.pop_back();

                for(auto it=big.begin();;it++){
                    if(it==big.end()){big.push_back(n);break;}
                    else if(*it<n){big.insert(it,n);break;}
                }
                if(big.size()>3)big.pop_back();
        }
        
        return max(big[0]*big[1]*big[2],big[0]*small[0]*small[1]);
    }
};