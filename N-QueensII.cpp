#include<cmath>
using namespace std;

class Solution {
    int n;
    int total;
    int board[100];
public:
    int totalNQueens(int n) {
        this->n=n;
        total=0;
        backtracking(0);
        return total;
    }

    bool isValid(int cur){
        for(int i=0;i<cur;i++){
            if(board[i]==board[cur]||cur-i==abs(board[cur]-board[i]))
                return false;
        }
        return true;
    }

    void backtracking(int cur){
        if(cur==n){
            total++;
            return; 
        }
        for(int i=0;i<n;i++){
            board[cur]=i;
            if(isValid(cur)){
                backtracking(cur+1);
            }
        }
    }
};