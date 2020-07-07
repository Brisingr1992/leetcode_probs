import java.util.Queue;
import java.util.LinkedList;

public class Solution {
    public static boolean reachingPointsOPTIMAL(int sx, int sy, int tx, int ty) {
        while (tx >= sx && ty >= sy) {
            if (tx == sx && ty == sy) return true;
    
                if (tx > ty) {
                    if (ty > sy) tx %= ty;
                    else return (tx - sx) % ty == 0;
                } else {
                    if (tx > sx) ty %= tx;
                    else return (ty - sy) % tx == 0;
                }
            }
    
        return false;
    }

    public static boolean reachingPointsSUBTRACT(int sx, int sy, int tx, int ty) {
        while (tx >= sx && ty >= sy) {
            if (tx == sx && ty == sy) return true;
    
            if (tx > ty) tx -= ty;
            else ty -= tx;
        }
    
        return false;
    }

    public static boolean reachingPointsBFS(int sx, int sy, int tx, int ty) {
        Queue<int[]> queue = new LinkedList();
        queue.add(new int[] {sx, sy});
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            
            while (size-- > 0) {
                int[] currPos = queue.poll();
                if (currPos[0] == tx && currPos[1] == ty) return true;
                if (currPos[0] > tx || currPos[1] > ty) continue;
    
                int newPoint = currPos[0] + currPos[1];
                queue.add(new int[] {currPos[0], newPoint});
                queue.add(new int[] {currPos[0] + currPos[1], currPos[1]});
            }
        }
        
        return false;
    }

    public static boolean reachingPointsDFS(int sx, int sy, int tx, int ty) {
        if (sx == tx && sy == ty) return true;
        if (sx > ty || sy > ty) return false;
        
        return reachingPointsDFS(sx, sx + sy, tx, ty) || reachingPointsDFS(sx + sy, sy, tx, ty);
    }

    public static void main(String[] args) {
        // DFS
        System.out.println(reachingPointsDFS(1, 1, 3, 5));
        System.out.println(reachingPointsDFS(1, 1, 2, 2));
        System.out.println(reachingPointsDFS(1, 1, 1, 1));

        // BFS
        System.out.println(reachingPointsBFS(1, 1, 3, 5));
        System.out.println(reachingPointsBFS(1, 1, 2, 2));
        System.out.println(reachingPointsBFS(1, 1, 1, 1));

        // Bottom to top
        System.out.println(reachingPointsSUBTRACT(1, 1, 3, 5));
        System.out.println(reachingPointsSUBTRACT(1, 1, 2, 2));
        System.out.println(reachingPointsSUBTRACT(1, 1, 1, 1));
        System.out.println(reachingPointsSUBTRACT(35, 13, 455955547, 420098884));
        
        // Modulo Optimisation
        System.out.println(reachingPointsOPTIMAL(1, 1, 3, 5));
        System.out.println(reachingPointsOPTIMAL(1, 1, 2, 2));
        System.out.println(reachingPointsOPTIMAL(1, 1, 1, 1));
        System.out.println(reachingPointsOPTIMAL(35, 13, 455955547, 420098884));
        System.out.println(reachingPointsOPTIMAL(1, 10, 999999991, 10));
    }
}