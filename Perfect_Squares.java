import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

// bfs or dp
class Solution {
    public int numSquares(int n) {
        ArrayList<Integer> squares = new ArrayList<>();
        if (n <= 0)
            return 0;
        for (int i = 1; i * i <= n; i++) {
            squares.add(i * i);
        }
        Queue<Integer> qu = new LinkedList<>();
        HashSet<Integer> set = new HashSet<>();
        qu.offer(0);
        set.add(0);
        int depth = 0;
        while (!qu.isEmpty()) {
            int size = qu.size();
            depth++;
            while (size-- != 0) {
                int node = qu.poll();
                for (int i = 0; i < squares.size(); i++) {
                    int v = node + squares.get(i);
                    if (v == n)
                        return depth;
                    if (v > n)
                        break;
                    if (!set.contains(v)) {
                        set.add(v);
                        qu.offer(v);
                    }
                }
            }
        }
        return depth;
    }
}

// 12 = 4 + 4 + 4 !(9+1+1+1)
// 13 = 4 + 9
public class Perfect_Squares {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] testset = { 1, 2, 12, 13, 11111 };
        for (int n : testset) {
            System.out.println(solution.numSquares(n));
        }
    }
}