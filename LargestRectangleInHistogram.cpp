#include<vector>
using namespace std;

class Solution {
public:
    int largestRectangleArea(vector<int>& heights) {
        int n=heights.size(),area=0,lowR,lowL,j;

        for(int i=0;i<n;i++){
            for(j=i-1;j>=0;j--){
                if(heights[j]<heights[i])
                    break;
            }
            lowR=j;
            for(j=i+1;j<n;j++){
                if(heights[j]<heights[i])
                    break;
            }
            lowL=j;
            area=max(area,heights[i]*(lowL-lowR-1));
        }

        return area;
    }
};