import java.util.HashMap;
import java.util.PriorityQueue;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> count = new HashMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
            return count.get(b) - count.get(a);
        });
        for (int i : nums) {
            count.put(i, count.getOrDefault(i, 0) + 1);
        }
        for (int i : count.keySet()) {
            pq.add(i);
        }

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = pq.poll();
        }
        return res;
    }
}

public class Top_K_Frequent_Elements_v2 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] testset = { { 1, 1, 1, 2, 2, 3 }, { 1 }, { 2, 3, 3, 4, 5, 4, 3, 5 } };
        int[] ks = { 2, 1, 3 };
        for (int i = 0; i < testset.length; i++) {
            int[] topKFrequent = solution.topKFrequent(testset[i], ks[i]);
            for (int j : topKFrequent) {
                System.out.printf("%d ", j);
            }
            System.out.println();
        }

    }
}