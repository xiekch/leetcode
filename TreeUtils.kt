import java.util.*

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class TreeUtils {
    companion object {
        fun buildTree(nums: Array<Int?>): TreeNode? {
            if (nums.isEmpty())
                return null
            val root = TreeNode(nums[0]!!)
            val qu = LinkedList<TreeNode>()
            qu.add(root)
            var i = 1
            while (i < nums.size) {
                if (qu.isEmpty()) {
                    break
                }
                val node = qu.poll()!!
                nums[i]?.let {
                    TreeNode(it)
                }?.let {
                    node.left = it
                    qu.add(it)
                }
                i++
                if (i < nums.size) {
                    nums[i]?.let {
                        TreeNode(it)
                    }?.let {
                        node.right = it
                        qu.add(it)
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
            val left = getNode(root.left, `val`)
            val right = getNode(root.right, `val`)
            if (left != null)
                return left
            return right
        }
    }
}