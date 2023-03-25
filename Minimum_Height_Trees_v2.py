from typing import List


class Node:
    def __init__(self, id):
        self.id = id
        self.degree = 0
        self.next = []


# Topological Order
class Solution:
    def findMinHeightTrees(self, n: int, edges: List[List[int]]) -> List[int]:
        if n < 2:
            return list(range(n))
        nodes: List[Node] = [Node(id=i) for i in range(n)]
        for a, b in edges:
            nodes[a].degree += 1
            nodes[a].next.append(b)
            nodes[b].degree += 1
            nodes[b].next.append(a)

        # print(list(map(lambda n : "{} degree:{} next:{}".format(n.id,n.degree,n.next), nodes)))
        leaves = [i for i in nodes if i.degree == 1]
        remained = n
        while remained > 2:
            newLeaves = []
            for leave in leaves:
                remained -= 1
                nextNode: Node = nodes[leave.next[0]]
                nextNode.degree -= 1
                nextNode.next.remove(leave.id)
                if nextNode.degree == 1:
                    newLeaves.append(nextNode)
            leaves = newLeaves

        # print(list(map(lambda n : "{} degree:{} next:{}".format(n.id,n.degree,n.next), nodes)))

        return [i.id for i in leaves]


if __name__ == '__main__':
    testCases = [{'n': 4, 'edges': [[1, 0], [1, 2], [1, 3]]},
                 {'n': 6, 'edges': [[3, 0], [3, 1], [3, 2], [3, 4], [5, 4]]},
                 {'n': 1, 'edges': []},
                 {'n': 3, 'edges': [[0, 1], [0, 2]]}]
    for testCase in testCases:
        print(Solution().findMinHeightTrees(testCase['n'], testCase['edges']))
