public class Solution {
    static final int MOD = 1_000_000_007;
    public static int findPathsBF(int m, int n, int N, int i, int j) {
        return pathsRecursive(m, n, N, i, j);
    }

    private static int pathsRecursive(int m, int n, int N, int i, int j) {
        if (i < 0 || j < 0 || i >= m || j >= n) return 1;
        if (N == 0) return 0;
        
        long ways = 0;
        ways += pathsRecursive(m, n, N - 1, i + 1, j);
        ways += pathsRecursive(m, n, N - 1, i - 1, j);
        ways += pathsRecursive(m, n, N - 1, i, j + 1);
        ways += pathsRecursive(m, n, N - 1, i, j - 1);
            
        return (int) (ways % MOD);
    }

    public static int findPathsTD(int m, int n, int N, int i, int j) {
        Integer[][][] memo = new Integer[m][n][N + 1];
        return pathsRecursive(m, n, N, i, j, memo);
    }

    private static int pathsRecursive(int m, int n, int N, int i, int j, Integer[][][] memo) {
        if (i < 0 || j < 0 || i >= m || j >= n) return 1;
        if (N == 0) return 0;
        
        if (memo[i][j][N] == null) {
            long ways = 0;
            ways += pathsRecursive(m, n, N - 1, i + 1, j, memo);
            ways += pathsRecursive(m, n, N - 1, i - 1, j, memo);
            ways += pathsRecursive(m, n, N - 1, i, j + 1, memo);
            ways += pathsRecursive(m, n, N - 1, i, j - 1, memo);
            
            memo[i][j][N] = (int) (ways % MOD);
        }

        return memo[i][j][N];
    }

    public static int findPathsBU(int m, int n, int N, int i, int j) {
        int[][][] memo = new int[m][n][N + 1];
        int[][] dirs = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for (int moves = 1; moves <= N; moves++) {
            for (int x = 0; x < m; x++) {
                for (int y = 0; y < n; y++) {
                    for (int[] dir: dirs) {
                        int a = x + dir[0], b = y + dir[1];
                        
                        long res = (a < 0 || b < 0 || a >= m || b >= n ? 1 : memo[a][b][moves - 1]);
                        memo[x][y][moves] = (int) ((memo[x][y][moves] + res) % MOD);
                    }
                }
            }
        }

        return memo[i][j][N];
    }

    public static int findPathsOPT(int m, int n, int N, int i, int j) {
        int[][] memo = new int[m][n];
        int[][] dirs = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for (int moves = 1; moves <= N; moves++) {
            int[][] temp = new int[m][n];
            for (int x = 0; x < m; x++) {
                for (int y = 0; y < n; y++) {
                    for (int[] dir: dirs) {
                        int a = x + dir[0], b = y + dir[1];
                        
                        long res = (a < 0 || b < 0 || a >= m || b >= n ? 1 : memo[a][b]);
                        temp[x][y] = (int) ((temp[x][y] + res) % MOD);
                    }
                }
            }
            
            memo = temp;
        }

        return memo[i][j];
    }

    public static void main(String[] args) {
        // Brute Force
        System.out.println(findPathsBF(2,2,2,0,0));
        System.out.println(findPathsBF(1,3,3,0,1));

        // Top Down Approach
        System.out.println(findPathsTD(2,2,2,0,0));
        System.out.println(findPathsTD(1,3,3,0,1));
        System.out.println(findPathsTD(50,50,30,20,20));

        // Bottom Up
        System.out.println(findPathsBU(2,2,2,0,0));
        System.out.println(findPathsBU(1,3,3,0,1));
        System.out.println(findPathsBU(50,50,30,20,20));

        // Bottom up space optimisation
        System.out.println(findPathsOPT(2,2,2,0,0));
        System.out.println(findPathsOPT(1,3,3,0,1));
        System.out.println(findPathsOPT(50,50,30,20,20));
    }
}