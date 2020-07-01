class Solution {
    public int arrangeCoins(int n) {
        int row = 1, completedRows = 0;
        while (n > 0) {
            if (n >= row) {
                n -= row;
                row++;
                completedRows++;
            } else {
                n = 0;
                row++;
            }
        }
        
        return completedRows;
    }

    // find K such that [K * (K + 1)] / 2 <= N
    public int arrangeCoinsBS(int n) {
        long lo = 0, hi = n;
        while (lo <= hi) {
            long mid = lo + (hi - lo) / 2;
            long coins = mid * (mid + 1) / 2;
            if (coins == n) return (int) mid;

            if (coins > n) hi = mid - 1;
            else lo = mid + 1;
        }

        return (int) hi;
    }
}