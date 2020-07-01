Problem Description:
    Given an array A of integers and integer K, return the maximum S such that there exists
    i < j with A[i] + A[j] = S and S < K. If no i, j exist satisfying this equation, return -1.

    1 <= A.length <= 100
    1 <= A[i] <= 1000
    1 <= K <= 2000

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

Time - O(nlogn), Space - O(logn -> N depending in the sort used)

// Optimisation2 (Sort and use Binary search for K - A[i])
    Sort and for each element Just search for K - A[i]
    Consider the left element to this A[i] (which is the max sum for this element < K)

    Time - O(nlogn), Space - O(logn -> N depending in the sort used)

// Optimisation3 (Counting sort using constraints)
    Making use of the constraints given to us
    we can count till 1000 and use two pointers on the sorted
    array

    init array
    Count Numbers in array

    while (lo < hi) {
        continue if either zero

        // logic Same as 1 with lo, hi representing numbers as well as index in count array
    }

    return result

Time -> O(n + m(hi - lo)), Space -> O(1000)