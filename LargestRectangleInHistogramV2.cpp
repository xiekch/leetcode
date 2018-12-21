#include<vector>
#include<stack>
using namespace std;

class Solution {
    int *lowR;
    int *lowL;
public:
    int largestRectangleArea(vector<int>& heights) {
        int n=heights.size(),area=0;
        stack<int>st;
        if(n==0)return 0;
        lowR=new int[n]();
        lowL=new int[n]();
        
        for(int i=0;i<n;i++){
            while(!st.empty()&&heights[i]<=heights[st.top()]){
                st.pop();
            }
            if(st.empty())lowR[i]=-1;
            else lowR[i]=st.top();
            // cout<<i<<": "<<lowR[i]<<endl;
            st.push(i);
        }
        while(!st.empty())st.pop();
        for(int i=n-1;i>=0;i--){
            while(!st.empty()&&heights[i]<=heights[st.top()]){
                st.pop();
            }
            if(st.empty())lowL[i]=n;
            else lowL[i]=st.top();
            // cout<<i<<": "<<lowL[i]<<endl;
            st.push(i);
        }

        for(int i=0;i<n;i++){
            area=max(area,heights[i]*(lowL[i]-lowR[i]-1));
            // cout<<area<<endl;
        }

        return area;
    }
};