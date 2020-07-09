# [Problem Description](https://leetcode.com/problems/largest-rectangle-in-histogram/)

Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.

### Approach1

- At any rectangle, the max area it can form is with left till rectangles are >= this rectangle OR to the right where rectangles are >= its height.
- Example: \[2,1,2\]
    - At i = 0, 2 Can't go right or left => area 2
    - At i = 1, 1 can form a rectangle of size 3 to left and right
    - At i = 2, same as (0th)..
- Hence, just need to check at each index left and right area

```
init result
for i = 0 -> N
    init count
    for left = i - 1 -> 0
        if smaller rectangle just break

    for right = i + 1 -> N
        if smaller rectangle just break
    
    update result if greater area ((right - left - 1) * count)
return result
```

### Approach2

- Observation: In \[2,1,2\], 1 divides the rectangles into 2 parts
    - 1 can form area from 0 -> 2
    - 0 can go from 0 -> 0 same as 2 from 2 -> 2
- Can make use of this observation to use divide and conquer approach

```
From lo = 0 to hi = A.length - 1
    find minimum rectangle index
    area1 <- from lo to minIdx - 1 recursively
    area2 <- from minIdx + 1 to hi recursively

return max(area1, area2 and A[minIdx] * (hi - lo + 1))
```

Time O(nlogn) master's theorem Space O(n)

- In worst case (Sorted array) time will be O(n ^ 2)
- Can optimise finding minIdx using segment tree to make time O(nlogn) in worst case

### Approach3

- We can optimise brute force by caching the results in advance
- What to cache? minElement to the left AND min element to the right for each index

```
Using a stack calculate next smaller to the right from 0th index
Using a stack calculate next smaller element to the left from nth index

Now use BF logic with precalculated min left and right indices to calc area
```

Time - O(n), Space - O(n)

- We can do this without stack, by updating this logic to find minFromLeft

```
At i = x 
    int p = i - 1
    while (p >= 0 && heights[p] >= height[i]) p--;
```

- Since heights[p] >= height[i] element, its smaller element may be smaller then heights[i]

```
At i = x 
    int p = i - 1
    while (p >= 0 && heights[p] >= height[i]) p = left[p];

=> Can update cache in O(n) time without stack
```

### Approach5

- Idea is, we will consider every element a[i] to be a candidate for the area calculation. That is, if a[i] is the minimum element then what is the maximum area possible for all such rectangles? We can easily figure out that it's a[i]*(R-L+1-2) or a[i] * (R-L-1), where a[R] is first subsequent element(R>i) in the array just smaller than a[i], similarly a[L] is first previous element just smaller than a[i]. makes sense? (or take a[i] as a center and expand it to left and right and stop when first just smaller elements are found on both the sides). But how to implement it efficiently?

- We add the element a[i] directly to the stack if it's greater than the peak element (or a[i-1] ), because we are yet to find R for this. Can you tell what's L for this? Exactly, it's just the previous element in stack. (We will use this information later when we will pop it out).

- What if we get an element a[i] which is smaller than the peak value, it is the R value for all the elements present in stack which are greater than a[i]. Pop out the elements greater than a[i], we have their R value and L value(point 2). and now push a[i] and repeat..