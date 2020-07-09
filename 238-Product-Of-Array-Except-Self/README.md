# [Problem Description](https://leetcode.com/problems/product-of-array-except-self/)

Given an array nums of n integers where n > 1,  return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].

Constraint: It's guaranteed that the product of the elements of any prefix or suffix of the array (including the whole array) fits in a 32 bit integer.

Note: Please solve it without division and in O(n).

Follow up:
Could you solve it with constant space complexity? (The output array does not count as extra space for the purpose of space complexity analysis.)


### Approach1

- for every element i
    - calc the product from 0 -> N except i

Time - O(n^2), Space -> O(n)

### Approach2

- Instead of calculating for each element, we can cache the results in left and right array

### Approach3

- Optimise approach2 by calculating left and then calculating right on the fly

## Follow Up [IMP!]

Since output array doesnt count as space, we can precalculate the left product using output array and reduce the space complexity.