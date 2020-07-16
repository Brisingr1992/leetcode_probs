# [Problem Description](https://leetcode.com/problems/powx-n/)

Implement pow(x, n), which calculates x raised to the power n (xn).

- -100.0 < x < 100.0
- n is a 32-bit signed integer, within the range [−2^31, 2^31 − 1]

### Approach1

- Observation1: If n < 0, just multiply 1 / x n times
- Observation2: If n == -2 ^ 31 and we do n = -n, then n == 2 ^ 31 => overflow!!

```
long N = n
if (n < 0) x = 1 / x; N = -N;
for i = [N -> 0)
    result *= x
```

Time - O(n), Space - O(1)

### Appraoch2

- Observation to improve time: Upon multiplication of x and x, we can directly multiply to get x ^ 4.
- This implies logN complexity. Also, if n is even and we have gotten n / 2 then result is n/2 * n/2 pow result. But if n is odd the we have to reach n - 1 and multiply x

Time - O(logn), Space - O(logn)

Convert this to iterative and we save the call stack space!!