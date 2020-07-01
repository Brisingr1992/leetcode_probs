Problem Description:
    Given an array A of integers and integer K, return the maximum S such that there exists
    i < j with A[i] + A[j] = S and S < K. If no i, j exist satisfying this equation, return -1.

// Brute Force
    init result
    for i = 0 -> N
        for j = i + 1 -> N
            if (A[i] + A[j] < K) {
                store the max of currMax(result), currSum(A[i] + A[j])
            }
    return result // -1 if no such pair found

Time - O(n^2), Space - O(1)

// Optimisation1 (Sort and the use two pointers)
    sort array
    init i, j, result
    while (i < j) {
        if (A[i] + A[j] >= K) reduce j
        else store the max of currMax, currSum, increase i
    }

    return result // -1 if no such pair found