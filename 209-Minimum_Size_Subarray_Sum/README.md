# [Problem Description](https://leetcode.com/problems/minimum-size-subarray-sum/)

Given an array of n positive integers and a positive integer s, find the minimal length of a contiguous subarray of which the sum ≥ s. If there isn't one, return 0 instead.

### Approach1

```
int result = A.length
for i = 0 -> N
    int sum = 0
    for j = i -> N
        sum += A[j]
        if (sum >= s)
            update result <- min(result, j - i + 1)
            break

return result
```

Time - O(n ^ 2), Space - O(1)

### Approach2

Use prefix sums: \[2,3,1,2,4,3\] | s = 7 -> \[0, 2, 5, 6, 8, 12, 15\]

Since all positive numbers, the prefix sum will be increasing => sorted => can use binary search to find ceiling

```
init prefixSums
fill prefix sums

for i = 0 -> N
    int key = prefixSums[i] + s
    find lower bound for key using binary search
    if valid lowerbound update result
return result
```

Time - O(nlogn), Space - O(n)

### Approach3

To optimise BF, Can make use of the sliding window pattern. As the sum reaches >= s,
we can shrink window and when it becomes < s, then just resume!!

```
init windowStart, result, sum
for windowEnd = 0 -> N
    sum += A[windowEnd]
    while (sum >= k)
        record minLength windowEnd - windowStart + 1
        update windowStart
return windowEnd
```
