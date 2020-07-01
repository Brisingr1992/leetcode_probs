Problem Description:
    Given an array of integers, return indices of the two numbers such that they add up to a specific target.
    You may assume that each input would have exactly one solution, and you may not use the same element twice.

// Brute Force
    for i = 0 -> N
        for j = i + 1 -> N
            if (A[i] + A[j] == target) return ans;

    No answer

Time - O(n^2), Space -> O(1)
Problems -> Algorithm correct but not scalable. Since exactly one solution, need to find
    a way to reduce complexity. Since A[j] = target - A[i], can just save the numbers and 
    check if A[j] is present in (i + 1:N)

// Optimisation 1: HashMap
    Keep storing numbers and their indexes in a HashMap 
        -> What if duplicate numbers present? Don't care just need the pair.
        -> Keep adding numbers with indexes, if at an i'th index we find the key target - A[i]
            => key was found earlier.
    for i = 0 -> N
        if (map.contains(target - A[i]))
            // found the pair
        else
            map.put(A[i], i);
    No answer

Time - O(n), Space - O(n)
Problems - Can we find a way to do it without O(n) space?
    Yeah, we can sort can use binarysearch but nlogn is worse than n!

