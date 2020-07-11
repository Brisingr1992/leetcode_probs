# [Problem Description](https://leetcode.com/problems/out-of-boundary-paths/)

There is an m by n grid with a ball. Given the start coordinate (i,j) of the ball, you can move the ball to adjacent cell or cross the grid boundary in four directions (up, down, left, right). However, you can at most move N times. Find out the number of paths to move the ball out of grid boundary. The answer may be very large, return it after mod 10^9 + 7.

### Approach1

- If the ball goes out of grid, regardless of N its a way!
- If N == 0 meaning we are out of moves, then this is not a way
- Express this by a simple recursive function

Time - O(4 ^ N), Space - O(N)

### Approach2

- Top down optimisation, We can go on to multiple grid many times and hence there are overlapping subproblems!
- Cache the results for varying values of i, j, N

Time - O(mnN), Space - O(mnN)

### Approach3

- What is memo[i][j][N]? => It's equal to memo[x][y][N - 1] Always!
- Use this fact to capture state using loops!

Time - O(mnN), Space - O(mnN)

### Approach4

- Every time we are just using the moves for N - 1, we don't need the whole 3D array!
- Instead to save memory, we can just use a 2D array, create new array and update it, and them update the memo array with curr array!

Time - O(mnN), Space - O(mn)