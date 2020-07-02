# [Problem Description](https://leetcode.com/problems/reveal-cards-in-increasing-order/)
In a deck of cards, every card has a unique integer.  You can order the deck in any order you want.

Initially, all the cards start face down (unrevealed) in one deck.

Now, you do the following steps repeatedly, until all cards are revealed:

Take the top card of the deck, reveal it, and take it out of the deck.
If there are still cards in the deck, put the next top card of the deck at the bottom of the deck.
If there are still unrevealed cards, go back to step 1.  Otherwise, stop.
Return an ordering of the deck that would reveal the cards in increasing order.

The first entry in the answer is considered to be the top of the deck.

## Approach
Think in reverse

    - last card to come will be the MAX_VAL card
    - Before that will be second last card, which will have pushed it to last
    - And so on...

EXAMPLE: \[17,13,11,2,3,5,7\]

    - |17|
    - Add 13 (as we would have removed it first) |13|17|
    - Add 11 (Upon removal 11 would have moved 17 to last),
        so add 17 to top first and then add 11 |11|17|13
    - |7|13|11|17|
    - |5|17|7|13|11|
    - |3|11|5|17|7|13|
    - |2|13|3|11|5|17|7|
Now just fill the result array

```
    Init a deque / linkedList
    Init a result array
    Sort Array

    for i = N - 1 -> 0
        if (queue.empty()) {
            Just add A[i]
        } else {
            addLast element in queue to first
            add A[i] to first
        }
    
    Copy the queue to result array by polling first
    return result array
```
