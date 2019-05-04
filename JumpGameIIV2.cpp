#include <vector>
#include <cstring>
#include <iostream>
using namespace std;
// AC
// bfs
class Solution {
public:
    int jump(vector<int>& nums) {
        if(nums.size()<=1)return 0;
        int i=0,curMax=0,step=0,nextMax=0;
        while(curMax>=i){
            for(;i<=curMax;i++){
                nextMax=max(nextMax,i+nums[i]);
                if(nextMax>=nums.size()-1){
                    return step+1;
                }
            }
            step++;
            curMax=nextMax;
        }
        return -1;
    }
};

int main(){
    Solution sol;
    vector<int>v;
    int temp=1;
    // freopen("./JumpGameII.in","r",stdin);
    freopen("./test.in","r",stdin);
    while(scanf("%d",&temp)==1){
        v.push_back(temp);
    }
    cout<<sol.jump(v)<<endl;

    return 0;
}