# [Problem Description](https://leetcode.com/problems/maximum-width-of-binary-tree/)

Given a binary tree, write a function to get the maximum width of the given tree. The width of a tree is the maximum width among all levels. The binary tree has the same structure as a full binary tree, but some nodes are null.

The width of one level is defined as the length between the end-nodes (the leftmost and right most non-null nodes in the level, where the null nodes between the end-nodes are also counted into the length calculation.

### Approach1

- Can use BFS on the tree, as we just care about width of first element and last element
- But since nodes can be null, and first, last elements may have a lot of nulls between them!
- So can't use regular BFS, instead use the approach used in heaps to denominate trees
- The two children will be 2*i + 1, 2 * i + 2, using this we need to assign ids to nodes while parsing
- That way we just have to subtract last - first id's to get the max width

```
init a pair class OR a java class blueprint
init queue
add root, 0 id to queue

Now run BFS while updating ids and recording max width till that level
```

Time Complexity - O(n), Space Complexity - O(max width)

### Approach2

- DFS can go in preorder fashion using indexes
- At each level if that level data is not there addAt 0, else at 1
- Use a hashMap to store min level id and update on each next id to check if it increases width