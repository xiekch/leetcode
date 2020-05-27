import java.util.ArrayList;

// S -> AS | eps
// A -> num[S]|str
class Solution {
    private ArrayList<String> tokens;

    // break s into tokens
    private void seperateTokens(String s) {
        tokens = new ArrayList<>();
        for (int i = 0; i < s.length();) {
            if (s.charAt(i) == '[' || s.charAt(i) == ']') {
                tokens.add(s.substring(i, i + 1));
                i++;
            } else if (Character.isDigit(s.charAt(i))) {
                int j = i;
                while (j < s.length() && Character.isDigit(s.charAt(j))) {
                    j++;
                }
                tokens.add(s.substring(i, j));
                i = j;
            } else if (Character.isLetter((s.charAt(i)))) {
                int j = i;
                while (j < s.length() && Character.isLetter((s.charAt(j)))) {
                    j++;
                }
                tokens.add(s.substring(i, j));
                i = j;
            }
        }
    }

    // find the end index of A
    private int seperateA(int beginIndex, int endIndex) {
        if (tokens.isEmpty() || beginIndex >= tokens.size() || beginIndex >= endIndex)
            return endIndex;

        int i = beginIndex;
        // str
        if (Character.isLetter(tokens.get(i).charAt(0))) {
            return i + 1;
        }
        int count = 0;
        // num[S]
        for (i++; i < endIndex; i++) {
            if (tokens.get(i).equals("["))
                count++;
            else if (tokens.get(i).equals("]"))
                count--;
            if (count == 0)
                break;
        }
        return i + 1;
    }

    // decode A
    private String decodeA(int beginIndex, int endIndex) {
        if (beginIndex >= endIndex)
            return "";
        StringBuilder sb = new StringBuilder();
        int i = beginIndex;
        if (Character.isDigit(tokens.get(i).charAt(0))) {
            int count = Integer.valueOf(tokens.get(i));
            i += 2;
            String sub = decodeS(i, endIndex - 1);
            for (int j = 0; j < count; j++) {
                sb.append(sub);
            }
            return sb.toString();

        } else {
            return tokens.get(i);
        }
    }

    // decode S
    private String decodeS(int startIndex, int endIndex) {
        if (tokens.isEmpty() || startIndex >= endIndex)
            return "";
        int seperate = seperateA(startIndex, endIndex);
        return decodeA(startIndex, seperate) + decodeS(seperate, endIndex);
    }

    public String decodeString(String s) {
        seperateTokens(s);
        return decodeS(0, tokens.size());
    }
}

// S -> AS | eps
// A -> num[S]|str

// s = "3[a]2[bc]", return "aaabcbc".
// s = "3[a2[c]]", return "accaccacc".
// s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
public class Decode_String {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] testset = { "", "abc", "abc3[a]3[f]", "3[a]2[b4[F]c]", "3[a]2[bc]", "3[a2[c]]", "2[abc]3[cd]ef",
                "2[2[e]]", "3[z]2[2[y]pq4[2[jk]e1[f]]]ef" };
        for (String s : testset) {
            System.out.println(solution.decodeString(s));
        }
    }
}