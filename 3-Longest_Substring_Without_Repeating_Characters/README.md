# [Problem Description](https://leetcode.com/problems/longest-substring-without-repeating-characters/)

Given a string, find the length of the longest substring without repeating characters.

### Approach1

- For every index i, maintain a set of different chars
    - when a diff char is found break the loop and calc the result

```
init result
for i = 0 -> N
    init set
    for j = i -> N
        if char already exists in set
            break
        else
            add char to set
    result = max(result, j - i)
return result
```

Time - O(n^2) Space - O(128)

### Approach2

- We can utilise sliding window to optimise this problem
- As we add a char, check if its repeated
    - breaks the condition move windowStart
    - if not calc the result
    - As a result, we go over the array atmost two times
