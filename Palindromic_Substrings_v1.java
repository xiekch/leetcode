class Solution {
    public int countSubstrings(String s) {
        int res = 0;
        StringBuilder sb = new StringBuilder("$");
        for (char ch : s.toCharArray()) {
            sb.append(ch);
            sb.append('#');
        }
        sb.append('#');
        s = sb.toString();
        for (int i = 1; i < s.length() - 1; i++) {
            for (int r = 0; s.charAt(i - r) == s.charAt(i + r); r++) {
                if (s.charAt(i - r) != '#')
                    res++;
            }
        }

        return res;
    }
}

public class Palindromic_Substrings_v1 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] testset = { "abc", "aaa", "aba", "baad" };
        for (String s : testset) {
            System.out.println(solution.countSubstrings(s));
        }
    }
}