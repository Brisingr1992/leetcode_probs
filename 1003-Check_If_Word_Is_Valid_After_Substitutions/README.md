# [Problem Description](https://leetcode.com/problems/check-if-word-is-valid-after-substitutions/)

We are given that the string "abc" is valid.

From any valid string V, we may split V into two pieces X and Y such that X + Y (X concatenated with Y) is equal to V.  (X or Y may be empty.)  Then, X + "abc" + Y is also valid.

If for example S = "abc", then examples of valid strings are: "abc", "aabcbc", "abcabc", "abcabcababcc".  Examples of invalid strings are: "abccba", "ab", "cababc", "bac".

Return true if and only if the given string S is valid.

## Approach1

- Essentially just keep removing "abc" till you can't!
- If S is formed using valid split of abc it will result in an empty String

```
String V = "abc";
while (S.contains(V)) {
    S = S.replace(V, "");
}

return S.length() == 0;
```

Time Complexity: O(M * N)

## Approach2

- We can use a stack to remove 'abc' when we encounter a 'c'.
- That way we can remove all valid 'abc' in linear time

```
Init Stack
for i = 0 -> N
    if char is 'c'
        then check for last 2 chars
        if a and b char then remove them and dont add c
        else just add c to the stack
check stack is empty()
```

Time - O(N), Space - (N)