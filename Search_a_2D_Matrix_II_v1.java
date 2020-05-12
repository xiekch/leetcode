import java.util.Arrays;

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return false;
        for (int i = 0; i < matrix.length && matrix[i][0] <= target; i++) {
            int index = Arrays.binarySearch(matrix[i], target);
            if (index >= 0)
                return true;
        }
        return false;
    }
}

//[[1, 4, 7, 11, 15],
// [2, 5, 8, 12, 19],
// [3, 6, 9, 16, 22],
// [10, 13, 14, 17, 24],
// [18, 21, 23, 26, 30]]
// Given target = 5, return true.
// Given target = 20, return false.
public class Search_a_2D_Matrix_II_v1 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] matrix = { { 1, 4, 7, 11, 15 }, { 2, 5, 8, 12, 19 }, { 3, 6, 9, 16, 22 }, { 10, 13, 14, 17, 24 },
                { 18, 21, 23, 26, 30 } };
        int targets[] = { 5, 22, 30, 20, 31, 0 };
        for (int target : targets) {
            System.out.println(solution.searchMatrix(matrix, target));
        }
    }
}