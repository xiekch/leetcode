from typing import List


class Node:
    def __init__(self, id):
        self.id = id
        self.degree = 0
        self.next = []


# Topological Order
class Solution:
    def findMinHeightTrees(self, n: int, edges: List[List[int]]) -> List[int]:
        nodes: List[Node] = [Node(id=i) for i in range(n)]
        for a, b in edges:
            nodes[a].degree += 1
            nodes[a].next.append(b)
            nodes[b].degree += 1
            nodes[b].next.append(a)

        # print(list(map(lambda n : "{} degree:{} next:{}".format(n.id,n.degree,n.next), nodes)))
        res = [i for i in range(n)]
        while len(res) > 2:
            removeNodes = []
            for index in res:
                node = nodes[index]
                if node.degree == 1:
                    removeNodes.append(index)
            # print(removeNodes)
            for index in removeNodes:
                nodes[index].degree = 0
                for next in nodes[index].next:
                    nodes[next].degree -= 1
                    nodes[next].next.remove(index)
                res.remove(index)

        # print(list(map(lambda n : "{} degree:{} next:{}".format(n.id,n.degree,n.next), nodes)))

        return res


if __name__ == '__main__':
    testCases = [{'n': 4, 'edges': [[1, 0], [1, 2], [1, 3]]},
                 {'n': 6, 'edges': [[3, 0], [3, 1], [3, 2], [3, 4], [5, 4]]}]
    for testCase in testCases:
        print(Solution().findMinHeightTrees(testCase['n'], testCase['edges']))
