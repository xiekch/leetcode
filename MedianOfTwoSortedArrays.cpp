// https://www.cnblogs.com/grandyang/p/4465932.html
#include <vector>
using namespace std;

class Solution
{
  public:
    double findMedianSortedArrays(vector<int> &nums1, vector<int> &nums2)
    {
        int m = nums1.size(), n = nums2.size(), l = (m + n + 1) / 2, r = (m + n + 2) / 2;
        return (findKNum(nums1, 0, nums2, 0, l) + findKNum(nums1, 0, nums2, 0, r)) / 2.0;
    }

    int findKNum(vector<int> &nums1, int i, vector<int> &nums2, int j, int k)
    {
        if (i >= nums1.size())
            return nums2[j + k - 1];
        if (j >= nums2.size())
            return nums1[i + k - 1];
        if (k == 1)
            return min(nums1[i], nums2[j]);
        if ((i + k / 2 - 1) >= nums1.size())
            return findKNum(nums1, i, nums2, j + k / 2, k-k / 2);
        else if ((j + k / 2 - 1) >= nums2.size())
            return findKNum(nums1, i + k / 2, nums2, j, k-k / 2);
        else if ((nums1[i + k / 2 - 1] < nums2[j + k / 2 - 1]))
            return findKNum(nums1, i + k / 2, nums2, j, k-k / 2);
        else //if (((j + k / 2 - 1) < nums2.size() && nums2[j + k / 2 - 1] < nums1[i + k / 2 - 1]) || ((i + k / 2 - 1) > nums1.size()))
            return findKNum(nums1, i, nums2, j + k / 2, k-k / 2);
    }
};