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
        return factorial(m+n-2)/(factorial(m-1)*factorial(n-1));    
    }
};