import java.util.Arrays;
import java.util.PriorityQueue;

// https://leetcode.com/problems/maximum-number-of-events-that-can-be-attended/discuss/510263/JavaC%2B%2BPython-Priority-Queue
class Solution {
    public int maxEvents(int[][] events) {
        if (events == null || events.length == 0)
            return 0;
        Arrays.sort(events, (a, b) -> {
            return a[0] - b[0];
        });

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int i = 0, count = 0;
        for (int d = 0; d <= 100000; d++) {
            while (!pq.isEmpty() && pq.peek() < d)
                pq.poll();
            while (i < events.length && events[i][0] == d) {
                pq.offer(events[i][1]);
                i++;
            }
            if (!pq.isEmpty()) {
                pq.poll();
                count++;
            }
        }

        return count;
    }
}

// 3 4 4 1 7 2 5 5
public class Maximum_Number_of_Events_That_Can_Be_Attended_v1 {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[][][] testset = { { { 1, 2 }, { 2, 3 }, { 3, 4 } }, { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 1, 2 } },
                { { 1, 4 }, { 4, 4 }, { 2, 2 }, { 3, 4 }, { 1, 1 } }, { { 1, 100000 } },
                { { 1, 1 }, { 1, 2 }, { 1, 3 }, { 1, 4 }, { 1, 5 }, { 1, 6 }, { 1, 7 } },
                { { 1, 2 }, { 1, 2 }, { 1, 2 } }, { { 1, 2 }, { 1, 2 }, { 3, 3 }, { 1, 5 }, { 1, 5 } },
                { { 1, 5 }, { 1, 5 }, { 1, 5 }, { 2, 3 }, { 2, 3 } } };
        for (int[][] events : testset)
            System.out.println(solution.maxEvents(events));
    }
}