
// For every numbers i in the range 0 ≤ i ≤ num calculate the number of 
//  1's in their binary representation and return them as an array.
class Solution {
    public int[] countBits(int num) {
        int[] res = new int[num + 1];
        res[0] = 0;
        int fac = 1;
        for (int i = 1; i <= num; i++) {
            if (2 * fac <= i)
                fac = 2 * fac;
            res[i] = res[i - fac] + 1;
        }

        return res;
    }
}

public class Counting_Bits_v1 {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] res = solution.countBits(100);
        for (int i : res) {
            System.out.printf("%d ", i);
        }
        System.out.println();
    }
}