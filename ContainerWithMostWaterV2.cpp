class Solution {
  public:
    int maxArea(vector<int> &height) {
        int result = 0;
        int high = height.size() - 1, low = 0;
        while (low < high) {
            result = max(result, min(height[low], height[high]) * (high - low));
            if (height[low] < height[high]) {
                low++;
            } else
                high--;
        }

        return result;
    }
};