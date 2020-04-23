import java.util.ArrayList;

class Solution {
    public int subarraySum(int[] nums, int k) {
        if (nums.length == 0)
            return 0;
        int ans = 0;
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i : nums) {
            arr.add(0);
            for (int j = 0; j < arr.size(); j++) {
                arr.set(j, arr.get(j) + i);
                if (arr.get(j) == k)
                    ans++;
            }
        }

        return ans;
    }
}

class Subarray_Sum_Equals_K_v1 {
    public static void main(String[] args) {
        // Scanner scanner=new Scanner(System.in);
        Solution sol=new Solution();
        int [][]testset={{1,1,1},{1,-1}};
        int []testsetK={2,0};

        for (int i=0;i<testset.length;i++){
            System.out.println(sol.subarraySum(testset[i], testsetK[i]));
        }
    }
}