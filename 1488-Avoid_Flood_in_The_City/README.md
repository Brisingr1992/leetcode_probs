# [Problem Description](https://leetcode.com/problems/avoid-flood-in-the-city/)

Your country has an infinite number of lakes. Initially, all the lakes are empty, but when it rains over the nth lake, the nth lake becomes full of water. If it rains over a lake which is full of water, there will be a flood. Your goal is to avoid the flood in any lake.

Given an integer array rains where:

rains[i] > 0 means there will be rains over the rains[i] lake.
rains[i] == 0 means there are no rains this day and you can choose one lake this day and dry it.
Return an array ans where:

ans.length == rains.length
ans[i] == -1 if rains[i] > 0.
ans[i] is the lake you choose to dry in the ith day if rains[i] == 0.
If there are multiple valid answers return any of them. If it is impossible to avoid flood return an empty array.

Notice that if you chose to dry a full lake, it becomes empty, but if you chose to dry an empty lake, nothing changes.

## Approach

- Upon encountering a dryDay (0), we dont know which lake to dry!
- So need to save it somewhere and upon encountering a filledLake
    - go to a dryDay which is after the day the lake was filled 
    - and dry it! If cant then flood is unavoidable!

```
Init a hashMap, TreeSet(for ceiling and floor) OR List via BinarySearch, result array
for i = 0 -> N
    if (A[i] == 0) {
        just add it to dryDay
        update result[i] = 1 // will be updating later
    } else {
        if (already filled) {
            idx <- getDayIdx
            get next dryDay

            if (we can get next dryDay) {
                update result[i]
                remove this lake from flooded Lakes
                remove dryDay as we already used to dry lake
            } else {
                // flood unavoidable return
            }
        }

        update result[i] <- -1
        add this lake to floodList
    }
```