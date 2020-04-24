
// find the longest matched prefix
class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        int i = 0;
        while (m != n) {
            m >>= 1;
            n >>= 1;
            i++;
        }
        return m << i;
    }
}

public class Bitwise_AND_of_Numbers_Range_v2 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] testset = { { 5, 7 }, { 0, 2 }, { 10000, 1111111 }, { 20000, 2147483647 } };
        for (int[] test : testset)
            System.out.println(sol.rangeBitwiseAnd(test[0], test[1]));
    }
}