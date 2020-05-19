import java.util.Stack;

// monotonic stack
class Solution {
    public int[] dailyTemperatures(int[] T) {
        if (T == null || T.length == 0) {
            return new int[0];
        }
        Stack<Integer> st = new Stack<>();
        int[] res = new int[T.length];
        for (int i = T.length - 1; i >= 0; i--) {
            while (!st.isEmpty() && T[st.peek()] <= T[i]) {
                st.pop();
            }
            res[i] = st.isEmpty() ? 0 : st.peek() - i;
            st.add(i);
        }

        return res;
    }
}

public class Daily_Temperatures_v2 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] testset = { {}, { 73, 74, 75, 71, 69, 72, 76, 73 } };
        for (int[] T : testset) {
            int[] res = solution.dailyTemperatures(T);
            for (int i : res) {
                System.out.printf("%d ", i);
            }
            System.out.println();
        }
    }
}