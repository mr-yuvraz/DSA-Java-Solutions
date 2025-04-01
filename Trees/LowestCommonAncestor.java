class TreeNode { int val; TreeNode left, right; TreeNode(int val) { this.val = val; } }

public class LowestCommonAncestor {

// Function to find the lowest common ancestor (LCA) of two nodes
public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null || root == p || root == q) {
        return root;
    }

    TreeNode left = lowestCommonAncestor(root.left, p, q);
    TreeNode right = lowestCommonAncestor(root.right, p, q);

    if (left != null && right != null) {
        return root; // Both nodes are found in different subtrees
    }

    return (left != null) ? left : right; // Return the non-null node
}

public static void main(String[] args) {
    TreeNode root = new TreeNode(3);
    root.left = new TreeNode(5);
    root.right = new TreeNode(1);
    root.left.left = new TreeNode(6);
    root.left.right = new TreeNode(2);
    root.right.left = new TreeNode(0);
    root.right.right = new TreeNode(8);
    root.left.right.left = new TreeNode(7);
    root.left.right.right = new TreeNode(4);

    TreeNode p = root.left; // Node 5
    TreeNode q = root.left.right.right; // Node 4

    TreeNode lca = lowestCommonAncestor(root, p, q);
    System.out.println("Lowest Common Ancestor: " + (lca != null ? lca.val : "None"));
}

}
