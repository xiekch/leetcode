#include <vector>
#include <cstring>
using namespace std;
// Time Limit Exceeded
int arr[100010];
class Solution {
public:
    // bfs
    int jump(vector<int>& nums) {
        if(nums.size()==0)return 0;
        memset(arr,-1,sizeof(arr));
        arr[0]=0;
        for(int i=0;i<nums.size();i++){
            if(nums[i]+i>=nums.size()-1)return arr[i]+1;
            for(int j=1;j<=nums[i]&&i+j<nums.size();j++){
                if(arr[i+j]==-1)arr[i+j]=arr[i]+1;
                arr[i+j]=min(arr[i]+1,arr[i+j]);
            }
        }
        return arr[nums.size()-1];
    }
};