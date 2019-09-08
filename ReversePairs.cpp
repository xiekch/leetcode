#include <vector>
#include <algorithm>
using namespace std;
// BIT

// original index order <-> update order
class Solution {
public:
    // query the sum of how many numbers >= it
    // from index to tail
    int query(vector<int>&bit,int index){
        int sum=0;
        while(index<bit.size()){
            sum+=bit[index];
            index+=index&-index;
        }
        return sum;
    }

    // increase the occuring times of it
    // add it from index to head
    void update(vector<int>&bit,int index,int diff){
        while(index>0){
            bit[index]+=diff;
            index-=index&-index;
        }
    }
    
    int reversePairs(vector<int>& nums) {
        int count=0;
        vector<int>bit(nums.size()+1,0);
        vector<int>nums_copy(nums);
        sort(nums_copy.begin(),nums_copy.end());
        for(int i=0;i<nums.size();i++){
            count+=query(bit,lower_bound(nums_copy.begin(),nums_copy.end(),2ll*nums[i]+1)-nums_copy.begin()+1);
            update(bit,lower_bound(nums_copy.begin(),nums_copy.end(),nums[i])-nums_copy.begin()+1,1);
        }
        
        return count;
    }
};