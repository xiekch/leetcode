import java.util.HashMap;

class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) {
            return "0";
        }

        String result = "";
        long nume = numerator;
        long denom = denominator;
        if (nume < 0 && denom < 0) {
            nume = -nume;
            denom = -denom;
        } else if (nume < 0) {
            nume = -nume;
            result += "-";
        } else if (denom < 0) {
            denom = -denom;
            result += "-";
        }

        HashMap<Long, Integer> remainders = new HashMap<>();
        for (int i = 0;; i++) {
            long quotient = nume / denom;
            result += String.valueOf(quotient);
            long remainder = nume % denom;
            nume = remainder * 10;
            // System.out.println(numerator);
            if (remainder == 0) {
                break;
            }
            if (!remainders.containsKey(remainder)) {
                remainders.put(remainder, result.length());
            } else {
                int index = remainders.get(remainder);
                // System.out.println(index);
                result = result.substring(0, index + 1) + "(" + result.substring(index + 1) + ")";
                break;
            }

            if (i == 0 && remainder != 0) {
                result += '.';
            }
        }
        return result;
    }
}

public class Fraction_to_Recurring_Decimal {

    public static void main(String[] args) {
        int[][] testCases = { { 50, 5 }, { 1, 200 }, { -1, 2 }, { -1, 8 }, { 100, 7 }, { 1200, 11 },
                { -1, -2147483648 } };
        Solution sol = new Solution();
        for (int[] testCase : testCases) {
            System.out.println(sol.fractionToDecimal(testCase[0], testCase[1]));
        }
    }
}