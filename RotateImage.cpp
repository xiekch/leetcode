#include <vector>
using namespace std;

class Solution {
public:
    void rotate(vector<vector<int> >& matrix) {
        int temp,n=matrix.size(),x;
        for(int i=0;i<n/2+n%2;i++){
            for(int j=0;j<n/2;j++){
                int r=i,c=j;
                temp=matrix[i][j];
                for(int k=0;k<3;k++){
                    matrix[r][c]=matrix[n-1-c][r];
                    x=r;
                    r=n-1-c;
                    c=x;
                }
                matrix[r][c]=temp;
            }
        }      
    }
};