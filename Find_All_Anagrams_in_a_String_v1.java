import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.
class Solution {
    private boolean check(HashMap<Character, Integer> set, HashMap<Character, Integer> word) {
        for (char ch : set.keySet()) {
            // very important: equals not ==
            if (!set.get(ch).equals(word.getOrDefault(ch, 0))) {
                return false;
            }
        }
        return true;
    }

    public List<Integer> findAnagrams(String s, String p) {
        ArrayList<Integer> res = new ArrayList<>();
        if (s == null || p == null || s.length() == 0 || p.length() == 0 || p.length() > s.length())
            return res;
        int start = 0, end = 0;
        HashMap<Character, Integer> set = new HashMap<>(), word = new HashMap<>();

        for (int i = 0; i < p.length(); i++) {
            set.put(p.charAt(i), set.getOrDefault(p.charAt(i), 0) + 1);
        }

        while (end < s.length()) {
            if (!set.containsKey(s.charAt(end))) {
                // System.out.printf(" %d\n", end);
                word.clear();
                start = end = end + 1;
                continue;
            }

            word.put(s.charAt(end), word.getOrDefault(s.charAt(end), 0) + 1);
            if (end - start + 1 > p.length()) {
                word.put(s.charAt(start), word.getOrDefault(s.charAt(start), 1) - 1);
                start++;
            }
            if (end - start + 1 == p.length()) {
                // System.out.println(end);
                if (check(set, word))
                    res.add(start);
            }
            end++;
        }

        return res;
    }
}

public class Find_All_Anagrams_in_a_String_v1 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[][] testset = { { "", "a" }, { "cbaebabacd", "abc" }, { "abab", "ab" },
                { "aaaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaaa", "aaaaaaaaaaaaaaaaaaa" } };
        for (String[] test : testset) {
            List<Integer> res = solution.findAnagrams(test[0], test[1]);
            res.forEach(v -> System.out.printf("%d ", v));
            System.out.println();
        }
    }
}