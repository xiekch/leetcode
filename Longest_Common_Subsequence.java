// similar to Edit Distance
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        if (text1.length() == 0 || text2.length() == 0)
            return 0;
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];

        for (int i = 0; i < text1.length(); i++) {
            for (int j = 0; j < text2.length(); j++) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                } else {
                    dp[i + 1][j + 1] = Integer.max(dp[i][j + 1], dp[i + 1][j]);
                }
            }
        }

        // for (int i = 0; i <= text1.length(); i++) {
        // for (int j = 0; j <= text2.length(); j++) {
        // System.out.printf("%d ", dp[i][j]);
        // }
        // System.out.println();
        // }

        return dp[text1.length()][text2.length()];
    }
}

public class Longest_Common_Subsequence {
    public static void main(String[] args) {
        Solution sol = new Solution();
        String[][] testset = { { "acaeda", "abdaf" }, { "abcde", "ace" }, { "abc", "def" } };
        for (String[] test : testset)
            System.out.println(sol.longestCommonSubsequence(test[0], test[1]));
    }
}