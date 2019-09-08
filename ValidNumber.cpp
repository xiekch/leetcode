#include <regex>
#include <iostream>
#include <string>
using namespace std;

class Solution {
public:
    bool isNumber(string s) {
        regex pattern(" *[+-]?((\\d+\\.?\\d*)|(\\.\\d+))(e[+-]?\\d+)? *");
        return (regex_match(s,pattern));       
    }
};

int main(){
    string s;
    Solution sol;
    while(cin>>s){
        cout<<sol.isNumber(s)<<endl;
    }
    return 0;
}