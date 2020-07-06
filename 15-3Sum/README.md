# [Problem Description](https://leetcode.com/problems/3sum/)

Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note:

The solution set must not contain duplicate triplets.

### Approach1

- for i = 0 -> N
    - for j = i + 1 -> N
        - for k = j + 1 -> N
            - if (A[i] + A[j] + A[k] == target)
                - Add to the list

### Approach2

- for every index i
    - [i + 1, N] if there is pair that equals -A[i], we have found the pair
    - 2 sum for this range


### Approach3

- Since we just care about the 3 pair, sort the array
- for every index i
    - Now we can use two pointers approach to find pairs
