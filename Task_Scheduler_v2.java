
// n means between two same tasks, there must be at least n intervals 
//  that CPU are doing different tasks or just be idle.
// You need to return the least number of intervals the CPU will take to finish all the given tasks.
// https://leetcode.com/problems/task-scheduler/solution/
// the interval consists of tasks.length and the idle slots
// idle slots = maxCount*instances - Integer.min(count,instances)

class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];
        for (char ch : tasks) {
            count[ch - 'A']++;
        }
        int maxCount = 0;
        for (int i : count) {
            maxCount = Integer.max(maxCount, i);
        }
        int instances = maxCount - 1, slots = instances * (n + 1);
        for (int i : count) {
            // every kind of tasks can only take one slot in one instance
            slots -= Integer.min(i, instances);
        }
        // idle slots can be less than 0 in the case of AABBCC 1
        return tasks.length + Integer.max(0, slots);
    }
}

public class Task_Scheduler_v2 {
    public static void main(String[] args) {

        Solution solution = new Solution();
        char[][] testset = { { 'A', 'A', 'A', 'B', 'B', 'B' }, { 'A' }, { 'A', 'B', 'C', 'A', 'B', 'C' },
                { 'A', 'B', 'A', 'B', 'C', 'C' }, { 'A', 'A', 'A', 'B', 'B', 'B', 'C', 'C', 'C', 'D', 'D', 'D' } };
        int[] n = { 2, 2, 3, 1, 2 };
        for (int i = 0; i < testset.length; i++)
            System.out.println(solution.leastInterval(testset[i], n[i]));
    }
}