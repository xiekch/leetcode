from typing import List


class Solution:
    def fullJustify(self, words: List[str], maxWidth: int) -> List[str]:
        lines: List[str] = []
        bags: List[str] = []
        curLength = 0
        for word in words:
            if curLength + len(bags) + len(word) <= maxWidth:
                bags.append(word)
                curLength += len(word)
            else:
                spaceCount = maxWidth - curLength
                if len(bags) == 1:
                    lines.append(bags[0] + ' ' * spaceCount)
                else:
                    evenSpaceCount = spaceCount // (len(bags)-1)
                    evenSpace = ' ' * evenSpaceCount
                    # print(bags, spaceCount, evenSpaceCount)
                    surplus = spaceCount % (len(bags)-1)
                    line = bags[0]
                    for i, t in enumerate(bags[1:]):
                        line += evenSpace + (' ' if i < surplus else '') + t
                    lines.append(line)
                bags.clear()
                bags.append(word)
                curLength = len(word)
        if len(bags) != 0:
            spaceCount = maxWidth - curLength - len(bags) + 1
            lines.append(' '.join(bags) + ' ' * spaceCount)
        return lines


if __name__ == '__main__':
    testCases = [{'words': ["This", "is", "an", "example",
                  "of", "text", "justification."], 'maxWidth':16},
                 {'words': ["What", "must", "be", "acknowledgment", "shall", "be"], 'maxWidth': 16}]
    solution = Solution()
    for testCase in testCases:
        print(solution.fullJustify(testCase['words'], testCase['maxWidth']))
