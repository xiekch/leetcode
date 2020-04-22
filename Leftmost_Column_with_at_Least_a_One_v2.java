import java.util.List;

/**
 * // This is the BinaryMatrix's API interface. // You should not implement it,
 * or speculate about its implementation
 */
interface BinaryMatrix {
    public int get(int x, int y);

    public List<Integer> dimensions();
};

// pointer
class Solution {
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        List<Integer> dim = binaryMatrix.dimensions();
        int m = dim.get(0), n = dim.get(1);
        int ans = n;
        for (int i = 0; i < m; i++) {
            while (ans > 0 && binaryMatrix.get(i, ans - 1) == 1) {
                ans--;
            }
        }

        return ans == n ? -1 : ans;
    }
}