import java.util.*;

class Solution {
    ArrayList<Integer> seats = new ArrayList<>();
    int row, column;

    public void solve() {
        Scanner scanner = new Scanner(System.in);
        row = scanner.nextInt();
        column = scanner.nextInt();
        if (row <= 0 || column <= 0) {
            scanner.close();
            return;
        }
        for (int i = 0; i < column * row; i++) {
            seats.add(scanner.nextInt());
        }
        scanner.close();

        int left = 0;
        int right = column - 1;
        int top = 0;
        int bottom = row - 1;
        int num = column * row;
        while (num > 0) {
            for (int i = top; num > 0 && i <= bottom; i++) {
                print(i, left);
                num--;
            }
            left++;
            for (int i = left; num > 0 && i <= right; i++) {
                print(bottom, i);
                num--;
            }
            bottom--;
            for (int i = bottom; num > 0 && i >= top; i--) {
                print(i, right);
                num--;
            }
            right--;
            for (int i = right; num > 0 && i >= left; i--) {
                print(top, i);
                num--;
            }
            top++;
        }
        System.out.println();
    }

    private void print(int r, int c) {
        if (r == 0 && c == 0) {
            System.out.printf("%d", seats.get(r * column + c));
        } else {
            System.out.printf(" %d", seats.get(r * column + c));
        }
    }

}

public class SpinMatrix {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solve();
    }
}

// 3 3
// 1 2 3
// 4 5 6
// 7 8 9

// 1 5
// 1 2 3 4 5

// 5 1
// 1 2 3 4
