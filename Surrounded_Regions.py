from typing import Tuple, Dict, List


class Solution:
    direction = [[0, 1], [1, 0], [-1, 0], [0, -1]]

    def solve(self, board: List[List[str]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        if len(board) == 0:
            return
        self.row = len(board)
        self.col = len(board[0])
        for i in range(self.row):
            if board[i][0] == "O":
                self.dfs(board, i, 0)
            if board[i][self.col-1] == "O":
                self.dfs(board, i, self.col-1)
        for j in range(self.col):
            if board[0][j] == "O":
                self.dfs(board, 0, j)
            if board[self.row-1][j] == "O":
                self.dfs(board, self.row-1, j)

        for i in range(self.row):
            for j in range(self.col):
                if board[i][j] == "O":
                    board[i][j] = "X"
                elif board[i][j] == "A":
                    board[i][j] = "O"

    def dfs(self, board: list[list[str]], i: int, j: int) -> None:
        stack: List[Tuple[int, int]] = []
        stack.append((i, j))
        while len(stack) != 0:
            i, j = stack.pop()
            board[i][j] = "A"
            for d in self.direction:
                newi = i + d[0]
                newj = j + d[1]
                if newi < self.row and newi >= 0 and newj < self.col and newj >= 0 and board[newi][newj] == "O":
                    stack.append((newi, newj))


if __name__ == '__main__':
    solution = Solution()
    testCases = [[["X", "X", "X", "X"], ["X", "O", "O", "X"],
                  ["X", "X", "O", "X"], ["X", "O", "X", "X"]],
                 [["X", "O", "X"]]]
    for testCase in testCases:
        solution.solve(testCase)
        print(testCase)
