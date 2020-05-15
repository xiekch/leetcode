import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

// n means between two same tasks, there must be at least n intervals 
//  that CPU are doing different tasks or just be idle.
// You need to return the least number of intervals the CPU will take to finish all the given tasks.
class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> count = new HashMap<>();
        for (char ch : tasks) {
            count.put(ch, count.getOrDefault(ch, 0) + 1);
        }
        int time = 0, sum = tasks.length;
        Integer[] array = count.values().toArray(new Integer[0]);
        Arrays.sort(array, Collections.reverseOrder());
        while (true) {
            int k = n + 1;
            for (int i = 0; k > 0 && i < array.length; i++) {
                if (array[i] > 0) {
                    sum--;
                    k--;
                    array[i]--;
                    time++;
                }
            }
            if (sum == 0)
                break;
            else
                time += k;
            Arrays.sort(array, Collections.reverseOrder());
        }
        return time;
    }
}

public class Task_Scheduler_v1 {
    public static void main(String[] args) {

        Solution solution = new Solution();
        char[][] testset = { { 'A', 'A', 'A', 'B', 'B', 'B' }, { 'A' }, { 'A', 'B', 'C', 'A', 'B', 'C' },
                { 'A', 'B', 'A', 'B', 'C', 'C' }, { 'A', 'A', 'A', 'B', 'B', 'B', 'C', 'C', 'C', 'D', 'D', 'D' } };
        int[] n = { 2, 2, 3, 1, 2 };
        for (int i = 0; i < testset.length; i++)
            System.out.println(solution.leastInterval(testset[i], n[i]));
    }
}