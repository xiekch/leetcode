#include <vector>
#include <iostream>
using namespace std;
// greedy
class Solution {
public:
    bool canJump(vector<int>& nums) {
        for(int i=0,jumpLength=0;i<nums.size();i++,jumpLength--){
            if(jumpLength<0)return false;
            if(jumpLength<nums[i])jumpLength=nums[i];
        }

        return true;
    }
};

int main(){
    Solution s;
    vector<int> v={3,2,1,0,4};
    cout<<s.canJump(v)<<endl;
}