# [Problem Description](https://leetcode.com/problems/ugly-number/)

Write a program to check whether a given number is an ugly number.

Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.

### Approach1

Since we need to check every factor is 2,3 OR 5, keep dividing by these 3 till num becomes 1

```
while (num > 1 && num % 2 == 0) num /= 2;
while (num > 1 && num % 3 == 0) num /= 3;
while (num > 1 && num % 5 == 0) num /= 5;

return num == 1;
```