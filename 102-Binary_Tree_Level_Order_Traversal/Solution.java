import java.util.*;
import utils.TreeNode;

public class Solution {
    private List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) queue.add(root);
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> currLevel = new ArrayList<>();
            
            while (size-- > 0) {
                TreeNode node = queue.poll();
                currLevel.add(node.val);
                
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            
            result.add(currLevel);
        }

        // for (int i = 0, j = result.size() - 1; i < result.size() / 2; i++, j--) {
        //     Collections.swap(result, i, j);
        // }
        
        return result;        
    }

    private List<List<Integer>> levelOrderDFS(TreeNode root) {
        List<List<Integer>> res = new ArrayList();
        
        if (root == null) return res;
        
        dfs(root, 0, res);
        return res;
    }
    
    private void dfs(TreeNode root, int depth, List<List<Integer>> res) {
        if (root == null) return;
        
        if (res.size() == depth) res.add(new ArrayList<>());
        
        res.get(depth).add(root.val);
        dfs(root.left, depth + 1, res);
        dfs(root.right, depth + 1, res);
    }
    public static void main(String[] args) {
        // Create a tree and check level order
    }
}