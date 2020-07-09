# [Problem Description](https://leetcode.com/problems/trapping-rain-water/)

Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining. [Best Resource](https://www.youtube.com/watch?v=XqTBrQYYUcc)

### Approach1

- To know how much water can be trapped at a particular bar, what do I need?
- I need to know the max to the left and the max to the right!
    - If the min of these max > then this bar => water will be trapped

```
init result
for i = 0 -> N
    init left, right max vars
    for j = 0 -> i
        left = max(left, height[j])
    for j = i + 1 -> N
        right = max(right, height[j])
    
    if (min(left, right) > height[i]) update result
```

Time Complexity - O(n^2), Space - O(1)

### Approach2

- Main problem with the brute force is the inner loop to find the max element
- We can init two arrays and store max from left and right to cache the max at each index
    - To do this, observe how for first element leftMax is 0
    - for second element leftMax is the first element
    - for third one, leftMax is max of first and second
    - and so on and on

```
init result, left, right
init leftMax, rightMax

for i = 1, j = N - 2
    update leftMax[i] with left
    update rightMax[j] with right
    update left = max(left, height[i])
    update right = max(right, height[j])

for i = 0 -> N
    min = min(leftMax[i], rightMax[i])
    if (min > height[i]) collect rainwater

result
```

Time Complexity - O(n), Space complexity - O(n)

### Approach3

- Observation: max element divides the array into two parts (Divide and Conquer)
- At each step, from lo -> hi, find max element
- Divide the array into two parts lo -> idx - 1, idx + 1 -> hi
- When we find lMax and rMax we just calculate the trapped water

Time Complexity - O(n ^ 2), Space - O(n)

### Approach4

- Essence of problem: At each i, we are trying to find g(i) = min(max(0, i), max(i, N))
- Lower Envelope technique: Whenever we need to find minMax or maxMin like this, two pointer technique or binary search is the way to go!!
- leftMax function is always non-decreasing while rightMax is always non-increasing, and essentially we need the lower envelope to solve this problem which is g(i).