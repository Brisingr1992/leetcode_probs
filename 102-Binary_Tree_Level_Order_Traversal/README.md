# [Problem Description](https://leetcode.com/problems/binary-tree-level-order-traversal/)

Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level). 

### Similar Questions
 [107-level-order-II](https://leetcode.com/problems/binary-tree-level-order-traversal-ii/)
 [429-N-ary-Tree-Level-Order-Traversal](https://leetcode.com/problems/n-ary-tree-level-order-traversal/)



## Approach1
    Since have to collect nodes level by level, can use BFS for the problem.

    ```
        Init queue and add root
        At each level,
            init a new list to collect nodes data
            add the level data one by one by popping queue
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
            run dfs on left node with depth + 1
            run dfs on right node with depth + 1
    ```

