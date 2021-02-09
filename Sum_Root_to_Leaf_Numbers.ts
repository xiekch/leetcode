// Definition for a binary tree node.
import { TreeNode, buildTree} from './TreeUtils'

function sumNumbers(root: TreeNode | null): number {
    return dfs(root, 0)
};

function dfs(node: TreeNode, cur: number): number {
    if (node == null) return 0
    cur = cur * 10 + node.val
    let sum = 0
    if (node.left) sum += dfs(node.left, cur)
    if (node.right) sum += dfs(node.right, cur)
    if (!node.left && !node.right) sum += cur
    return sum
}


(function(){
    let testCases = [[1,2,3],[4,9,0,5,1]]
    for(let testCase of testCases){
        console.log(sumNumbers(buildTree(testCase)))
    }
})()