import java.util.HashMap;

class Solution {
    public int subarraySum(int[] nums, int k) {
        if (nums.length == 0)
            return 0;
        int ans = 0, sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        // very important
        map.put(0, 1);
        for (int i : nums) {
            sum += i;
            if (map.containsKey(sum - k))
                ans += map.get(sum - k);
            if (map.containsKey(sum)) {
                map.put(sum, map.get(sum) + 1);
            } else {
                map.put(sum, 1);
            }
        }

        return ans;
    }
}

class Subarray_Sum_Equals_K_v2 {
    public static void main(String[] args) {
        // Scanner scanner=new Scanner(System.in);
        Solution sol = new Solution();
        int[][] testset = { { 1, 1, 1 }, { 1, -1 } };
        int[] testsetK = { 2, 0 };

        for (int i = 0; i < testset.length; i++) {
            System.out.println(sol.subarraySum(testset[i], testsetK[i]));
        }
    }
}