// no finished
#include <vector>
using namespace std;

class Solution {
public:
    double findMedianSortedArrays(vector<int>& nums1, vector<int>& nums2) {
        double result=0,temp1,temp2;
        int mid1=0,mid2=0;
        int low1=0,low2=0,high1=nums1.size()-1,high2=nums2.size()-1;
        bool flag1=false,flag2=false;
        while(!flag1&&!flag2){
            while (low1<=high1){
                mid1=(low1+high1)/2;
                mid2=(low2+high2)/2;
                if(nums1[mid1]==nums2[mid2]){
                    flag1=flag2=true;
                }
            }
        }

    }
};