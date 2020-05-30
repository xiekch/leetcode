import java.util.*

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class TreeUtils {
    companion object {
        private fun toNode(str: String): TreeNode? {
            if (str.isEmpty() || str.toLowerCase() == "null") {
                return null
            }
            return TreeNode(Integer.valueOf(str))
        }

        fun buildTree(nums: Array<String>): TreeNode? {
            if (nums.isEmpty() || toNode(nums[0]) == null)
                return null
            val root = toNode(nums[0]) ?: return null
            val qu = LinkedList<TreeNode>()
            qu.add(root)
            var i = 1
            while (i < nums.size) {
                if (qu.isEmpty()) {
                    break
                }
                val node = qu.poll()
                var next = toNode(nums[i])
                if (next != null) {
                    node.left = next
                    qu.add(next)
                }
                i++
                if (i < nums.size) {
                    next = toNode(nums[i])
                    if (next != null) {
                        node.right = next
                        qu.add(next)
                    }
                }
                i++
            }

            return root
        }

        fun printTree(root: TreeNode?) {
            if (root == null)
                return
            val qu = LinkedList<TreeNode?>()
            qu.add(root)
            var finished = false
            while (!qu.isEmpty() && !finished) {
                finished = true
                val levelNum = qu.size
                for (i in 0 until levelNum) {
                    val node = qu.poll()
                    if (node != null) {
                        finished = false
                        print("%d ".format(node.`val`))
                        qu.add(node.left)
                        qu.add(node.right)
                    } else {
                        System.out.printf("*")
                        qu.add(null)
                        qu.add(null)
                    }
                }
                println()
            }
        }

        fun getNode(
            root: TreeNode?,
            `val`: Int
        ): TreeNode? {
            if (root == null)
                return null
            if (root.`val` == `val`)
                return root
            var left = getNode(root.left, `val`)
            var right = getNode(root.right, `val`)
            if (left != null)
                return left
            return right
        }
    }
}