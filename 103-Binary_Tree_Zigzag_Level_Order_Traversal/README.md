# [Problem Description](https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/)

Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

## Approach1
    Since have to collect nodes level by level, can use BFS for the problem.

    ```
        List<> can be linkedList / arrayList. Discuss pros and cons of using both data structures

        Init queue and add root
        At each level,
            init a new list to collect nodes data
            add the level data one by one by popping queue 
                - if level % 2 == 0 add normally
                - else at the end swap data
            add the next level's data to the queue
        update result list
        return result list
    ```
    Time Complexity - O(N), Space - O(N)

## Approach2
    We can also use level counter in dfs to identify nodes correctly
    for the level and add them to result with the help of a helper function.

    ```
        Main func
            Init list
            run a dfs to fill list acc to level with (root, depth, list)
            return list

        Helper func
            if root not null add to this level list the node's value
                - depth % 2 == 0, addLast
                - else addFirst (Here also LinkedList v/s arrayList)
            run dfs on left node with depth + 1
            run dfs on right node with depth + 1
    ```
    Time Complexity - O(N), Space - O(N)