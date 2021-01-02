import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution {
    public List<Integer> partitionLabels(String S) {
        HashMap<Character, Integer> lastIndex = new HashMap<>();
        for (int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);
            lastIndex.put(ch, i);
        }
        ArrayList<Integer> result = new ArrayList<>();
        int len = 1;
        for (int i = 0; i < S.length(); i++) {
            int right = lastIndex.get(S.charAt(i));
            while (i < right) {
                i++;
                len++;
                right = Integer.max(right, lastIndex.get(S.charAt(i)));
            }
            result.add(len);
            len = 1;
        }
        return result;
    }
}

public class Partition_Labels {
    public static void main(String[] args) {
        String[] testCases = { "ababcbacadefegdehijhklij" };
        Solution solution = new Solution();
        for (String S : testCases) {
            System.out.println(solution.partitionLabels(S));
        }
    }
}