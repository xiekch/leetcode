import { TreeNode, buildTree, printTree } from './TreeUtils'

function convertBST(root: TreeNode | null): TreeNode | null {
    if (!root) return null
    let sum = 0
    let stack: TreeNode[] = []
    let node = root
    while (node || stack.length > 0) {
        while (node) {
            stack.push(node)
            node = node.right
        }
        node = stack.pop()
        sum += node.val
        node.val = sum
        node = node.left
    }
    return root
};

(() => {
    let testCases = [[4, 1, 6, 0, 2, 5, 7, null, null, null, 3, null, null, null, 8]]
    for (let testCase of testCases) {
        printTree(convertBST(buildTree(testCase)))
    }
})()