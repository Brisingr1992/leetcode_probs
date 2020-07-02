import java.util.*;
import utils.TreeNode;

public class Solution {
    List<Integer> result;
    int index;
    int[] voyage;
    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        this.result = new ArrayList<>();
        this.index = 0;
        this.voyage = voyage;
        
        dfs(root);
        return result;
    }
    
    private void dfs(TreeNode root) {
        if (root == null) return;
        
        if (root.val != voyage[index++]) {
            result.clear();
            result.add(-1);
        } else {
            if (root.left != null && root.left.val != voyage[index]) {
                result.add(root.val);
                dfs(root.right);
                dfs(root.left);
            } else {
                dfs(root.left);
                dfs(root.right);
            }
        }
    }
}