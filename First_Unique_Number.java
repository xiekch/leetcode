import java.util.LinkedList;
import java.util.Queue;
import java.util.HashMap;

// You have a queue of integers, you need to retrieve the first unique integer in the queue.
class FirstUnique {
    private Queue<Integer> qu;
    private HashMap<Integer, Integer> map;

    public FirstUnique(int[] nums) {
        qu = new LinkedList<>();
        map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            add(nums[i]);
        }
    }

    public int showFirstUnique() {
        if (qu.isEmpty())
            return -1;
        return qu.peek();
    }

    public void add(int value) {
        int count = map.getOrDefault(value, 0);
        count++;
        map.put(value, count);
        if (count == 1)
            qu.offer(value);
        else if (count == 2)
            qu.remove(value);
    }
}

/**
 * Your FirstUnique object will be instantiated and called as such: FirstUnique
 * obj = new FirstUnique(nums); int param_1 = obj.showFirstUnique();
 * obj.add(value);
 */

public class First_Unique_Number {
    public static void main(String[] args) {
        int[] nums = { 7, 7, 7, 7, 7, 7 };
        FirstUnique firstUnique = new FirstUnique(nums);
        System.out.println(firstUnique.showFirstUnique()); // return -1
        firstUnique.add(7); // the queue is now [7,7,7,7,7,7,7]
        firstUnique.add(3); // the queue is now [7,7,7,7,7,7,7,3]
        firstUnique.add(3); // the queue is now [7,7,7,7,7,7,7,3,3]
        firstUnique.add(7); // the queue is now [7,7,7,7,7,7,7,3,3,7]
        firstUnique.add(17); // the queue is now [7,7,7,7,7,7,7,3,3,7,17]
        System.out.println(firstUnique.showFirstUnique()); // return 17
    }
}