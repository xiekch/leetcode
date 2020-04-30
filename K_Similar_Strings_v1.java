import java.util.HashSet;
import java.util.Queue;
import java.util.LinkedList;

// TLE
class Solution {
    public int kSimilarity(String A, String B) {
        HashSet<String> set = new HashSet<>();
        Queue<String> qu = new LinkedList<>();
        StringBuilder sb;
        if (A == null || B == null || A.length() == 0 || B.length() == 0 || A.equals(B))
            return 0;
        qu.add(A);
        set.add(A);
        int level = 0;
        while (!qu.isEmpty()) {
            int levelNum = qu.size();
            while (levelNum-- != 0) {
                String str = qu.poll();
                if (str.equals(B)) {
                    return level;
                }
                for (int i = 0; i < str.length(); i++) {
                    for (int j = i + 1; j < str.length(); j++) {
                        sb = new StringBuilder(str);
                        sb.setCharAt(i, str.charAt(j));
                        sb.setCharAt(j, str.charAt(i));
                        String temp = sb.toString();
                        // System.out.printf("%s ", temp);
                        if (set.contains(temp))
                            continue;
                        else {
                            set.add(temp);
                            qu.add(temp);
                        }
                    }
                }
            }
            // System.out.println();
            level++;
        }
        return level;
    }
}

public class K_Similar_Strings_v1 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] A = { "ab", "abc", "abac", "aabc", "abccaacceecdeea" };
        String[] B = { "ba", "bca", "baca", "abca", "bcaacceeccdeaae" };
        for (int i = 0; i < A.length; i++)
            System.out.println(solution.kSimilarity(A[i], B[i]));
    }
}