// https://blog.csdn.net/magicbean2/article/details/78889530
#include <string>
#include <set>
#include <cmath>
using namespace std;
// 101 -> 99
class Solution {
    
public:
    string nearestPalindromic(string n) {
        int len=n.length();
        long long t=stol(n);
        set<long long>s;
        s.insert(pow(10,len)+1);
        s.insert(pow(10,len-1)-1);
        long long pre=stol(n.substr(0,(len+1)/2));
        for(int i=-1;i<=1;i++){
            string prex=to_string(pre+i);
            s.insert(stol(prex+string(prex.rbegin()+(len&1),prex.rend())));// odd or even
        }

        s.erase(t);
        long long mini=LONG_MAX,result;
        for(long long i:s){
            if(abs(i-t)<mini){
                mini=abs(i-t);
                result=i;
            }
        }
        
        return to_string(result);
    }
};