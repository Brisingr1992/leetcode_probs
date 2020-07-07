# [Problem Description](https://leetcode.com/problems/reaching-points/)

A move consists of taking a point (x, y) and transforming it to either (x, x+y) or (x+y, y).

Given a starting point (sx, sy) and a target point (tx, ty), return True if and only if a sequence of moves exists to transform the point (sx, sy) to (tx, ty). Otherwise, return False.

### Approach1

- Do what problem says recursively
- Idea1: if sx > tx || sy > ty no way to reach target as all numbers positive
- Idea2: Can keep making moves recursivly until reaching idea1

```
public boolean reachingPoints(int sx, int sy, int tx, int ty) {
    if (sx == tx && sy == ty) return true;
    if (sx > ty || sy > ty) return false;
    
    return reachingPoints(sx, sx + sy, tx, ty) || reachingPoints(sx + sy, sy, tx, ty);
}
```

Time Complexity O(2 ^ (tx + ty)) Space - O(tx*ty)

### Approach2

- Can use BFS for the shortest path

```
public boolean reachingPoints(int sx, int sy, int tx, int ty) {
    Queue<int[]> queue = new LinkedList();
    queue.add(new int[] {sx, sy});
    
    while (!queue.isEmpty()) {
        int size = queue.size();
        
        while (size-- > 0) {
            int[] currPos = queue.poll();
            if (currPos[0] == tx && currPos[1] == ty) return true;
            if (currPos[0] > tx || currPos[1] > ty) continue;

            int newPoint = currPos[0] + currPos[1];
            queue.add(new int[] {currPos[0], newPoint});
            queue.add(new int[] {currPos[0] + currPos[1], currPos[1]});
        }
    }
    
    return false;
}
```
Time Complexity O(2 ^ (tx + ty)) Space - O(tx*ty)

### Approach3

- Approach this backwards (from tx, ty to sx. sy)
- Example point: (19, 12) => Since all points positive last point to reach this point must be (7, 12) => similar logic (7, 5) => (2, 5) and so on....

```
public boolean reachingPoints(int sx, int sy, int tx, int ty) {
    while (tx >= sx && ty >= sy) {
        if (tx == sx && ty == sy) return true;

        if (tx > ty) tx -= ty;
        else ty -= tx;
    }

    return false;
}
```
Time Complexity O(max(tx, ty)) Space - O(1)

### Approach4

- Modify approach3 using modulo
- Lets say sx = 7, sy = 12, tx = 19, ty = 12
    - we know since tx > ty => subtract 19 by 12
    - 12 is never going to change as its equal to sy
    - tx is going to change to reach sx => we will subtract tx by ty always!
    - Hence, tx - sx should be divisible by ty, otherwise cant reach sx;

```
public boolean reachingPoints(int sx, int sy, int tx, int ty) {
    while (tx >= sx && ty >= sy) {
        if (tx == sx && ty == sy) return true;

            if (tx > ty) {
                if (ty > sy) tx %= ty;
                else return (tx - sx) % ty == 0;
            } else {
                if (tx > sx) ty %= tx;
                else return (ty - sy) % tx == 0;
            }
        }

    return false;
}
```
Time Complexity O(log(max(tx + ty))) Space - O(1)