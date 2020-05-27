class Solution {
  public:
    int maxArea(vector<int> &height) {
        int result = 0, temp;
        for (int i = 0; i < height.size(); i++) {
            for (int j = i + 1; j < height.size(); j++) {
                temp = min(height[i], height[j]) * (j - i);
                if (temp > result)
                    result = temp;
            }
        }
        return result;
    }
};