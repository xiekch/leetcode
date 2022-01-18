/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     public var val: Int
 *     public var left: TreeNode?
 *     public var right: TreeNode?
 *     public init() { self.val = 0; self.left = nil; self.right = nil; }
 *     public init(_ val: Int) { self.val = val; self.left = nil; self.right = nil; }
 *     public init(_ val: Int, _ left: TreeNode?, _ right: TreeNode?) {
 *         self.val = val
 *         self.left = left
 *         self.right = right
 *     }
 * }
 */
public class TreeNode {
    public var val: Int
    public var left: TreeNode?
    public var right: TreeNode?
    public init() { val = 0; left = nil; right = nil }
    public init(_ val: Int) { self.val = val; left = nil; right = nil }
    public init(_ val: Int, _ left: TreeNode?, _ right: TreeNode?) {
        self.val = val
        self.left = left
        self.right = right
    }
}

class Solution {
    private var prev: TreeNode?
    private var first: TreeNode?
    private var last: TreeNode?
    func recoverTree(_ root: TreeNode?) {
        recoverTreeRecursive(root)

        if let first = first, let last = last {
            swap(&(first.val), &(last.val))
        }
    }

    func recoverTreeRecursive(_ root: TreeNode?) {
        guard let root = root else { return }

        recoverTreeRecursive(root.left)
        if let prev = prev, prev.val > root.val, first == nil {
            first = prev
            last = root
        } else if let _ = first, let prev = prev, prev.val > root.val {
            last = root
        }

        prev = root

        recoverTreeRecursive(root.right)
    }
}

func test() {
    let node1 = TreeNode(1)
    let node3 = TreeNode(3)
    let node2 = TreeNode(2)
    let node4 = TreeNode(4)
    // let root = node1
    // root.left = node3
    // node3.right = node2

    let root = node3
    node3.left = node1
    node3.right = node4
    node4.left = node2

    let solution = Solution()
    solution.recoverTree(root)
    print(root.val)
    print(node3.val)
    print(node2.val)
}

test()
