class TreeNode {
    val: number
    left: TreeNode | null
    right: TreeNode | null
    constructor(val?: number, left?: TreeNode | null, right?: TreeNode | null) {
        this.val = (val === undefined ? 0 : val)
        this.left = (left === undefined ? null : left)
        this.right = (right === undefined ? null : right)
    }
}

function buildTree(nums: number[]): TreeNode | null {
    if (nums.length === 0) return null
    let root = new TreeNode(nums[0])
    let qu = new Array<TreeNode>()
    qu.push(root)
    for (let i = 1; i < nums.length && qu.length > 0;) {
        let node = qu.shift()
        if (nums[i] !== null) {
            node.left = new TreeNode(Number(nums[i]))
            qu.push(node.left)
        }
        i++
        if (i < nums.length && nums[i] !== null) {
            node.right = new TreeNode(Number(nums[i]))
            qu.push(node.right)
        }
        i++
    }

    return root
}

function printTree(root: TreeNode) {
    if (root == null)
        return
    let qu = new Array<TreeNode>();
    qu.push(root);
    let finished = false;
    while (qu.length > 0 && !finished) {
        finished = true;
        let levelNum = qu.length;
        let str = ''
        for (let i = 0; i < levelNum; i++) {
            let node = qu.shift();
            if (node !== null) {
                finished = false;
                str += `${node.val} `;
                qu.push(node.left);
                qu.push(node.right);
            } else {
                str += '* ';
                qu.push(null);
                qu.push(null);
            }
        }
        console.log(str);
    }
}

// (function () {
//     printTree(buildTree([1, 2, 3, 4, 5, null, null, 0]))
// })()

export { TreeNode, buildTree, printTree }
