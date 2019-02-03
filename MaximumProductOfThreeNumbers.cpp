#include <vector>
#include <cstring>
using namespace std;


// heap sort
class Solution {
public:
    int maximumProduct(vector<int>& nums) {
        vector<int>pos,neg;
        for(int n:nums){
            if(n<0){
                for(auto it=neg.begin();;it++){
                    if(it==neg.end()){neg.push_back(n);break;}
                    else if(*it>n){neg.insert(it,n);break;}
                }
                if(neg.size()>3)neg.pop_back();
            }

            if(n>=0){
                for(auto it=pos.begin();;it++){
                    if(it==pos.end()){pos.push_back(n);break;}
                    else if(*it<n){pos.insert(it,n);break;}
                }
                if(pos.size()>3)pos.pop_back();
            }
        }
        int result=INT_MIN;
        for(int i=0;i<neg.size();i++)pos.push_back(neg[i]);
        for(int i=0;i<pos.size();i++){
            for(int j=i+1;j<pos.size();j++){
                for(int k=j+1;k<pos.size();k++){
                    if(result<pos[i]*pos[j]*pos[k])result=pos[i]*pos[j]*pos[k];
                }
            }
        }
        return result;
    }
};