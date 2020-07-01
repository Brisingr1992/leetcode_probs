Problem Description:
    Design and implement a TwoSum class. It should support the following operations: add and find.

    add - Add the number to an internal data structure.
    find - Find if there exists any pair of numbers which sum is equal to the value.

// Approach #1
    Use a list to store numbers

    init() -> Init the list;
    add()
        -> Way1 - just add to the list and then upon find we can use twoSum approaches
        -> Do binarySearch on list and insert at position (can use two pointers than)

    find()
        -> If way1 then refer to twoSum (Two loops, sort list and two pointers OR hashMap ont)
        -> If way2 - just use two pointers

// Approach #2
    Use a hashMap to store numbers and their counts

    init() -> Init the hashMap

    add() -> just add to hashmap and increase the count
    find()
        -> for every key in map
            -> find target - key { if complement == key OR not }
