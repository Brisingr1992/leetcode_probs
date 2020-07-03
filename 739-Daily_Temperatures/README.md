# [Problem Description](https://leetcode.com/problems/daily-temperatures/)

Given a list of daily temperatures T, return a list such that, for each day in the input, tells you how many days you would have to wait until a warmer temperature. If there is no future day for which this is possible, put 0 instead.

For example, given the list of temperatures T = [73, 74, 75, 71, 69, 72, 76, 73], your output should be [1, 1, 4, 2, 1, 1, 0, 0].

Note: The length of temperatures will be in the range [1, 30000]. Each temperature will be an integer in the range [30, 100].

### Approach1

```
for i = 0 -> N
    // find next greater temperature
    for j = i + 1 -> N
        if (T[j] > T[i])
            T[i] = j - i

return T
```

Time - O(N^ 2), Space - O(1)

### Approach2

- Since we have to find next greater element => Perfect use case for monotonic queue
- Keep pushing in stack till you find greater element
- example: 4,3,2,1,5 -> Keep pushing till you encounter next greater element

```
init deque/stack
for i = 0 -> N
    while stack not empty && top temp < curr Temp:
        Just update popped index with i - popped index
    push this temp to stack
// After highest one there may not be a pop
Fill the remaining temperature indices
return T array
```