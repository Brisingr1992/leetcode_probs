# [Problem Description](https://leetcode.com/problems/longest-consecutive-sequence/)

Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

Your algorithm should run in O(n) complexity.

### Approach1

```
for i = 0 -> N
    init seqLength, next
    while array contains next
        update next
        update seqLength
    update maxSeq
return maxSeq
```

Time - O(M * N), Space - O(N)

### Approach2

```
Sort the array
find the continous range
update it
```

Can use a priorityQueue to do the same
Time - O(nlogn), Space - O(n)

### Approach3

- Optimise approach1 by using hashSet
- One way is to just keep checking for next number but this can be further optimised by observing that if we start only if n - 1 is not in the hashset we would have already calculated the longest sequence and will save recalculating (both duplicates and follwing numbers in series)!

```
init hashset and add numbers to it
for key in set
    if set doesnt contains key - 1
        Same logic as BF
        update maxLength
```

Time - O(n), Space - O(n)

### Approach4

- Union find can 