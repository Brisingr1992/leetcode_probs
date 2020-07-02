# [Problem Description](https://leetcode.com/problems/flip-binary-tree-to-match-preorder-traversal/)


Given a binary tree with N nodes, each node has a different value from {1, ..., N}.

A node in this binary tree can be flipped by swapping the left child and the right child of that node.

Consider the sequence of N values reported by a preorder traversal starting from the root.  Call such a sequence of N values the voyage of the tree.

(Recall that a preorder traversal of a node means we report the current node's value, then preorder-traverse the left child, then preorder-traverse the right child.)

Our goal is to flip the least number of nodes in the tree so that the voyage of the tree matches the voyage we are given.

If we can do so, then return a list of the values of all nodes flipped.  You may return the answer in any order.

If we cannot do so, then return the list [-1].

## Approach1

- Misleading statement `flip the least number of nodes`
- If while voyaging, values mismatch => clear result and add -1
    - else if mismatch found at next index at left, flip the node and check

```
if (root.val != voyage[idx]) {
    clear list
    add -1 to it
} else {
    if (root.left != null && root.left.val == voyage[idx]) {
        // Instead of swapping just traverse right rather than left [Optimisation]
        add root.val to list
        traverse right
        traverse left
    } else {
        traverse left
        traverse right
    }
}
```