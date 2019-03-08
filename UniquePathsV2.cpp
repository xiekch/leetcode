//cannot be represented in type 'long int'
class Solution {
public:
    long factorial(int n){
        long result=1;
        while(n>1){
            result*=n;
            n--;
        }
        return result;
    }

    int uniquePaths(int m, int n) {
        // c(m,n)=c(m-1,n)+c(m-1,n-1)
    }
};