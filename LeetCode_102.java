import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LeetCode_102 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        
        TreeNode() {}
        
        TreeNode(int val) {
            this.val = val;
        }
        
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> result = new ArrayList<>();
            if (root == null)
                return result;
            var queue = new LinkedList<TreeNode>();
            queue.add(root);
            while (!queue.isEmpty()) {
                ArrayList<Integer> currentlvl = new ArrayList<>();
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    TreeNode curr = queue.poll();
                    currentlvl.add(curr.val);
                    if (curr.left != null)
                        queue.add(curr.left);
                    if (curr.right != null)
                        queue.add(curr.right);
                }
                result.add(currentlvl);
            }
            return result;
        }
    }

    public static void main(String[] args) {
        LeetCode_102.TreeNode root = new LeetCode_102.TreeNode(3);
        root.left = new LeetCode_102.TreeNode(9);
        root.right = new LeetCode_102.TreeNode(20);
        root.right.left = new LeetCode_102.TreeNode(15);
        root.right.right = new LeetCode_102.TreeNode(7);

        LeetCode_102.TreeNode solution = new LeetCode_102.TreeNode();
        List<List<Integer>> result = solution.levelOrder(root);

        System.out.println("Input Tree:");
        printTree(root, 0);

        System.out.println("\nOutput Level Order Traversal:");
        for (List<Integer> level : result) {
            System.out.println(level);
        }
    }

    private static void printTree(LeetCode_102.TreeNode root, int level) {
        if (root == null)
            return;

        printTree(root.right, level + 1);
        for (int i = 0; i < level; i++)
            System.out.print("   ");
        System.out.println(root.val);
        printTree(root.left, level + 1);
    }
}
