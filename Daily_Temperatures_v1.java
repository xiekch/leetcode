import java.util.Stack;

// monotonic stack
class Solution {
    public int[] dailyTemperatures(int[] T) {
        if (T == null || T.length == 0) {
            return new int[0];
        }
        Stack<Integer> st = new Stack<>();
        int[] res = new int[T.length];
        for (int i = 0; i < T.length; i++) {
            while (!st.isEmpty() && T[st.peek()] < T[i]) {
                res[st.peek()] = i - st.peek();
                st.pop();
            }
            st.add(i);
        }

        while (!st.isEmpty()) {
            res[st.pop()] = 0;
        }

        return res;
    }
}

public class Daily_Temperatures_v1 {
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