import java.util.*;

class Solution {
    public void solve() {
        int n, s;
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        s = scanner.nextInt();
        ArrayList<Integer> nums = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            nums.add(scanner.nextInt());
        }

        int cur = 0;
        int left = 0, right = 0;
        int longest = 0;
        for (right = 0; right < n;) {
            cur += nums.get(right);
            right++;
            while (cur > s) {
                cur -= nums.get(left);
                left++;
            }
            longest = Integer.max(longest, right - left);
        }
        System.out.println(longest);
    }
}

public class LongestDistanceLessThanS {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solve();
    }
}
