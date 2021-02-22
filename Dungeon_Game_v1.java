import java.util.Comparator;
import java.util.PriorityQueue;

// search
// TLE https://leetcode.com/submissions/detail/459083567/testcase/
class Solution {
    static class Node {
        public int point;
        public int x, y;
        public int minHealth;

        public Node(int x, int y, int point, int minHealth) {
            this.x = x;
            this.y = y;
            this.point = point;
            this.minHealth = minHealth;
        }
    }

    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length, n = dungeon[0].length;
        PriorityQueue<Node> maxheap = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o2.minHealth - o1.minHealth;
            }
        });
        Node[][] visited = new Node[m][n];
        int[][] delta = { { 1, 0 }, { 0, 1 } };
        maxheap.add(new Node(0, 0, dungeon[0][0], dungeon[0][0]));
        while (!maxheap.isEmpty()) {
            Node node = maxheap.poll();
            // System.out.printf("%d %d %d %d\n", node.x, node.y, node.point, node.minHealth);
            if (node.x == m - 1 && node.y == n - 1) {
                if (node.minHealth < 0)
                    return -node.minHealth + 1;
                else
                    return 1;
            }
            // prune
            Node visitedNode = visited[node.x][node.y];
            if (visitedNode != null && visitedNode.point > node.point && visitedNode.minHealth > node.minHealth)
                continue;
            visited[node.x][node.y] = node;
            for (int[] d : delta) {
                int nx = node.x + d[0], ny = node.y + d[1];
                if (nx < m && ny < n) {
                    maxheap.add(new Node(nx, ny, node.point + dungeon[nx][ny],
                            Integer.min(node.minHealth, node.point + dungeon[nx][ny])));
                }
            }
        }
        return 1;
    }
}

public class Dungeon_Game_v1 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][][] testset = { { { -2, -3, -3 }, { -5, -10, 1 }, { 10, 30, -5 } }, { { 0 } },
                { { 1, -3, 3 }, { 0, -2, 0 }, { -3, -3, -3 } } };
        for (int[][] dungeon : testset) {
            System.out.println(solution.calculateMinimumHP(dungeon));
        }
    }
}