import java.util.*;
import utils.TreeNode;

public class Solution {
    public List<List<Integer>> zigzagLevelOrderDFS(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        dfs(root, 0, ans);
        return ans;
    }
    
    private void dfs(TreeNode root, int depth, List<List<Integer>> ans) {
        if (root == null) return;
        
        if (depth == ans.size()) ans.add(new ArrayList<>());
        
        if (depth % 2 == 0) {
            ans.get(depth).add(root.val);
        } else {
            ans.get(depth).add(0, root.val);
        }
        
        dfs(root.left, depth + 1, ans);
        dfs(root.right, depth + 1, ans);
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<>();
        
        if (root == null) return ans;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        int level = 0;
        while (!q.isEmpty()) {
            int size = q.size(), mode = level % 2;
            LinkedList<Integer> levelData = new LinkedList<>();
            
            while (size-- > 0) {
                TreeNode node = q.poll();
                
                if (mode == 0) {
                    levelData.add(node.val);
                } else {
                    levelData.addFirst(node.val);
                }
                
                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
            }
            
            ans.add(levelData);
            level++;
        }
        
        return ans;
    }
}