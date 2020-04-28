class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0)
            return 0;
        int[][] dp = new int[matrix.length + 1][matrix[0].length + 1];
        int maxLen = 0;
        for (int i = 1; i <= matrix.length; i++) {
            for (int j = 1; j <= matrix[0].length; j++) {
                if (matrix[i - 1][j - 1] == '1') {
                    dp[i][j] = Integer.min(dp[i - 1][j - 1], Integer.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                    maxLen = Integer.max(maxLen, dp[i][j]);
                }
            }
        }

        return maxLen * maxLen;
    }
}

public class Maximal_Square {
    public static void main(String[] args) {
        Solution solution = new Solution();
        char[][] matrix = { { '1', '0', '1', '0', '0' }, { '1', '0', '1', '1', '1' }, { '1', '1', '1', '1', '1' },
                { '1', '0', '0', '1', '0' } };
        System.out.println(solution.maximalSquare(matrix));
    }
}