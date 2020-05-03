
class Solution {

    public int findKthLargest(int[] nums, int k) {
        k = nums.length - k;
        int low = 0, high = nums.length - 1;
        while (low < high) {
            int mid = partition(nums, low, high);
            if (mid < k) {
                low = mid + 1;
            } else if (mid > k) {
                high = mid - 1;
            } else
                break;
        }

        return nums[k];
    }

    private int partition(int[] nums, int low, int high) {
        int pivot = nums[low];
        while (low < high) {
            while (low < high && nums[high] >= pivot) {
                high--;
            }
            nums[low]=nums[high];
            while (low < high && nums[low] < pivot) {
                low++;
            }
            nums[high]=nums[low];
        }
        nums[low]=pivot;

        return low;
    }

}

public class Kth_Largest_Element_in_an_Array_v2 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] testset = { { 3, 2, 1, 5, 6, 4 }, { 3, 2, 3, 1, 2, 4, 5, 5, 6 }, { 3, 1, 2, 4 } };
        int[] ks = { 2, 4, 2 };
        for (int i = 0; i < testset.length; i++) {
            System.out.println(solution.findKthLargest(testset[i], ks[i]));
        }
    }
}
