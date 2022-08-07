package Code.TreeTasks;

public class MaxTreeDepth {

    /*
     15
   /   \
  10    25
/  \  / \
5  8  20 30
           \
           35
 */

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(15,
                new TreeNode(10, new TreeNode(5), new TreeNode(8)),
                new TreeNode(25, new TreeNode(20), new TreeNode(30, new TreeNode(35), null)
                ));


        System.out.println(maxDepth(treeNode));
    }

    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        return left > right ? left + 1 : right + 1;
    }
}
