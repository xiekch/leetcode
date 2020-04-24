
// find the longest matched prefix
class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        String mbinary = Integer.toBinaryString(m);
        String nbinary = Integer.toBinaryString(n);
        // System.out.println(nbinary);

        if (mbinary.length() < nbinary.length())
            return 0;
        StringBuilder sb=new StringBuilder(mbinary);
        int i = 0;
        while (i < mbinary.length()) {
            if (mbinary.charAt(i) == nbinary.charAt(i)) {
                i++;
            } else
                while(i<mbinary.length()){
                    sb.setCharAt(i, '0');
                    i++;
                }
        }
        return Integer.valueOf(sb.toString(), 2);
    }
}

public class Bitwise_AND_of_Numbers_Range_v1 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] testset = { { 5, 7 }, { 0, 2 }, { 10000, 1111111 }, { 20000, 2147483647 } };
        for (int[] test : testset)
            System.out.println(sol.rangeBitwiseAnd(test[0], test[1]));
    }
}