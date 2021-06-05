class Solution:
    def simplifyPath(self, path: str) -> str:
        stack = []
        pathArr = path.split('/')
        for i in pathArr:
            if i == '.' or i == '':
                continue
            if i == '..':
                if len(stack) != 0:
                    stack.pop()
            else:
                stack.append(i)
        # print(stack)
        res = '/' + '/'.join(stack)
        return res


if __name__ == '__main__':
    solution = Solution()
    testCases = ["/home/", "/../", "/home//foo/", "/a/./b/../../c/"]
    for testCase in testCases:
        print(solution.simplifyPath(testCase))
