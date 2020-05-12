import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

// 22ms
class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        HashMap<Integer, Integer> indices = new HashMap<>();
        ArrayList<int[]> count = new ArrayList<>();
        for (int i : nums) {
            if (!indices.containsKey(i)) {
                indices.put(i, count.size());
                count.add(new int[] { i, 0 });
            }
            count.get(indices.get(i))[1]++;
        }

        count.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return b[1] - a[1];
            }
        });

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = count.get(i)[0];
        }
        return res;
    }
}

public class Top_K_Frequent_Elements_v1 {
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