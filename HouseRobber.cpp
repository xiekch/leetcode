// depend others' thoughts
#include <vector>
using namespace std;

class Solution {
public:
    int rob(vector<int>& nums) {
        int last=0,now=0,temp;
        for(int i:nums){
            temp=now;
            now=max(now,last+i);
            last=temp;
        }

        return now;
    }
};