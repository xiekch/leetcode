import java.util.PriorityQueue;

// Median is the middle value in an ordered integer list. 
// If the size of the list is even, there is no middle value.
//  So the median is the mean of the two middle value.
class MedianFinder {
    // left part, max-heap
    public PriorityQueue<Integer> left;
    // right part, min-heap
    public PriorityQueue<Integer> right;

    public MedianFinder() {
        left = new PriorityQueue<>((a, b) -> {
            return b - a;
        });
        right = new PriorityQueue<>();
    }

    public void addNum(int num) {
        if (left.size() == 0 || num <= left.peek()) {
            left.add(num);
        } else {
            right.add(num);
        }
        if (left.size() > right.size() + 1) {
            right.add(left.poll());
        } else if (right.size() > left.size() + 1) {
            left.add(right.poll());
        }
    }

    public double findMedian() {
        if (left.size() == right.size()) {
            return (double) (left.peek() + right.peek()) / 2;
        } else
            return (left.size() > right.size()) ? left.peek() : right.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder(); obj.addNum(num); double param_2 =
 * obj.findMedian();
 */

public class Find_Median_from_Data_Stream {
    public static void main(String[] args) {
        MedianFinder md = new MedianFinder();
        md.addNum(2);
        md.addNum(3);
        System.out.println(md.findMedian());
        md.addNum(4);
        md.addNum(5);
        md.addNum(6);
        System.out.println(md.findMedian());
        System.out.println(md.left.peek());
        System.out.println(md.right.peek());
    }
}