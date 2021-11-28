import java.util.Arrays;

/**
 * 利用前面已匹配的子串和后面已匹配的子串相等的信息来跳过前面已匹配的子串
 * j的回溯只会影响搜索主循环次数的上下界（[n, 2n]）
 * 往前进的次数只有n次，往后退的总数不超过往前进的总数
 * 时间复杂度 O(m+n)
 */
public class KMP {
    public static int kmp(String a, String b) {
        int[] back = new int[b.length()];
        back[0] = -1;
        for (int i = 1, k = -1; i < b.length();) {
            if (k == -1 || b.charAt(i) == b.charAt(k)) {
                k++;
                // == 的传递性
                // b[i] == b[k] == b[back[k]] 则
                // back[i] = back[k] = back[back[k]]
                if (b.charAt(i) == b.charAt(k)) {
                    back[i] = back[k];
                } else {
                    back[i] = k;
                }
                i++;
            } else {
                k = back[k];
            }
        }
        System.out.println(Arrays.toString(back));

        for (int i = 0, j = 0;;) {
            while (i < a.length() && j < b.length() && a.charAt(i) == b.charAt(j)) {
                i++;
                j++;
            }
            if (j >= b.length())
                return i - b.length();
            if (i >= a.length())
                return -1;

            if (back[j] == -1) {
                j = 0;
                i++;
            } else {
                j = back[j];
            }
        }
    }

    public static void main(String[] args) {
        String[][] testCases = { { "ssssssssa", "ssssa" },
                { "AAAAAABAAAAAABAAAAAAABAAAAAAA", "AAAAAAA" } };
        for (String[] testCase : testCases)
            System.out.println(kmp(testCase[0], testCase[1]));
    }
}