import java.util.ArrayList;
import java.util.Arrays;

// https://leetcode.com/problems/queue-reconstruction-by-height/discuss/89345/Easy-concept-with-PythonC%2B%2BJava-Solution
class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> {
            return a[0] == b[0] ? a[1] - b[1] : b[0] - a[0];
        });
        ArrayList<int[]> res = new ArrayList<>();
        for (int[] p : people) {
            res.add(p[1], p);
        }
        return res.toArray(new int[people.length][]);
    }
}

public class Queue_Reconstruction_by_Height {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][][] testset = { { { 7, 0 }, { 4, 4 }, { 7, 1 }, { 5, 0 }, { 6, 1 }, { 5, 2 } }, {} };
        for (int[][] people : testset) {
            int[][] res = solution.reconstructQueue(people);
            for (int[] p : res) {
                System.out.printf("%d %d\n", p[0], p[1]);
            }
        }
    }
}