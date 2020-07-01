You have a total of n coins that you want to form in a staircase shape, where every k-th row must have exactly k coins.

Given n, find the total number of full staircase rows that can be formed.

n is a non-negative integer and fits within the range of a 32-bit signed integer.

// Approach #1
    Just do what the problem says -> iterate

// Approach #2
    Binary search for K such that (k * (k + 1)) / 2 <= n
    [Be mindful of product use long]

// Approach #3
    Math k * (k + 1) <= 2 * n
        => (k + 1/2)^2 <= 2 * n - 1 / 4
        => k <= sqrt(2 * n - 1/ 4) - 1/2;