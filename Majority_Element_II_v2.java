import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        if (nums == null)
            return ans;
        int num1 = 0, num2 = 1, count1 = 0, count2 = 0;
        for (int i : nums) {
            if (i == num1) {
                count1++;
            } else if (i == num2) {
                count2++;
            } else if (count1 == 0) {
                num1 = i;
                count1++;
            } else if (count2 == 0) {
                num2 = i;
                count2++;
            } else {
                count1--;
                count2--;
            }
        }

        count1 = count2 = 0;
        for (int i : nums) {
            if (i == num1)
                count1++;
            else if (i == num2)
                count2++;
        }
        if (count1 > nums.length / 3)
            ans.add(num1);
        if (count2 > nums.length / 3)
            ans.add(num2);
        return ans;
    }
}

class Majority_Element_II_v2 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] testset = { { 3, 2, 3 }, { 1, 1, 1, 3, 3, 2, 2, 2 } };
        for (int[] test : testset)
            System.out.println(sol.majorityElement(test));
    }
}