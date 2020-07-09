import java.util.*;
import utils.TreeNode;
public class Solution {
    static int maxWidth;
    public static int widthOfBinaryTreeDFS(TreeNode root) {        
        maxWidth = 0;
        Map<Integer, Integer> map = new HashMap();
        dfs(root, 0, 0, map);
        
        return maxWidth;
    }
    
    private static void dfs(TreeNode node, int depth, int id, Map<Integer, Integer> map) {
        if (node == null) return;
        
        if (!map.containsKey(depth)) {
            map.put(depth, id);
        }

        maxWidth = Math.max(maxWidth, id - map.get(depth) + 1);
        
        dfs(node.left, depth + 1, 2 * id + 1, map);
        dfs(node.right, depth + 1, 2 * id + 2, map);
    }

    static class Node {
        TreeNode node;
        int id;
        
        public Node(TreeNode node, int id) {
            this.node = node;
            this.id = id;
        }
    }

    public static int widthOfBinaryTreeBFS(TreeNode root) {
        if (root == null) return 0;
        
        int result = 0;
        Queue<Node> queue = new LinkedList();
        queue.add(new Node(root, 0));
        
        while (!queue.isEmpty()) {
            int size = queue.size(), min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
            while (size-- > 0) {
                Node node = queue.poll();
                TreeNode n = node.node;
    
                min = Math.min(node.id, min);
                max = Math.max(node.id, max);
                
                if (n.left != null) queue.add(new Node(n.left, 2 * node.id + 1));
                if (n.right != null) queue.add(new Node(n.right, 2 * node.id + 2));
            }
            
            result = Math.max(result, max - min + 1);
        }
        
        return result;
    }
}