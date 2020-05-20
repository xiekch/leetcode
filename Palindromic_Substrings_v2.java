// Manacher's Algorithm
class Solution {
    public int countSubstrings(String s) {
        int res = 0;
        StringBuilder sb = new StringBuilder("$#");
        for (char ch : s.toCharArray()) {
            sb.append(ch);
            sb.append('#');
        }
        sb.append('#');
        s = sb.toString();

        int[] radius = new int[s.length()];
        int maxRight = 1, center = 1;
        for (int i = 1; i < s.length() - 1; i++) {
            if (maxRight > i)
                radius[i] = Integer.min(maxRight - i, radius[2 * center - i]);
            while (s.charAt(i - radius[i] - 1) == s.charAt(i + radius[i] + 1)) {
                radius[i]++;
            }
            if (radius[i] + i > maxRight) {
                maxRight = radius[i] + i;
                center = i;
            }
            res += (radius[i] + 1) / 2;
        }

        return res;
    }
}

public class Palindromic_Substrings_v2 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] testset = { "abc", "aaa", "aba", "baad" };
        for (String s : testset) {
            System.out.println(solution.countSubstrings(s));
        }
    }
}