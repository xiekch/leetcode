import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        if (nums == null)
            return ans;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            if (!map.containsKey(i))
                map.put(i, 1);
            else
                map.put(i, map.get(i) + 1);
        }

        for (int i : map.keySet()) {
            if (map.get(i) > nums.length / 3) {
                ans.add(i);
            }
        }
        return ans;
    }
}

class Majority_Element_II_v1 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] testset = { { 3, 2, 3 }, { 1, 1, 1, 3, 3, 2, 2, 2 } };
        for (int[] test : testset)
            System.out.println(sol.majorityElement(test));
    }
}