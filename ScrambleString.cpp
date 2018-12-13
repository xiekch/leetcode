#include <string>
using namespace std;

class Solution
{
  public:
    bool isScramble(string s1, string s2)
    {
        if (s1 == s2)
            return true;
        if (s1.length()!= s2.length())
            return false;
        int len = s1.length();
        
        int count[26] = {0};
        for(int i=0; i<len; i++)
        {
            count[s1[i]-'a']++;
            count[s2[i]-'a']--;
        }
        
        for(int i=0; i<26; i++)
        {
            if(count[i]!=0)
                return false;
        }
        
        for (int i = 1; i < len; i++)
        {
            if (isScramble(s1.substr(0, i), s2.substr(0, i)) && isScramble(s1.substr(i, len), s2.substr(i, len)))
                return true;
            if (isScramble(s1.substr(0, i), s2.substr(len-i, len)) && isScramble(s1.substr(i, len), s2.substr(0, len-i)))
                return true;
        }
        return false;
    }
};