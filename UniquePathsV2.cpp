// time limited
class Solution {
public:
    long combination(int m,int n){
        if(m==n)return 1;
        else if(n==1)return m;
        else return combination(m-1,n)+combination(m-1,n-1);
    }

    int uniquePaths(int m, int n) {
        // c(m,n)=c(m-1,n)+c(m-1,n-1)
        return combination(m+n-2,m-1);
    }
};