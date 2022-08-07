package Code.TreeTasks;

public class TreeNode {

    /*
         10
       /   \
      5    15
    /  \  / \
   4  7  12 14
     */

    TreeNode root;
    TreeNode left;
    TreeNode right;
    int value;

    static int pos = 0;

    public TreeNode(int value) {
        this.value = value;
        pos++;
    }

    public TreeNode(int value, TreeNode left, TreeNode right) {
        this.left = left;
        this.right = right;
        this.value = value;
    }

    public TreeNode getNode(int value) {
        TreeNode node = root;
        while (node != null) {
            int comp = node.value - value;
            if (comp == 0) {
                return node;
            }
            if (comp < 0) {
                node = node.left;
            } else {
                node = node.right;
            }
        }
        return null;
    }

    public void addNode(int value) {
        TreeNode node = root;
        TreeNode previous = null;

        while (node != null) {
            int comp = node.value - value;
            if (comp == 0) {
                return;
            } else {
                previous = node;
                if (comp < 0) {
                    node = node.right;
                } else {
                    node = node.left;
                }
            }
        }
        TreeNode newNode = new TreeNode(value);
        if (previous == null) {
            root = newNode;
        } else {
            int comp = previous.value - value;
            if (comp < 0) {
                previous.right = newNode;
            } else {
                previous.left = newNode;
            }
        }

    }

    public int getPos() {
        return pos;
    }
}
