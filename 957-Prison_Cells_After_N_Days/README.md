# [Problem Description](https://leetcode.com/problems/prison-cells-after-n-days/)

There are 8 prison cells in a row, and each cell is either occupied or vacant.

Each day, whether the cell is occupied or vacant changes according to the following rules:

If a cell has two adjacent neighbors that are both occupied or both vacant, then the cell becomes occupied.
Otherwise, it becomes vacant.
(Note that because the prison is a row, the first and the last cells in the row can't have two adjacent neighbors.)

We describe the current state of the prison in the following way: cells[i] == 1 if the i-th cell is occupied, else cells[i] == 0.

### Approach1

Just do what the problem says:

```
int n = cells.length
for i = 0 -> N
    int[] newCells = new int[8];
    newCells[0] = 0
    for j = 1 -> n - 1
        newCells[j] = cells[i - 1] == cells[i + 1] ? 1 : 0
    newCells[n - 1] = 0
    cells = newCells
return cells
```

Time Complexity - O(N), Space - O(n)

### Approach2

Lets look at the state transition flow for a smaller array
Example: \[0,1,0,1\] -> \[0,1,1,0\] -> \[0,0,0,0\] -> \[0,1,1,0\] -> \[0,0,0,0\]

- Since first and last states wont change and we have 2 ^ 2 state changing at each iteration. It takes 2 days to start moving into cycles
- For 8 length array, there will be 64 states total and then a guaranteed cycle
- Hence, Upon encountering a cycle, we will repeat the same states over and over again.
- For the above example, lets say n = 10, if we know cycle length (2), then after finding the number of cycles, it will be always n % cycleLength

Lets run n = 10 on A = \[0,1,0,1\]

- Day(1): \[0,1,1,0\] len = 1
- Day(2): \[0,0,0,0\] len = 2
- Day(3): \[0,1,1,0\] Encountered before => length 2 found
- Since 10 % 2 == 0 need to do nothing. If n == 9 then we need to run cells n % 2 == 1 times as that many days will be left

```
init hashmap / hashSet
init a boolean if we ever encountered cycle
calculate cyclelength
if we encountered cycle need to run for n % cycle times
return update cells
```