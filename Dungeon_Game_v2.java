import java.util.Arrays;

// DP
// https://leetcode.com/problems/dungeon-game/discuss/745340/post-Dedicated-to-beginners-of-DP-or-have-no-clue-how-to-start
class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length, n = dungeon[0].length;
        int hp[][] = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++)
            Arrays.fill(hp[i], Integer.MAX_VALUE);
        hp[m][n - 1] = 1;
        hp[m - 1][n] = 1;
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int need = Integer.min(hp[i + 1][j], hp[i][j + 1]) - dungeon[i][j];
                hp[i][j] = need <= 0 ? 1 : need;
            }
        }
        // for (int i = 0; i <= m; i++) {
        //     for (int j = 0; j <= n; j++) {
        //         System.out.printf("%15d", hp[i][j]);
        //     }
        //     System.out.println();
        // }
        return hp[0][0];
    }
}

public class Dungeon_Game_v2 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][][] testset = { { { -2, -3, -3 }, { -5, -10, 1 }, { 10, 30, -5 } }, { { 0 } },
                { { 1, -3, 3 }, { 0, -2, 0 }, { -3, -3, -3 } }, { { 0, -2, 0 }, { -3, 0, 0 }, { 10, 0, -5 } },
                { {  0, 10 }, {  0, -3 }, {  -2, 0 } } };
        for (int[][] dungeon : testset) {
            System.out.println(solution.calculateMinimumHP(dungeon));
        }
    }
}