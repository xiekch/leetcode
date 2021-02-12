// Input: [1,2,3,null,5,null,4]
// Output: [1, 3, 4]
// Explanation:
//    1            <---
//  /   \
// 2     3         <---
//  \     \
//   5     4       <---
import { buildTree, TreeNode } from './TreeUtils'
function rightSideView(root: TreeNode | null): number[] {
    let ans: number[] = []
    if (!root) return ans
    let qu: TreeNode[] = [root]
    while (qu.length > 0) {
        let length = qu.length
        for (let i = 0; i < length; i++) {
            let node = qu.shift()
            if (node.left) qu.push(node.left)
            if (node.right) qu.push(node.right)
            if (i === length - 1) ans.push(node.val)
        }
    }
    return ans
};


(() => {
    let testcases = [[1, 2, 3, null, 5, null, 4], [1, 2, null, 3, 4, 5]]
    for (let testcase of testcases) {
        console.log(rightSideView(buildTree(testcase)))
    }
})()