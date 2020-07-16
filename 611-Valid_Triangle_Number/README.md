# [Problem Description](https://leetcode.com/problems/valid-triangle-number/)

Given an array consists of non-negative integers, your task is to count the number of triplets chosen from the array that can make triangles if we take them as side lengths of a triangle.

### Approach1

- Given three sides a, b, c, to be a triangle a + b > c, b + c > a and a + c > b

```
for i = 0 -> N - 2
    for j = i + 1 -> N - 1
        for k = j + 1 -> N
            if (i, j, k satisfy triangle property)
                inc count
```

Time - O(n^3), Space - O(1)

### Approach2

- Observation: If we sort the array a <= b <= c, so if we can find a c <= a + b, then we dont need to prove b + c and a + c as they will always be greater!
- Hence we can use binary search to optimise the inner loop and reduce time from n3 to n2logn

```
Sort array
for i = 0 -> N
    for j = 0 -> N
        search for nums[i] + nums[j] in range j + 1 -> N
        increase count by k - j - 1
```

Time - O(n2logn), Space - Depends on the sorting algorithm used

### Approach3

- Since we just need to find the right limit for k, such that nums[i] + nums[j] > k,
we can linearly search for that k!
- ex- 2,2,3,4,5 -> dont need to recompute for 3 again after computing for first 2

```
for i = 0 -> N
    for j = 0 -> N
        linearly search for k which satisfies condition
```