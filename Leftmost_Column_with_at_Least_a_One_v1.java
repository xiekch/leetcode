import java.util.List;

/**
 * // This is the BinaryMatrix's API interface. // You should not implement it,
 * or speculate about its implementation
 */
interface BinaryMatrix {
    public int get(int x, int y);

    public List<Integer> dimensions();
};

class Solution {
    private int binarySearch(BinaryMatrix binaryMatrix, int row, int cols) {
        int low = 0, high = cols;
        while (low < high) {
            int mid = (low + high) / 2;
            if (binaryMatrix.get(row, mid) >= 1) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        int ans = Integer.MAX_VALUE;
        List<Integer> dim = binaryMatrix.dimensions();
        int m = dim.get(0), n = dim.get(1);
        for (int i = 0; i < m; i++) {
            ans = Integer.min(ans, binarySearch(binaryMatrix, i, n));
        }

        return ans == n ? -1 : ans;
    }
}